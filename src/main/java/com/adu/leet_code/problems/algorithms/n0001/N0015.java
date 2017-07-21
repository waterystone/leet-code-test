package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * <pre>
 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/21 18:06
 * @see <a href="https://leetcode.com/problems/3sum/#/description">3Sum</a>
 */
public class N0015 {
    /**
     * 思路：先排序，对于每个元素，转化为求后边序列中和为该元素相反数的两个数。
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);// 先排序
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {// 跳过重复
                continue;
            }

            res.addAll(twoSum(nums, i + 1, -nums[i]));
        }

        return res;
    }

    /**
     * 两元素求各
     * 
     * @param nums
     * @param start 开始下标，包括。
     * @param target 目标和
     * @return
     */
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int i = start, j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {// 命中
                res.add(Arrays.asList(-target, nums[i], nums[j]));
                i++;
                j--;
                while (nums[i] == nums[i - 1] && i < j) {// 跳过重复
                    i++;
                }
                while (nums[j] == nums[j + 1] && i < j) {// 跳过重复
                    j--;
                }
                continue;
            }

            if (sum < target) {// 左边往大处移
                i++;
            } else {// 右边往小处移
                j--;
            }
        }

        return res;
    }

}
