package com.adu.leet_code.problems.algorithms.n0001;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * 
 * <pre>
 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/19 16:27
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description">Longest
 *      Substring Without Repeating Characters</a>
 */
public class N0003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, max = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                max = Math.max(max, j - i);
                int newi = map.get(s.charAt(j)) + 1;

                for (int k = i; k < newi; k++) {
                    map.remove(s.charAt(k));
                }
                i = newi;
            }

            map.put(s.charAt(j), j);
        }

        max = Math.max(max, s.length() - i);
        return max;
    }
}
