package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * 
 * <pre>
 Input: "babad"
 Output: "bab"
 <b>Note</b>: "aba" is also a valid answer.
 * </pre>
 * 
 * Example:
 * 
 * <pre>
 Input: "cbbd"
 Output: "bb"
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/20 11:03
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/#/description">Longest Palindromic Substring</a>
 */
public class N0005 {
    /**
     * 思想：遍历每个元素，求以该元素为中心的回文串长度。<br/>
     * 
     * 1）先求相邻同元素的长度，它们肯定是回文的，可以把它们看成一个点；<br/>
     * 2）再求同元素串向两边扩展的回文长度。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int max = 0, maxi = 0, maxj = 0;// 最长回文子串的长度、左下标、右下标。

        for (int i = 0; i < s.length();) {
            if (s.length() - i < max / 2) {// 剩余长度肯定不够，直接返回
                break;
            }

            int j = getSameElementMaxIndex(s, i);// 向后找相邻同元素的最大下标。
            int extentLength = getExtentLength(s, i, j);// 以相邻同元素串为中心，向两边扩展
            int length = j - i + 1 + extentLength + extentLength;// 该元素的回文长度
            if (length > max) {
                max = length;
                maxi = i - extentLength;
                maxj = j + extentLength;
            }

            i = j + 1;// 可以跳到下一个不同元素处
        }

        return s.substring(maxi, maxj + 1);
    }

    /**
     * 获取元素i处向后相邻相同元素的最大下标。 <br/>
     * 如abbbcb，i=1,则结果为3。
     * 
     * @param s
     * @param i
     * @return
     */
    private int getSameElementMaxIndex(String s, int i) {
        for (int j = i + 1; j < s.length(); j++) {
            if (s.charAt(j) != s.charAt(i)) {
                return j - 1;
            }
        }

        return s.length() - 1;
    }

    /**
     * 以i、j为左右端点向两边扩展的回文长度。
     * 
     * @param s
     * @param i 左下标
     * @param j 右下标
     * @return
     */
    private int getExtentLength(String s, int i, int j) {
        int res = 0;
        while (--i >= 0 && ++j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                res++;
            } else {
                return res;
            }
        }

        return res;
    }

}
