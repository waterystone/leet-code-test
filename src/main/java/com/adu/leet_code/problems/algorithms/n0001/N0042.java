package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 * 
 * <pre>
 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/2 11:39
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/description/">42. Trapping Rain Water</a>
 */
public class N0042 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, area = 0, secHeight = 0;
        while (left < right) {
            if (height[left] < height[right]) {// 以最高的那端为标杆，从另一侧算起
                if (height[left] > secHeight) {// 另一侧的次高不断吞噬
                    secHeight = height[left];
                } else if (height[left] < secHeight) {
                    area += secHeight - height[left];
                }

                left++;
            } else {
                if (height[right] > secHeight) {
                    secHeight = height[right];
                } else if (height[right] < secHeight) {
                    area += secHeight - height[right];
                }

                right--;
            }
        }
        return area;
    }
}
