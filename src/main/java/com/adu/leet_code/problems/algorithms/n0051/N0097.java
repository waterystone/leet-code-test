package com.adu.leet_code.problems.algorithms.n0051;

/**
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * <pre>
 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/8/14 16:18
 * @see <a href="https://leetcode.com/problems/interleaving-string/description/">97. Interleaving String</a>
 */
public class N0097 {
    /**
     * 思想：递归，超时！！！
     * 
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return isInterleave(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);

    }

    private boolean isInterleave(char[] chars1, int i, char[] chars2, int j, char[] chars3, int k) {
        if (i == chars1.length) {
            return equals(chars2, j, chars3, k);
        }
        if (j == chars2.length) {
            return equals(chars1, i, chars3, k);
        }
        if (k == chars3.length) {
            return true;
        }

        if (chars1[i] == chars3[k] && isInterleave(chars1, i + 1, chars2, j, chars3, k + 1)) {
            return true;
        }

        if (chars2[j] == chars3[k] && isInterleave(chars1, i, chars2, j + 1, chars3, k + 1)) {
            return true;
        }

        return false;
    }

    private boolean equals(char[] chars1, int start1, char[] chars3, int start3) {
        while (start1 < chars1.length) {
            if (chars1[start1++] != chars3[start3++]) {
                return false;
            }
        }

        return true;
    }

}
