package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * <pre>
 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.
 * </pre>
 * 
 * Note: m and n will be at most 100.
 * 
 * @author yunjie.du
 * @date 2017/8/7 16:31
 * @see <a href="https://leetcode.com/problems/unique-paths-ii/description/">63. Unique Paths II</a>
 */
public class N0063 {
    /**
     * 思想：申请一个二维数组result[][]作为相应位置的路径数。
     * 
     * result[i][j]有以下三种情况：
     * <ol>
     * <li>第0行及第0列，未遇到0之前都是1，遇到0及之后的都为0；</li>
     * <li>其他行列中的，如果是阻碍则为1，否则为result[i][j-1]+result[i-1][j]。</li>
     * </ol>
     * 
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int m = obstacleGrid.length, n = obstacleGrid[0].length, minLength = Math.min(m, n);
        int[][] result = new int[m][n];
        initBorder(obstacleGrid, result);// 初始化结果数组的边界

        for (int i = 1; i < minLength; i++) {
            for (int y = i; y < m; y++) {// 第i行
                result[y][i] = obstacleGrid[y][i] == 1 ? 0 : result[y][i - 1] + result[y - 1][i];
            }

            for (int x = i + 1; x < n; x++) {// 第i列
                result[i][x] = obstacleGrid[i][x] == 1 ? 0 : result[i][x - 1] + result[i - 1][x];
            }
        }

        return result[m - 1][n - 1];
    }

    private void initBorder(int[][] obstacleGrid, int[][] result) {
        boolean enCounterFlag = false;
        for (int i = 0; i < obstacleGrid[0].length; i++) {// 第0行
            result[0][i] = !enCounterFlag && obstacleGrid[0][i] == 0 ? 1 : 0;
            enCounterFlag = result[0][i] == 0 ? true : false;
        }

        enCounterFlag = false;
        for (int i = 1; i < obstacleGrid.length; i++) {// 第0列
            result[i][0] = !enCounterFlag && obstacleGrid[i][0] == 0 ? 1 : 0;
            enCounterFlag = result[i][0] == 0 ? true : false;
        }
    }
}
