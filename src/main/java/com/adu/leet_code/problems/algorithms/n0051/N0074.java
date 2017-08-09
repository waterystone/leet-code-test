package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <ol>
 * <li>Integers in each row are sorted from left to right.</li>
 * <li>The first integer of each row is greater than the last integer of the previous row.</li>
 * </ol>
 * 
 * <pre>
 For example,
 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/9 16:59
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/description/">74. Search a 2D Matrix</a>
 */
public class N0074 {
    /**
     * 二分查找。先二分查找到所在的行，再在行内二分查找。
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) {
            return false;
        }

        int up = 0, down = matrix.length - 1;
        while (up <= down) {// 行查找
            int mid = (up + down) >> 1;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (target < matrix[mid][0]) {
                down = mid - 1;
            } else {
                up = mid + 1;
            }
        }

        int row = down, left = 0, right = matrix[0].length - 1;
        while (left <= right) {// 列查找
            int mid = (left + right) >> 1;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
