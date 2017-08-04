package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last
 * word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * <pre>
 For example,
 Given s = "Hello World",
 return 5.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/4 17:42
 * @see <a href="https://leetcode.com/problems/length-of-last-word/description/">58. Length of Last Word</a>
 */
public class N0058 {
    /**
     * 思想：从后往前找到第一个单词的长度
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int res = 0;
        if (s == null || s.isEmpty()) {
            return res;
        }

        int i = s.length() - 1;// 从后往前
        while (i >= 0 && s.charAt(i) == ' ') {// 路过空格
            i--;
        }
        while (i >= 0 && s.charAt(i--) != ' ') {// 计算长度
            res++;
        }

        return res;
    }
}
