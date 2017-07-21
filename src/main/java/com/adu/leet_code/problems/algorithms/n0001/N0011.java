package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author yunjie.du
 * @date 2017/7/21 14:24
 * @see <a href="https://leetcode.com/problems/container-with-most-water/#/description">Container With Most Water</a>
 */
public class N0011 {
    /**
     * 思想：对于已经left、right，只有较小者往里移遇到新的大数，才有可能遇到更大新的乘积。
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;

        while (i < j) {
            int left = height[i], right = height[j], minHeight = Math.min(left, right);
            int newArea = minHeight * (j - i);// 新的乘积
            if (max < newArea) {
                max = newArea;
            }

            if (left <= right) {// 左边的小，则左边的下标往里移，直到遇到更大的数
                while (++i < j && height[i] < left) {
                }
            }

            if (left >= right) {// 右边的小，则右边的下标往里移，直到遇到更大的数
                while (--j > i && height[j] < right) {
                }
            }

        }

        return max;
    }
}
