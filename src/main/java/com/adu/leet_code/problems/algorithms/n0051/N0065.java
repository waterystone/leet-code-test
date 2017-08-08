package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Validate if a given string is numeric.
 * 
 * <pre>
 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 * </pre>
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before
 * implementing one.
 *
 * @author yunjie.du
 * @date 2017/8/8 11:18
 * @see <a href="https://leetcode.com/problems/valid-number/description/">65. Valid Number</a>
 */
public class N0065 {
    /**
     * 思想：以"e"为分隔符将s分成两个部分，分别对两个子串进行判断。
     * 
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || (s = s.trim()).isEmpty()) {
            return false;
        }

        if (s.charAt(0) == 'e' || s.charAt(s.length() - 1) == 'e') {// 不能以e开关或结尾
            return false;
        }

        int eIndex = s.indexOf(0 + 'e');// e的下标
        if (eIndex == -1) {// 如果没有e，判断整个s
            return isNumber(s, true);
        }

        // 判断e前后的两个子串，其中后子串不允许有小数点。
        return isNumber(s.substring(0, eIndex), true) && isNumber(s.substring(eIndex + 1), false);
    }

    private boolean isNumber(String s, boolean canDot) {
        if ((s = removeSignFlag(s)).isEmpty() || ".".equals(s)) {// 移除正负号
            return false;
        }
        s = removeFrontZero(s);// 移除前边无效的零

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '.') {// 小数点
                if (!canDot) {
                    return false;
                }
                canDot = false;// 小数点最多允许1次
                continue;
            }

            if (!isNumber(ch)) {// 如果非数字直接返回
                return false;
            }
        }

        return true;
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 移除前边无效的零
     * 
     * @param s
     * @return
     */
    private String removeFrontZero(String s) {
        if (s.charAt(0) != '0') {
            return s;
        }
        int i = 1;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                break;
            }
        }

        if (i == s.length()) {// 如果全为零，留一个零
            return "0";
        }

        // 如果零后边的是小数点，也要留一个零
        return s.charAt(i) == '.' ? s.substring(i - 1) : s.substring(i);
    }

    /**
     * 移除前边的正负号
     * 
     * @param s
     * @return
     */
    private String removeSignFlag(String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return s.substring(1);
        }

        return s;
    }

}
