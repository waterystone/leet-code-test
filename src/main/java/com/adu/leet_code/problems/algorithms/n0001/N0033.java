package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 *
 * @author yunjie.du
 * @date 2017/7/28 14:39
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/tabs/description">33. Search in Rotated
 *      Sorted Array</a>
 */
public class N0033 {
    /**
     * 思想：先找到旋转点的下标，再判断目标值位于左边的递增区还是右边的递增区，继而在相应递增区进行二分查找。
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        int pivotIndex = findPivotIndex(nums);// 找到旋转点的下标
        if (pivotIndex > 0) {// 旋转点存在
            if (target >= nums[0]) {// 位于左边递增区间
                right = pivotIndex - 1;
            } else {// 右边
                left = pivotIndex;
            }
        }

        // 二分查找
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 寻找旋转点的下标
     * 
     * @param nums
     * @return -1表示不存在。
     */
    private int findPivotIndex(int[] nums) {
        if (nums[nums.length - 1] >= nums[0]) {// 非旋转
            return -1;
        }

        int i = 0, j = nums.length - 1;
        while (i < j) {// i一直在左递增区间递增，j一直在右递增区间递减，直到i与j相邻
            if (i == j - 1) {// i与j逼近到相邻
                return j;
            }

            int mid = (i + j) >> 1;
            if (nums[mid] > nums[i]) {// 中间值在左区间
                i = mid;
            } else {// 中间值在右区间
                j = mid;
            }
        }

        return -1;// just fake.
    }

}
