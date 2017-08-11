package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * <pre>
 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/11 16:49
 * @see <a href="https://leetcode.com/problems/subsets-ii/description/">90. Subsets II</a>
 */
public class N0090 {
    /**
     * 思想：先排序。要在当前元素之后先k个，假如当前元素选m(0<=m<=重复个数)个,则其下个不同元素处要选k-m个。
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k <= nums.length; k++) {// k为要选的个数
            subsetsWithDup(nums, 0, k, new ArrayList<>(), res);
        }

        return res;
    }

    /**
     * 在当前下标处开始，选k个。
     * 
     * @param nums
     * @param i
     * @param k
     * @param curList
     * @param res
     * @param <E>
     */
    private <E> void subsetsWithDup(int[] nums, int i, int k, List<Integer> curList, List<List<Integer>> res) {
        if (nums.length - i < k) {// 如果剩余元素不够k个，直接返回。
            return;
        }

        if (k == 0) {// 如果k个元素都已选定
            res.add(curList);
            return;
        }

        int nextValueIndex = getNextValueIndex(nums, i), sameValueCount = nextValueIndex - i;// 下一个不同元素的下标，该元素同值的个数

        for (int count = Math.min(sameValueCount, k); count >= 0; count--) {// 当前元素选择个数
            List<Integer> newList = new ArrayList<>(curList);
            addCountValue(newList, nums[i], count);
            subsetsWithDup(nums, nextValueIndex, k - count, newList, res);// 从下一个不同元素处选k-count个
        }
    }

    /**
     * 获取下一个不同于指定元素的下标
     * 
     * @param nums
     * @param i
     * @return 如果越界，返回nums.length。
     */
    private int getNextValueIndex(int[] nums, int i) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                return j;
            }
        }

        return nums.length;
    }

    /**
     * 在列表末尾追加指定数量的值。
     * 
     * @param list
     * @param value
     * @param count
     */
    private void addCountValue(List<Integer> list, int value, int count) {
        while (count-- > 0) {
            list.add(value);
        }
    }
}
