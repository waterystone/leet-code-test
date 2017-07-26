package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.<br/>
 * Do not allocate extra space for another array, you must do this in place with constant memory.<br/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * <pre>
 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/26 16:31
 * @see <a href="https://leetcode.com/problems/remove-element/#/description">Remove Element</a>
 */
public class N0027 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
