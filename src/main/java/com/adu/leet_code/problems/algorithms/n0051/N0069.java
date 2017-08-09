package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author yunjie.du
 * @date 2017/8/8 18:44
 * @see <a href="https://leetcode.com/problems/sqrtx/description/">69. Sqrt(x)</a>
 */
public class N0069 {
    /**
     * 二分查找。
     * 
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0, right = x / 2 + 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long square = ((long) mid) * mid;
            if (square == x) {
                return mid;
            }
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

}
