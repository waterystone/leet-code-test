package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * <pre>
 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * </pre>
 * 
 * Note: You can assume that you can always reach the last index.
 * 
 * @author yunjie.du
 * @date 2017/8/2 18:19
 * @see <a href="https://leetcode.com/problems/jump-game-ii/description/">45. Jump Game II</a>
 */
public class N0045 {
    /**
     * 思想：每一跳找到下一范围内最大可跳的位置。
     * 
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int min = 0, start = 0, end = 0;
        while (end < nums.length - 1) {
            min++;
            int farest = end;
            for (int i = start; i <= end; i++) {
                farest = Math.max(nums[i] + i, farest);
                if (farest >= nums.length - 1) {// 如果终点可达了
                    return min;
                }
            }

            start = end + 1;
            end = farest;
        }

        return min;
    }

    public static final int IN_REACHABLE_STEP = -1;// 表示不可达的最小步数

    /**
     * 思想：从后往前回溯求解。
     * 
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int[] steps = new int[nums.length - 1];// 记录每个位置到终点的最小步数。下标从0到nums.length-2，-1表示该位置到终点不可达。
        int lastIndex = nums.length - 1;// 终点下标

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {// 值为0，表示不可达
                steps[i] = IN_REACHABLE_STEP;
                continue;
            }

            int nextMaxIndex = i + nums[i];// 最大可跨到的下一个位置
            if (nextMaxIndex >= lastIndex) {// 如果可跨到终点了，则一步直达。
                steps[i] = 1;
                continue;
            }

            int nextMinStep = findMin(steps, i + 1, i + nums[i]);// 找到可达范围内的最小步数
            steps[i] = (nextMinStep == IN_REACHABLE_STEP ? IN_REACHABLE_STEP : nextMinStep + 1);
        }

        return steps[0];
    }

    /**
     * 找到区间的最小步数
     * 
     * @param steps
     * @param i
     * @param j
     * @return
     */
    private int findMin(int[] steps, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = j; k >= i; k--) {// 从后往前找，更容易找到
            if (steps[k] == 1) {// 如果是1，表示可直达了，直接返回。
                return 1;
            }

            if (steps[k] > 0 && steps[k] < min) {
                min = steps[k];
            }
        }

        return min == Integer.MAX_VALUE ? IN_REACHABLE_STEP : min;
    }
}
