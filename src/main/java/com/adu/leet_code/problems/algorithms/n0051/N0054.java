package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * <pre>
 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/4 14:17
 * @see <a href="https://leetcode.com/problems/spiral-matrix/description/">54. Spiral Matrix</a>
 */
public class N0054 {
    /**
     * 思想：回形旋转进行遍历。对于每一层，四个角的坐标分别是(i,i),(i,n-1-i),(m-1-i,n-1-i),(m-1-i,i)，其中m、n为矩形的行数和列数。
     * 
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length, n = matrix[0].length, layerCount = Math.min((m + 1) / 2, (n + 1) / 2);// half为层数
        List<Integer> res = new ArrayList<>(m * n);
        for (int i = 0; i < layerCount; i++) {// 逐层遍历
            for (int x = i, y = i; y < n - i; y++) {// 最上一行
                res.add(matrix[x][y]);
            }

            for (int x = i + 1, y = n - 1 - i; x < m - 1 - i; x++) {// 右列，不包括最上一行和最下一行
                res.add(matrix[x][y]);
            }

            for (int x = m - 1 - i, y = n - 1 - i; x != i && y >= i; y--) {// 最下一行，注意防止与最上一行重复
                res.add(matrix[x][y]);
            }

            for (int x = m - 2 - i, y = i; y != n - 1 - i && x > i; x--) {// 左列，不包括最上一行和最下一行，注意防止与右列重复
                res.add(matrix[x][y]);
            }
        }

        return res;
    }
}
