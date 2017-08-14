package com.adu.leet_code.problems.algorithms.n0051;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * <pre>
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 * </pre>
 * 
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 *
 * 
 * @author yunjie.du
 * @date 2017/8/11 17:51
 * @see <a href="https://leetcode.com/problems/decode-ways/description/">91. Decode Ways</a>
 */
public class N0091 {
    /**
     * 思想：从后向前求。对于求当前元素的总数a，假设其后边两个元素的结果分别为b、c，那么a的情况有三种：
     * <ol>
     * <li>当前元素为'0',那么当前元素只能与前一个元素搭配，则a=0；</li>
     * <li>当前元素只能自己编码，不能与后一个元素一起编码，则a=b；</li>
     * <li>当前元素也能与后一个元素一起编码，则a=b+c，其中b=单独编码，c为联合编码。</li>
     * </ol>
     * 
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }

        int a = 0, b = s.charAt(s.length() - 1) == '0' ? 0 : 1, c = 1;// 初始化。b为最后一个元素的总数，c还为虚拟总数。
        for (int i = s.length() - 2; i >= 0; i--) {// 从后向前求每个元素的总数
            a = s.charAt(i) == '0' ? 0 : (isMatch(s.charAt(i), s.charAt(i + 1)) ? b + c : b);

            c = b;// c前移，方便求下一元素
            b = a;// b前移，方便求下一元素
        }

        return a;
    }

    /**
     * 判断两个字符是否可以一起编码
     * 
     * @param ch1
     * @param ch2
     * @return
     */
    private boolean isMatch(char ch1, char ch2) {
        return ch1 == '1' || ch1 == '2' && ch2 <= '6';
    }
}
