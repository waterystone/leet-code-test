package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * 
 * Example2: x = -123, return -321
 * 
 * Have you thought about this? Here are some good questions to ask before coding. Bonus points for you if you have
 * already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of
 * 1000000003 overflows. How should you handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 
 * Note: The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer
 * overflows.
 * 
 * @author yunjie.du
 * @date 2017/7/20 18:21
 */
public class N0007 {
    public int reverse(int x) {
        long res = 0;// 用长整数保存结果，防止溢出

        while (x != 0) {
            res = 10 * res + x % 10;
            x /= 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {// 判断溢出
            return 0;
        }

        return (int) res;
    }
}
