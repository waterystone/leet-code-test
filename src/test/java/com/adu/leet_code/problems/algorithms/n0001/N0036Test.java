package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/1 14:37
 */
public class N0036Test extends BaseTest {
    private N0036 n0036 = new N0036();
    char[][] board = new char[9][9];

    @Test
    public void isValidSudoku() {
        boolean res = n0036.isValidSudoku(board);
        logRes(res);
    }

    @Before
    public void init() {
        String[] strs = { "..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....",
                "3.....42.", "...27.6.." };

        for (int i = 0; i < 9; i++) {
            board[i] = strs[i].toCharArray();
        }
    }
}
