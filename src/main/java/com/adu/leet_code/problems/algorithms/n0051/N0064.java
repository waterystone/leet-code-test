package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author yunjie.du
 * @date 2017/8/8 10:54
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/description/">64. Minimum Path Sum</a>
 */
public class N0064 {
    /**
     * 思想：用一个二维数组result[][]保存结果。其中result[i][j]=Math.min(result[i][j-1],result[i-1][j])+grid[i][j].
     * 
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length, minLength = Math.min(m, n);
        int[][] result = new int[m][n];
        initBorder(grid, result);// 初始化上边界和左边界。

        for (int i = 1; i < minLength; i++) {// 逐层计算上边界和左边界的值。
            for (int y = i; y < n; y++) {// 上
                result[i][y] = Math.min(result[i][y - 1], result[i - 1][y]) + grid[i][y];
            }

            for (int x = i + 1; x < m; x++) {// 左
                result[x][i] = Math.min(result[x][i - 1], result[x - 1][i]) + grid[x][i];
            }
        }

        return result[m - 1][n - 1];

    }

    /**
     * 初始化最上和最左边界
     * 
     * @param grid
     * @param result
     */
    private void initBorder(int[][] grid, int[][] result) {
        result[0][0] = grid[0][0];

        for (int i = 1; i < grid[0].length; i++) {// 最上
            result[0][i] = grid[0][i] + result[0][i - 1];
        }

        for (int i = 1; i < grid.length; i++) {// 最左
            result[i][0] = grid[i][0] + result[i - 1][0];
        }
    }
}
