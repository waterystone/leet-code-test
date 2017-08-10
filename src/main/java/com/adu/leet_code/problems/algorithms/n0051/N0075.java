package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * click to show follow up.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using counting sort. First, iterate the array
 * counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author yunjie.du
 * @date 2017/8/9 18:24
 * @see <a href="https://leetcode.com/problems/sort-colors/description/">75. Sort Colors</a>
 */
public class N0075 {
    /**
     * 将前边排好序的0、1、2分成三组，i、j、k分别指向组内的最后一个元素。新加入元素时，有以下三种情况：
     * <ol>
     * <li>如果是0，则0组右延一个0，这是1组少了一个1，1组也要右延一个1；2组又少了一个2，也要右延一个2.</li>
     * <li>如果是1，则1组右延一个1，同时2组右延一个2.</li>
     * <li>如果是2，则2组右延一个2.</li>
     * </ol>
     * 
     * @param nums
     */
    public void sortColors(int[] nums) {
        int i = -1, j = -1, k = -1;// 初始时都设置为-1
        for (int num : nums) {
            switch (num) {
            case 0:
                nums[++i] = 0;
                if (j >= 0) {// 如果1组有数据
                    nums[++j] = 1;
                }
                if (k >= 0) {// 如果2组有数据
                    nums[++k] = 2;
                }
                break;

            case 1:
                if (j < 0) {// 如果1组还没有数据，则j指向0组的末尾i即可。
                    j = i;
                }
                nums[++j] = 1;
                if (k >= 0) {// 如果2组有数据
                    nums[++k] = 2;
                }
                break;

            case 2:
                if (k < 0) {// 如果2组还没有数据，则指向前一组的末尾即可。
                    k = Math.max(i, j);
                }
                nums[++k] = 2;
            }
        }
    }
}
