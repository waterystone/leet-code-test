package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author yunjie.du
 * @date 2017/7/24 18:55
 * @see <a href="https://leetcode.com/problems/valid-parentheses/#/description">Valid Parentheses</a>
 */
public class N0020 {
    /**
     * 思想：用一个栈来保存待匹配的正向括号。每遇到一个括号，正向的入栈，反向的判断栈顶括号是否是配对的正向括号。 <br/>
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        char[] matchingPrackets = new char[s.length() / 2 + 1];// 充当栈，保存待匹配的括号。大小顶多是s的一半。
        int index = -1;// 指向栈中当前元素的下标

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {// 如果是正向括号，则要入栈
                if (index == matchingPrackets.length - 1) {// 如果s有一半以上的正向括号都还没匹配上，直接失败
                    return false;
                }

                matchingPrackets[++index] = s.charAt(i);// 入栈
                continue;
            }

            // 反向括号
            if (index < 0) {// 栈里没有待匹配元素，直接失败
                return false;
            }

            int delta = ch - matchingPrackets[index--];// 利用ASCII码值，()是40、41，[]是91、93，{}是123、125。
            if (delta != 1 && delta != 2) {// 判断栈顶元素是不是配对的正向括号
                return false;
            }
        }

        return index == -1;// 正确配对的话，栈最后会是空的，而index也会回到原始的-1值。
    }

    public boolean isValid2(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        return isValid(s, 0, "");
    }

    /**
     * 递归
     * 
     * @param s
     * @param i
     * @param prefix
     * @return
     */
    private boolean isValid(String s, int i, String prefix) {
        if (i == s.length()) {
            if (prefix.isEmpty()) {
                return true;
            }
            return false;
        }

        if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
            return isValid(s, i + 1, prefix + s.charAt(i));
        }

        if (s.charAt(i) == ')') {
            if (getLastChar(prefix) != '(') {
                return false;
            }
            return isValid(s, i + 1, prefix.substring(0, prefix.length() - 1));
        }
        if (s.charAt(i) == '}') {
            if (getLastChar(prefix) != '{') {
                return false;
            }
            return isValid(s, i + 1, prefix.substring(0, prefix.length() - 1));
        }
        if (s.charAt(i) == ']') {
            if (getLastChar(prefix) != '[') {
                return false;
            }
            return isValid(s, i + 1, prefix.substring(0, prefix.length() - 1));
        }

        return false;
    }

    private char getLastChar(String s) {
        if (s.isEmpty()) {
            return '0';
        }
        return s.charAt(s.length() - 1);
    }
}
