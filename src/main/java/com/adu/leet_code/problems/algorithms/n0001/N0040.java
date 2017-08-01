package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
 * candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. The solution set must not contain duplicate
 * combinations.
 * 
 * <pre>
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/1 16:37
 * @see <a href="https://leetcode.com/problems/combination-sum-ii/description/">40. Combination Sum II</a>
 */
public class N0040 {
    /**
     * 先排序，再递归进行求解。
     * 
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);// 排序
        combinationSum2(candidates, 0, target, new ArrayList<>(), res);

        return res;
    }

    /**
     * 递归求解
     *
     * @param candidates
     * @param i 当前下标
     * @param target 当前目标值
     * @param curList 当前list中的元素
     * @param res 结果集
     */
    private void combinationSum2(int[] candidates, int i, int target, List<Integer> curList, List<List<Integer>> res) {
        if (target == 0 && !curList.isEmpty()) {// 如果当前target已为零
            res.add(curList);
            return;
        }

        if (i == candidates.length || candidates[i] > target) {// i越界，或者当前元素已大于target值，直接返回。
            return;
        }

        int nextI = getNextIndex(candidates, i), iSum = 0;// 获取下一个不同于当前值的下标

        for (int k = i; k <= nextI; k++) {// 当前元素的重复次数，包括零个
            combinationSum2(candidates, nextI, target - iSum, new ArrayList<>(curList), res);

            curList.add(candidates[i]);
            iSum += candidates[i];
        }
    }

    /**
     * 计算下一个不同于指定元素的下标
     * 
     * @param candidates
     * @param i
     * @return 最大为candidates.length，表示越界
     */
    private int getNextIndex(int[] candidates, int i) {
        while (++i < candidates.length && candidates[i] == candidates[i - 1]) {
        }

        return i;
    }
}
