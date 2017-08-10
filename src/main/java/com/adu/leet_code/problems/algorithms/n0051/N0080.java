package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * 
 * <pre>
 For example,
 Given sorted array nums = [1,1,1,2,2,3],
 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/8/10 16:15
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/"> 80. Remove
 *      Duplicates from Sorted Array II</a>
 */
public class N0080 {
    /**
     * 思想：把后边的元素移到前边去(相同的元素至多两次)
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0, k = -1;// k表示前边整理好的尾部下标，初始化为-1
        while (i < nums.length) {// 每次处理一个不同的元素
            nums[++k] = nums[i];

            // 找到下一个不同元素的下标j
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j != i + 1) {// 如果j不是i的相邻下一个元素，表示当前元素有重复，再在前边加一个
                nums[++k] = nums[i];
            }

            i = j;// i指向下一个不同元素
        }

        return k + 1;// k指向前边整理好的尾部，k+1即是整理好的长度
    }
}
