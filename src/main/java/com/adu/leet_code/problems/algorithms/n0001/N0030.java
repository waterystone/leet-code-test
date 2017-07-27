package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * 
 * <pre>
 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/27 11:03
 * @see <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/#/description">Substring with
 *      Concatenation of All Words</a>
 */
public class N0030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return res;
        }
        int wordLength = words[0].length(), totalWordLength = words.length * wordLength;
        if (s.length() < totalWordLength) {
            return res;
        }

        Map<String, Integer> word2IsAppearMap = buildWord2IsAppearMap(words), tempMap = new HashMap<>();
        boolean needInit = false;

        for (int i = 0; i <= s.length() - totalWordLength; i++) {
            if (needInit) {
                tempMap.clear();
            }

            int j = 0;
            for (; j < words.length; j++) {
                int index = i + j * wordLength;
                String word = s.substring(index, index + wordLength);
                if (word2IsAppearMap.containsKey(word) && tempMap.getOrDefault(word, 0) < word2IsAppearMap.get(word)) {
                    tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);
                    needInit = true;
                } else {
                    break;
                }
            }
            if (j == words.length) {
                res.add(i);
            }

        }

        return res;
    }

    private Map<String, Integer> buildWord2IsAppearMap(String[] words) {
        Map<String, Integer> res = new HashMap<>(words.length);
        for (String word : words) {
            res.put(word, res.getOrDefault(word, 0) + 1);
        }

        return res;
    }

}
