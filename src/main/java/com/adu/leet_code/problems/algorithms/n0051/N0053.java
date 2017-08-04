package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * <pre>
 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/4 11:35
 * @see <a href="https://leetcode.com/problems/maximum-subarray/description/">53. Maximum Subarray</a>
 */
public class N0053 {
    /**
     * 思想：一直叠加，并判断叠加和是否大于记录的最大和。如果叠加和为负，则重新从零开始叠加。
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            if (max < 0 && num < 0 && num > max) {// 如果一直都是负数
                max = num;
                continue;
            }

            // 有过正数了
            sum += num;
            if (sum < 0) {
                sum = 0;
                continue;
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
