package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * <pre>
 For example,
 a = "11"
 b = "1"
 Return "100".
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/8 17:13
 * @see <a href="https://leetcode.com/problems/add-binary/description/">67. Add Binary</a>
 */
public class N0067 {
    /**
     * 思想：逐位求和。
     * 
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        StringBuilder builder = new StringBuilder(Math.max(a.length(), b.length()));
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = (i >= 0 ? (a.charAt(i--) - '0') : 0) + (j >= 0 ? (b.charAt(j--) - '0') : 0) + carry;
            if (sum > 1) {// 有进位
                sum -= 2;
                carry = 1;
            } else if (carry != 0) {// 无进位
                carry = 0;
            }

            builder.append(sum);// 加上该位的数
        }

        // 反转
        return builder.reverse().toString();
    }
}
