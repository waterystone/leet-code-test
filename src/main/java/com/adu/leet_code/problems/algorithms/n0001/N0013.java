package com.adu.leet_code.problems.algorithms.n0001;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author yunjie.du
 * @date 2017/7/21 17:05
 * @see <a href="https://leetcode.com/problems/roman-to-integer/#/description">Roman to Integer</a>
 */
public class N0013 {
    public static final Map<String, Integer> borderMap = new HashMap<>(13);
    static {
        borderMap.put("I", 1);
        borderMap.put("IV", 4);
        borderMap.put("V", 5);
        borderMap.put("IX", 9);
        borderMap.put("X", 10);
        borderMap.put("XL", 40);
        borderMap.put("L", 50);
        borderMap.put("XC", 90);
        borderMap.put("C", 100);
        borderMap.put("CD", 400);
        borderMap.put("D", 500);
        borderMap.put("CM", 900);
        borderMap.put("M", 1000);

    }

    /**
     * 思想：逐字符判断是哪个罗马数字并转换。<br/>
     * <b>NOTE</b>:优先判断双字符，双字符没命中再考虑单字符。
     * 
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int res = 0, i = 0;

        while (i < s.length() - 1) {
            String doubleLetters = s.substring(i, i + 2);
            if (borderMap.containsKey(doubleLetters)) {// 是否双罗马数字
                res += borderMap.get(doubleLetters);
                i += 2;
                continue;
            }

            res += borderMap.get(String.valueOf(s.charAt(i)));
            i++;
        }

        if (i == s.length() - 1) {// 如果最后是单罗马数字
            res += borderMap.get(String.valueOf(s.charAt(i)));
        }
        return res;
    }
}
