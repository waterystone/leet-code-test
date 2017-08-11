package com.adu.leet_code.problems.algorithms.n0051;

import java.util.Arrays;

/**
 *
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 * <pre>
 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t
 * </pre>
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * 
 * <pre>
 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t
 * </pre>
 * 
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * 
 * <pre>
 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a
 * </pre>
 * 
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * @author yunjie.du
 * @date 2017/8/11 11:40
 * @see <a href="https://leetcode.com/problems/scramble-string/description/">87. Scramble String</a>
 */
public class N0087 {
    /**
     * 思想：对于字符串s1(m+n位),判断字符串s2是否可交换。
     * <ol>
     * <li>s1前m位与s2前m位可交换，且s1后n位与s2后n位可交换；</li>
     * <li>s1前m位与s2后m位可交换，且s1后n位与s2前n位可交换。</li>
     * </ol>
     * 
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (!Arrays.equals(chars1, chars2)) {
            return false;
        }

        for (int i = 1; i < s1.length(); i++) {// 暴力破解
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }

        return false;
    }

}
