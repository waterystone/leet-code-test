package com.adu.leet_code.problems.algorithms.n0051;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * @author yunjie.du
 * @date 2017/8/7 15:32
 * @see <a href="https://leetcode.com/problems/unique-paths/description/">62. Unique Paths</a>
 */
public class N0062 {
    /**
     * 从起点到终点，往下要走m-1次，往右要走n-1次。相当于在总步数(m-1)+(n-1)中任选m-1次向下，其他n-1次自然就向右了。组合问题。
     * 
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return c(m + n - 2, m - 1);
    }

    /**
     * 求组合c(a,b)
     * 
     * @param a
     * @param b
     * @return
     */
    private int c(int a, int b) {
        b = Math.min(b, a - b);// c(a,b)=c(a,a-b)，按最小的来。又快又防止溢出。
        long res = 1, denominator = 1;
        for (int i = 0; i < b; i++) {
            res *= a - i;
            denominator *= i + 1;
        }

        return (int) (res / denominator);
    }
}
