package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
 * what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 * gather all the input requirements up front.
 * 
 * Update (2015-02-10): The signature of the C++ function had been updated. If you still see your function signature
 * accepts a const char * argument, please click the reload button to reset your code definition.
 * 
 * @author yunjie.du
 * @date 2017/7/20 18:58
 */
public class N0008 {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        long res = 0;
        boolean flag = false;
        str = str.trim();

        int index = 0;
        if (str.charAt(0) == '-') {// 判断正负号
            flag = true;
            index++;
        } else if (str.charAt(0) == '+') {
            index++;
        }

        while (index < str.length()) {
            char ch = str.charAt(index++);

            if (ch < '0' || ch > '9') {// 判断是否数字
                return flag ? (int) -res : (int) res;
            }
            res = 10 * res + ch - '0';
            if (res > Integer.MAX_VALUE) {// 是否溢出
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return flag ? (int) -res : (int) res;
    }

}
