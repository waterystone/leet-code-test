package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully
 * (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * <pre>
 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 * </pre>
 * 
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * @author yunjie.du
 * @date 2017/8/8 17:32
 * @see <a href="https://leetcode.com/problems/text-justification/description/">68. Text Justification</a>
 */
public class N0068 {
    /**
     * 思想：逐组统计。
     * 
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (maxWidth == 0) {// 如果最大长度为0了
            for (String word : words) {
                res.add(word);
            }
            return res;
        }

        int startIndex = 0, sum = 0;// 该组的起始下标及该组的单词长度总和(包括中间的一个空格)
        for (int i = 0; i < words.length; i++) {
            if (sum + words[i].length() <= maxWidth) {// 如果组里还能容下该单词
                sum += words[i].length() + 1;// 追加一个空格的长度
                continue;
            }

            // 组里容不上该单词了，对组里单词进行格式化调整。
            String subJustifyString = getSubJustifyString(words, startIndex, i - 1, sum - 1, maxWidth);
            res.add(subJustifyString);
            startIndex = i;// 从该单词重新统计
            sum = words[i].length() + 1;
        }

        // 追加最后一组的内容
        res.add(getLastString(words, startIndex, maxWidth));
        return res;
    }

    /**
     * 组内单词进行格式化操作。
     * 
     * @param words
     * @param start 开始下标，包括。
     * @param end 结束下标，包括。
     * @param sum 开始单词到结束单词的总长度，包括单词间的一个空格。
     * @param maxWidth 最大长度
     * @return
     */
    private String getSubJustifyString(String[] words, int start, int end, int sum, int maxWidth) {
        StringBuilder builder = new StringBuilder(maxWidth);
        int wordCount = end - start + 1;// 单词个数
        if (wordCount == 1) {
            builder.append(words[start]);
            appendSpaces(builder, maxWidth - words[start].length());
            return builder.toString();
        }

        int avgSpaceCount = (maxWidth - sum) / (wordCount - 1) + 1,
                remainSpaceCount = maxWidth - sum - (wordCount - 1) * (avgSpaceCount - 1);// 平均空格数，及平均完后仍剩余空格数
        for (int i = start; i < end; i++) {
            builder.append(words[i]);
            appendSpaces(builder, avgSpaceCount + ((i - start < remainSpaceCount) ? 1 : 0));// 剩余空格再均匀分配到前边
        }

        builder.append(words[end]);// 追加最后一个单词
        return builder.toString();
    }

    /**
     * 最后一组进行格式化操作。
     * 
     * @param words
     * @param i 最后一组的开始下标，包括。
     * @param maxWidth
     * @return
     */
    private String getLastString(String[] words, int i, int maxWidth) {
        StringBuilder builder = new StringBuilder(maxWidth);
        while (i < words.length) {
            builder.append(words[i++]).append(' ');// 只加一个空格
        }
        if (builder.length() < maxWidth) {// 补空格
            appendSpaces(builder, maxWidth - builder.length());
        }

        return builder.substring(0, maxWidth);
    }

    /**
     * 追加指定个数的空格
     * 
     * @param builder
     * @param count
     */
    private void appendSpaces(StringBuilder builder, int count) {
        while (count-- > 0) {
            builder.append(' ');
        }
    }
}
