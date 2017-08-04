package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * <pre>
 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/4 15:24
 * @see <a href="https://leetcode.com/problems/jump-game/description/">55. Jump Game</a>
 */
public class N0055 {
    /**
     * 思想：在本次可跳区间内，计算下一跳的区间范围，不断往下跳。
     * 
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }

        int left = 0, right = 0;// 本次可跳的区间下标
        while (right < nums.length) {
            int farest = right;
            for (int i = left; i <= right; i++) {// 计算下跳的最大位置
                farest = Math.max(farest, nums[i] + i);
                if (farest >= nums.length - 1) {// 如果可直达终点
                    return true;
                }
            }

            if (farest == right) {// 如果最远也跳不出本次区间
                return false;
            }

            left = right + 1;
            right = farest;
        }

        return true;
    }
}
