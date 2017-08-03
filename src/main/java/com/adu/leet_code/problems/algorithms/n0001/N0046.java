package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * <pre>
 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/3 11:36
 * @see <a href="https://leetcode.com/problems/permutations/description/">46. Permutations</a>
 */
public class N0046 {
    /**
     * 思想：递归。
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }

    private <E> void permute(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(arrayToList(nums));
            return;
        }

        for (int j = i; j < nums.length; j++) {// 余下的每个数都放i处，并递归求剩余数的全排列。
            swap(nums, i, j);
            permute(nums, i + 1, res);
            swap(nums, i, j);
        }
    }

    private List<Integer> arrayToList(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int num : nums) {
            res.add(num);
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        if (nums[i] != nums[j]) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
