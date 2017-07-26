package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new
 * length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example, Given input array nums = [1,1,2], Your function should return length = 2, with the first two elements of
 * nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * 
 * @author yunjie.du
 * @date 2017/7/26 15:50
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description">Remove Duplicates from
 *      Sorted Array</a>
 */
public class N0026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}
