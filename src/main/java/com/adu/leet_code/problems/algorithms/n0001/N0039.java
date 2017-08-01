package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C
 * where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution set must not contain duplicate
 * combinations.
 * 
 * <pre>
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/1 15:38
 */
public class N0039 {
    /**
     * 先排序，再递归进行求解。
     * 
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);// 排序
        combinationSum(candidates, 0, target, new ArrayList<>(), res);

        return res;
    }

    /**
     * 递归求解
     * 
     * @param candidates
     * @param i 当前下标
     * @param target 当前目标值
     * @param list 当前list中的元素
     * @param res 结果集
     */
    private void combinationSum(int[] candidates, int i, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == 0 && !list.isEmpty()) {// 如果当前target已为零
            res.add(list);
            return;
        }

        if (i == candidates.length || candidates[i] > target) {// i越界，或者当前元素已大于target值，直接返回。
            return;
        }

        int iSum = 0;
        while (iSum <= target) {// 不断重复当前元素数
            combinationSum(candidates, i + 1, target - iSum, new ArrayList<>(list), res);
            list.add(candidates[i]);
            iSum += candidates[i];
        }
    }
}
