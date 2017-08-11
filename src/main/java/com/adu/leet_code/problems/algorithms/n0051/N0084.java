package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 * 
 * @author yunjie.du
 * @date 2017/8/10 18:17
 * @see <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/description/">84. Largest Rectangle in
 *      Histogram</a>
 */
public class N0084 {
    public int largestRectangleArea(int[] heights) {
        int max = 0, i = 0, j = heights.length - 1;
        while (i < j) {
            int area = Math.max(heights[i], heights[j]) * (j - i + 1);
            if (area > max) {
                max = area;
            }
            if (heights[i] <= heights[j]) {
                i++;
            }

            if (heights[j] <= heights[i]) {
                j--;
            }
        }

        return max;
    }
}
