package com.adu.leet_code.problems.algorithms.n0001;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * <pre>
 P   A   H   N
 A P L S I I G
 Y   I   R
 * </pre>
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * <p>
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author yunjie.du
 * @date 2017/7/20 15:21
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/#/description">ZigZag Conversion</a>
 */
public class N0006 {
    /**
     * 思路：找到每一行的下标特征，O(n)。
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows < 2) {
            return s;
        }

        StringBuffer buffer = new StringBuffer(s.length());// 放到缓冲区
        int interval = 2 * (numRows - 1);// 间隔周期。每个竖线和右上拆线形成一个周期。

        for (int i = 0; i < numRows; i++) {// 逐行处理，i为行号
            for (int j = i; j < s.length();) {// 找到该行的所有字符，j为该行的字符下标
                buffer.append(s.charAt(j));// 竖线上的元素

                int pairIndex;// 拆线上元素的下标。除最上和最下行外，其他行都是竖线上元素和拆线上元素成对出现。
                if (i != 0 && i != numRows - 1 && (pairIndex = j + interval - i - i) < s.length()) {
                    buffer.append(s.charAt(pairIndex));// 加上拆线上的元素
                }

                j += interval;// 跳到下一个周期
            }
        }

        return buffer.toString();
    }
}
