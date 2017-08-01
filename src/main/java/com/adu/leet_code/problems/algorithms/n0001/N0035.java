package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * <pre>
 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/1 11:07
 * @see <a href="https://leetcode.com/problems/search-insert-position/description/">35. Search Insert Position</a>
 */
public class N0035 {
    /**
     * 二分查找。
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;// just fake.
    }
}
