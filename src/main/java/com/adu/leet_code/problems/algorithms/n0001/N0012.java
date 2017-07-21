package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author yunjie.du
 * @date 2017/7/21 14:50
 * @see <a href="https://leetcode.com/problems/integer-to-roman/#/description">Integer to Roman</a>
 */
public class N0012 {
    /**
     * 边界点
     */
    private int[] borderValueArray = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    /**
     * 边界点的罗马数字表示
     */
    private String[] borderSymbolArray = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    /**
     * 思想：找到最近的边界点，拿到边界点的罗马数字。然后减去边界值后继续，直到0为止。
     * 
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < borderValueArray.length; i++) {
            if (num >= borderValueArray[i]) {
                int count = num / borderValueArray[i];// 该边界的次数
                for (int k = 0; k < count; k++) {// 该边界的罗马数字
                    buffer.append(borderSymbolArray[i]);
                }
                num %= borderValueArray[i];
            }
        }

        return buffer.toString();
    }

}
