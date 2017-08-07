package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * <pre>
 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/4 17:55
 * @see <a href="https://leetcode.com/problems/spiral-matrix-ii/description/">59. Spiral Matrix II</a>
 */
public class N0059 {
    /**
     * 旋转逐个生成。
     * 
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int start = 1, half = n / 2;
        for (int i = 0; i <= half; i++) {// 逐层
            int x = i, y = i;
            while (y < n - 1 - i) {// 上(不包括最后一个元素)
                matrix[x][y++] = start++;
            }
            while (x < n - 1 - i) {// 右(不包括最后一个元素)
                matrix[x++][y] = start++;
            }
            while (y > i) {// 下(不包括最后一个元素)
                matrix[x][y--] = start++;
            }
            while (x > i) {// 左(不包括最后一个元素)
                matrix[x--][y] = start++;
            }
        }

        if (n % 2 == 1) {// 如果奇数，填充最中间的那个元素
            matrix[half][half] = start;
        }

        return matrix;
    }
}
