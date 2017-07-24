package com.adu.leet_code.problems.algorithms.n0001;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * <pre>
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/24 11:09
 * @see <a href="https://leetcode.com/problems/3sum-closest/#/description">3Sum Closest</a>
 */
public class N0016 {
    /**
     * 思想：先排序，遍历每个元素i，求后边列表中两数和与target-nums[i]最接近的。
     * 
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, minAbsDst = Integer.MAX_VALUE;// 与目标的绝对距离，方便计算

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {// 跳过重复的
                continue;
            }

            int dst = twoSumClosst(nums, i + 1, target - nums[i]);// 计算后边列表中与target -
                                                                  // nums[i]最接近的相对距离，其实也就是三数之和与target的相对距离。
            if (dst == 0) {// 如果相对距离正好为0，表示三数之和正好为target，直接返回。
                return target;
            }

            if (Math.abs(dst) < minAbsDst) {// 判断相对距离的绝对值是否已最小
                res = target + dst;// 记录
                minAbsDst = Math.abs(dst);
            }
        }

        return res;
    }

    /**
     * 从指定下标开始，计算两数之和与target最接近的相对距离。
     * 
     * @param nums
     * @param i 开始下标，包括
     * @param target 目标
     * @return 与target最接近的相对距离，正数表示大于target，负数表示小于target，0表示正好与target相等。
     */
    private int twoSumClosst(int[] nums, int i, int target) {
        int res = Integer.MAX_VALUE;// 初始记为最大值
        int start = i, end = nums.length - 1;

        while (start < end) {// 两端向里逼近
            int sum = nums[start] + nums[end];
            if (sum == target) {// 相等表示距离为0，则直接返回
                return 0;
            }

            int dst = sum - target;// 计算相对距离
            if (Math.abs(dst) < Math.abs(res)) {// 判断绝对距离是否已最小
                res = dst;
            }

            if (sum < target) {// 左边往大处移
                start++;
            } else {// 右边往小处移
                end--;
            }
        }

        return res;
    }
}
