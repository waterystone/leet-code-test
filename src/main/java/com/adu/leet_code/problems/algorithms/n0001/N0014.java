package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author yunjie.du
 * @date 2017/7/21 17:39
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/#/description">Longest Common Prefix</a>
 */
public class N0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int i = 0;
        for (; i < strs[0].length(); i++) {// 以strs[0]为参照，逐字符比较
            for (int j = 1; j < strs.length; j++) {// 判断其他串该下标处的字符是否命中
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return i == 0 ? "" : strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, i);
    }
}
