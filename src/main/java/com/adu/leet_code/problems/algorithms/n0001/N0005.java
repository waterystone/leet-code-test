package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yunjie.du
 * @date 2017/7/20 11:03
 */
public class N0005 {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        String res = String.valueOf(s.charAt(0));

        Map<Character, List<Integer>> charIndexList = getCharIndexList(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            List<Integer> indexList = charIndexList.get(ch);
            if (indexList.size() == 1) {
                continue;
            }

            for (int index = indexList.size() - 1; indexList.get(index) > i; index--) {
                int j = indexList.get(index);
                if (j - i + 1 <= res.length()) {
                    break;
                }

                if (isPalindrome(s, i, j)) {
                    res = s.substring(i, j + 1);
                }

            }

        }

        return res.isEmpty() ? null : res;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 获取各字符的下标（按顺序）
     * 
     * @param s
     * @return
     */
    private Map<Character, List<Integer>> getCharIndexList(String s) {
        Map<Character, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!res.containsKey(ch)) {
                res.put(ch, new ArrayList<>());
            }
            res.get(ch).add(i);
        }

        return res;
    }
}
