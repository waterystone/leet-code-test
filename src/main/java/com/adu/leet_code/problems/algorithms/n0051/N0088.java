package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
 * from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * @author yunjie.du
 * @date 2017/8/11 15:20
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/description/">88. Merge Sorted Array</a>
 */
public class N0088 {
    /**
     * 思想：从大往小插入nums1。
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;// k为合并后nums1的当前下标，从后往前
        while (i >= 0 && j >= 0) {// 依次拿出较大的放在k的位置
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (i >= 0) {// 如果nums1还没完
            nums1[k--] = nums1[i--];
        }

        while (j >= 0) {// 如果nums2还没完
            nums1[k--] = nums2[j--];
        }
    }
}
