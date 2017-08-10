package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * <pre>
 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/10 14:32
 * @see <a href="https://leetcode.com/problems/subsets/description/">78. Subsets</a>
 */
public class N0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {// k为子集中元素个数
            combine(0, k, nums, new ArrayList<>(), res);
        }

        return res;
    }

    private void combine(int i, int k, int[] nums, List<Integer> curList, List<List<Integer>> res) {
        if (k > nums.length - i) {
            return;
        }

        if (k == 0) {
            res.add(curList);
            return;
        }

        // 选择当前元素
        List<Integer> list = new ArrayList<>(curList);
        list.add(nums[i]);
        combine(i + 1, k - 1, nums, list, res);

        // 不选择当前元素
        combine(i + 1, k, nums, new ArrayList<>(curList), res);
    }
}
