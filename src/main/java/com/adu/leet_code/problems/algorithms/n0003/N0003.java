package com.adu.leet_code.problems.algorithms.n0003;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunjie.du
 * @date 2017/7/19 16:27
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
