package com.adu.leet_code.problems.algorithms.n0001;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p>
 * Note:
 * <ol>
 * <li>The length of both num1 and num2 is < 110.</li>
 * <li>Both num1 and num2 contains only digits 0-9.</li>
 * <li>Both num1 and num2 does not contain any leading zero.</li>
 * <li>You must not use any built-in BigInteger library or convert the inputs to integer directly.</li>
 * </ol>
 * 
 * @author yunjie.du
 * @date 2017/8/2 16:08
 * @see <a href="https://leetcode.com/problems/two-sum/#/description">43. Multiply Strings</a>
 */
public class N0043 {
    /**
     * 思想：ab*cd=(a*10+b)*(c*10+d)=100*(a*c)+10*(a*d+b*c)+1*(b*d)。逐位相乘，所在位下标之和相等的，其积是同一个层次的，可以累加。
     * 
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int[] products = new int[num1.length() + num2.length() - 1];// 存放积中各位的数（可能是多位数）
        for (int i = 0; i < num1.length(); i++) {
            int digitI = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {// 求各位的积
                products[(num1.length() - 1 - i) + (num2.length() - 1 - j)] += digitI * (num2.charAt(j) - '0');
            }
        }

        return stringfyProducts(products);// 字符串化
    }

    /**
     * 字符串化
     * 
     * @param products
     * @return
     */
    private String stringfyProducts(int[] products) {
        StringBuilder builder = new StringBuilder(products.length);

        int carry = 0;// 进位
        for (int product : products) {
            int newProduct = product + carry;
            carry = newProduct / 10;
            builder.append(newProduct % 10);
        }

        return carry > 0 ? carry + builder.reverse().toString() : builder.reverse().toString();// 反转
    }

    /**
     * 与乘数逐位相乘，再叠加。
     * 
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if (num1.length() < num2.length()) {// 让更短的数做乘数
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        String sum = "";
        Map<Character, String> cache = buildCache(num1, num2);// 缓存num1与'0'-'9'的乘积

        for (int i = 0; i < num2.length(); i++) {// 逐位与乘数的各位相乘
            String multi = cache.get(num2.charAt(i));
            sum = add(sum + "0", multi);// 叠加
        }

        return sum;
    }

    private Map<Character, String> buildCache(String num1, String num2) {
        Map<Character, String> cache = new HashMap<>(10);
        cache.put('0', "0");
        cache.put('1', num1);

        int maxDigit = 0;// 只缓存到最大的数字
        for (int i = 0; i < num2.length(); i++) {
            if (num2.charAt(i) - '0' > maxDigit) {
                maxDigit = num2.charAt(i) - '0';
            }
        }

        for (int i = 2; i <= maxDigit; i++) {// 缓存
            cache.put((char) (i + '0'), add(num1, cache.get((char) (i - 1 + '0'))));// num1*n=num1+num1*(n-1)
        }

        return cache;
    }

    /**
     * 对两个数字型字符串求和。
     * 
     * @param num1
     * @param num2
     * @return
     */
    private String add(String num1, String num2) {
        StringBuilder builder = new StringBuilder(Math.max(num1.length() + 1, num2.length() + 1));
        boolean carry = false;// 进位标识

        int i = 0;
        while (i < num1.length() && i < num2.length()) {// 逐位求和
            int sum = (num1.charAt(num1.length() - 1 - i) - '0') + (num2.charAt(num2.length() - 1 - i) - '0')
                    + (carry ? 1 : 0);
            if (sum > 9) {
                carry = true;
                sum -= 10;
            } else {
                carry = false;
            }

            builder.append(sum);
            i++;
        }

        while (i < num1.length()) {// num1还有剩余
            int sum = (num1.charAt(num1.length() - 1 - i) - '0') + (carry ? 1 : 0);
            if (sum > 9) {
                carry = true;
                sum -= 10;
            } else {
                carry = false;
            }

            builder.append(sum);
            i++;
        }

        while (i < num2.length()) {// num2还有剩余
            int sum = (num2.charAt(num2.length() - 1 - i) - '0') + (carry ? 1 : 0);
            if (sum > 9) {
                carry = true;
                sum -= 10;
            } else {
                carry = false;
            }

            builder.append(sum);
            i++;
        }

        if (carry) {
            builder.append(1);
        }

        return builder.reverse().toString();// 反转
    }

}
