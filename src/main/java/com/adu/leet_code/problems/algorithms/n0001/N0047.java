package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * <pre>
 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/3 14:46
 * @see <a href="https://leetcode.com/problems/permutations-ii/description/">47. Permutations II</a>
 */
public class N0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(nums, 0, res);
        return res;
    }

    private void permuteUnique(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(arrayToList(nums));
            return;
        }

        Set<Integer> set = new HashSet<>(nums.length - i + 1);
        for (int k = i; k < nums.length; k++) {
            if (!set.contains(nums[k])) {// 去重
                set.add(nums[k]);

                swap(nums, i, k);
                permuteUnique(nums, i + 1, res);
                swap(nums, i, k);
            }
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
