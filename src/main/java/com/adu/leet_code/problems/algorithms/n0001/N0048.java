package com.adu.leet_code.problems.algorithms.n0001;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author yunjie.du
 * @date 2017/8/3 16:04
 * @see <a href="https://leetcode.com/problems/rotate-image/description/">48. Rotate Image</a>
 */
public class N0048 {
    /**
     * 思想：由外向内逐层旋转。在某层里有n个元素，旋转其前n-1个元素(第n个元素会被原第1个元素替代)，每个元素旋转4次，对应4个边构成一个轮回。<br/>
     * 重点：某个元素旋转一圈时，重要的是找到下一个元素的坐标与该元素的关系。
     * 
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int half = matrix.length / 2;
        for (int i = 0; i < half; i++) {// 层数
            int maxJ = matrix.length - 2 - i;// 该层纵坐标的最大值
            for (int j = i; j <= maxJ; j++) {// 纵坐标
                int x = i, y = j, pre = matrix[i][j];// 记录旋转前的(x,y)坐标及其值。
                for (int k = 0; k < 4; k++) {// 旋转4次相当于把4个边对应的点都旋转了，构成一个轮回。
                    int temp = x;
                    x = y;// 目标点的横坐标
                    y = matrix.length - 1 - temp;// 目标点的纵坐标

                    temp = matrix[x][y];
                    matrix[x][y] = pre;// 目标点的新值
                    pre = temp;
                }
            }
        }
    }
}
