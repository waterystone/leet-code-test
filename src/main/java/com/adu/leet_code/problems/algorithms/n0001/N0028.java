package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * @author yunjie.du
 * @date 2017/7/26 17:35
 * @see <a href="https://leetcode.com/problems/implement-strstr/#/description">Implement strStr()</a>
 */
public class N0028 {
    /**
     * 思想：逐个比较
     * 
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {// 如果匹配，则j走到最后为needle.length()
                return i;
            }
        }

        return -1;
    }

}
