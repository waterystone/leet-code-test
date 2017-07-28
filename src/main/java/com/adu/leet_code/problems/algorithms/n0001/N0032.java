package com.adu.leet_code.problems.algorithms.n0001;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * @author yunjie.du
 * @date 2017/7/27 16:15
 * @see <a href="https://leetcode.com/problems/longest-valid-parentheses/tabs/description">32. Longest Valid
 *      Parentheses</a>
 */
public class N0032 {
    public int longestValidParentheses(String s) {
        int max = 0, index = -1;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {// 下标入栈
                stack.push(i);
                continue;
            }

            // 处理)
            if (stack.isEmpty()) {// 之前没有(与之匹配了
                index = i;// 记录最后的无效)
            } else {
                stack.pop();
                max = Math.max(max, stack.isEmpty() ? i - index : i - stack.peek());
            }
        }
        return max;
    }

    public int longestValidParentheses2(String s) {
        s = trim(s);
        if (s.length() == 0) {
            return 0;
        }

        int max = 0, current = 0;
        for (int i = 0; i < s.length() - 1;) {
            if (s.charAt(i) == '(') {
                int pairIndex = pairIndex(s, i);// 找到与之配对的下一个)。
                if (pairIndex < 0) {// 没有找到
                    current = getReverseLength(s, i);// 反向查找长度
                    return Math.max(max, current);
                }

                current += pairIndex - i + 1;// 新的累积长度
                if (current > max) {
                    max = current;
                }
                i = pairIndex + 1;
                continue;
            }

            // 多余的)
            current = 0;
            i++;
        }

        return max;
    }

    /**
     * 寻找与下标处(配对的下一个)
     * 
     * @param s
     * @param start
     * @return
     */
    private int pairIndex(String s, int start) {
        int credit = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                credit++;
                continue;
            }

            if (--credit == 0) {// 找到了
                return i;
            }
        }

        // 一直到最后都没找到
        return -1;
    }

    /**
     * 正向没找到，那么反向计算其长度
     * 
     * @param s
     * @param start
     * @return
     */
    private int getReverseLength(String s, int start) {
        int credit = 0, max = 0, current = 0;
        for (int i = s.length() - 1; i >= start; i--) {
            if (s.charAt(i) == ')') {
                credit++;
                continue;
            }

            if (credit > 0) {
                credit--;
                current += 2;
            } else if (credit == 0 && current != 0) {
                max = Math.max(max, current);
                current = 0;
            }
        }

        return max;
    }

    /**
     * 截取左边的)和右边的(
     * 
     * @param s
     * @return
     */
    private String trim(String s) {
        int start = 0, end = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ')') {
            start++;
        }

        while (end >= 0 && s.charAt(end) == '(') {
            end--;
        }

        return start > end ? "" : s.substring(start, end + 1);
    }
}
