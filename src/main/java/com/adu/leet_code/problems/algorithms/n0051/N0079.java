package com.adu.leet_code.problems.algorithms.n0051;

/**
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * <pre>
 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/8/10 14:53
 * @see <a href="https://leetcode.com/problems/word-search/description/">79. Word Search</a>
 */
public class N0079 {
    /**
     * 从每个点出发，依次往四周搜索。
     * 
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, words, 0)) {// 判断该点是否命中
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 判断board[i][j]是否命中words[m...]的字符集。
     * 
     * @param board
     * @param i
     * @param j
     * @param words
     * @param m
     * @return
     */
    private boolean exist(char[][] board, int i, int j, char[] words, int m) {
        if (m == words.length) {// words都搜索完了，表示命中
            return true;
        }

        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {// 坐标越界
            return false;
        }

        if (board[i][j] != words[m]) {// 如果该点的值与目标字符不一致
            return false;
        }

        // 向四周搜索下一子串
        char temp = board[i][j];
        board[i][j] = '*';// 将该点的值先修改为'*'，防止回访。
        boolean res = exist(board, i - 1, j, words, m + 1) || exist(board, i, j + 1, words, m + 1)
                || exist(board, i + 1, j, words, m + 1) || exist(board, i, j - 1, words, m + 1);// 向四周搜索余下的字符
        board[i][j] = temp;// 修正回来

        return res;
    }
}
