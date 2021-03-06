package com.adu.leet_code.problems.algorithms.n0001;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * <pre>
 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 * </pre>
 * 
 * <pre>
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/19 17:57
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/#/description">Median of Two Sorted Arrays</a>
 */
public class N0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = -1, totalCount = nums1.length + nums2.length;
        int medianCount = totalCount / 2;// 总数里中位数的的下标。奇数即为中位数的下标，偶数为后一个数的下标。
        boolean isTotalCountEven = totalCount % 2 == 0;// 总数是否偶数
        int prev = 0, next = 0;// 前值和后值

        while (i < nums1.length && j < nums2.length) {// merge
            k++;
            int min;
            if (nums1[i] < nums2[j]) {
                min = nums1[i++];
            } else {
                min = nums2[j++];
            }

            if (isTotalCountEven && k == medianCount - 1) {// 偶数则记录前值
                prev = min;
            } else if (k == medianCount) {// 记录中位数
                next = min;
                break;
            }

        }

        while (k < medianCount && i < nums1.length) {// 第一个数组还有剩余
            k++;
            if (isTotalCountEven && k == medianCount - 1) {// 记录前值
                prev = nums1[i];
            } else if (k == medianCount) {// 记录中位数
                next = nums1[i];
                break;
            }

            i++;
        }

        while (k < medianCount && j < nums2.length) {// 第二个数组还有剩余
            k++;
            if (isTotalCountEven && k == medianCount - 1) {// 记录前值
                prev = nums2[j];
            } else if (k == medianCount) {// 记录中位数
                next = nums2[j];
                break;
            }

            j++;
        }

        return isTotalCountEven ? (prev + next) / 2.0 : next;
    }
}
