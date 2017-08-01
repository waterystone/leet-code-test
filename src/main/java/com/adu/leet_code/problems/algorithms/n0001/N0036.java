package com.adu.leet_code.problems.algorithms.n0001;

import java.util.Arrays;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be
 * validated.
 * 
 * @author yunjie.du
 * @date 2017/8/1 14:18
 * @see <a href="https://leetcode.com/problems/valid-sudoku/description/">36. Valid Sudoku</a>
 */
public class N0036 {
    /**
     * 思想：判断每行、每列、每个九宫格是否符合。
     * 
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[] visitedStatus = new boolean[9];// 保存访问状态

        for (int i = 0; i < 9; i++) {// 按行判断
            initVisitedStatus(visitedStatus);
            for (int j = 0; j < 9; j++) {
                if (!validGrid(visitedStatus, board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {// 按列判断
            initVisitedStatus(visitedStatus);
            for (int j = 0; j < 9; j++) {
                if (!validGrid(visitedStatus, board[j][i])) {
                    return false;
                }
            }
        }

        for (int i = 0; i <= 6; i += 3) {// 按九宫格判断
            for (int j = 0; j <= 6; j += 3) {
                initVisitedStatus(visitedStatus);
                for (int k = 0; k < 9; k++) {
                    if (!validGrid(visitedStatus, board[i + k / 3][j + k % 3])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * 初始化
     * 
     * @param visitedStatus
     */
    private void initVisitedStatus(boolean[] visitedStatus) {
        Arrays.fill(visitedStatus, false);
    }

    /**
     * 验证并添加状态
     * 
     * @param visitedStatus
     * @param ch
     * @return false表示验证失败，其他成功。
     */
    private boolean validGrid(boolean[] visitedStatus, char ch) {
        if (ch == '.') {
            return true;
        }
        int index = ch - '1';
        if (visitedStatus[index] == true) {
            return false;
        }

        visitedStatus[index] = true;
        return true;
    }
}
