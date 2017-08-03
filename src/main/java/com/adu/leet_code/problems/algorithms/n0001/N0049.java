package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * <pre>
 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 * </pre>
 * 
 * Note: All inputs will be in lower-case.
 * 
 * @author yunjie.du
 * @date 2017/8/3 16:56
 * @see <a href="https://leetcode.com/problems/group-anagrams/description/">49. Group Anagrams</a>
 */
public class N0049 {
    private static final int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
            79, 83, 89, 97, 101 };

    /**
     * 思想：利用素数的性质。'a'-'z'每个字符代表一个素数，对于一个字符串，计算其各位字符的素数积代表其聚合key。<br/>
     *
     * NOTE:
     * <ol>
     * <li>该聚合key与顺序无关，即key(abc)=key(bac)=key(cab)。</li>
     * <li>不同的字符串（不考虑顺序），其key是唯一的。</li>
     * <li>注意key的范围，防止越界。在只有小写字母时，字符串长度可以达到2^32/101=4*10^9/10^2=4*10^7，所以一般key用int即可。</li>
     * <ol/>
     * 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<Integer, Integer> groupKey2IndexMap = new HashMap<>();// 字符串聚合key在res中对应的下标
        for (String str : strs) {
            int groupKey = calcGroupKey(str);// 拿到排序字符串
            if (!groupKey2IndexMap.containsKey(groupKey)) {
                groupKey2IndexMap.put(groupKey, res.size());
                res.add(new ArrayList<>());
            }

            res.get(groupKey2IndexMap.get(groupKey)).add(str);
        }

        return res;
    }

    /**
     * 计算字符串的聚合key
     * 
     * @param str
     * @return
     */
    private int calcGroupKey(String str) {
        int groupKey = 1;
        for (int i = 0; i < str.length(); i++) {
            groupKey *= prime[str.charAt(i) - 'a'];
        }
        return groupKey;
    }

    /**
     * 思想：对每个字符串进行排序，然后按排序字符串进行聚合。
     * 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, Integer> sortedString2IndexMap = new HashMap<>();// 排序字符串在res中对应的下标
        for (String str : strs) {
            String sortedString = sort(str);// 拿到排序字符串
            if (!sortedString2IndexMap.containsKey(sortedString)) {
                sortedString2IndexMap.put(sortedString, res.size());
                res.add(new ArrayList<>());
            }

            res.get(sortedString2IndexMap.get(sortedString)).add(str);
        }

        return res;
    }

    /**
     * 计数排序，O(n)
     * 
     * @param str
     * @return
     */
    private String sort(String str) {
        if (str.length() < 2) {
            return str;
        }

        int[] counter = new int[26];
        for (int i = 0; i < str.length(); i++) {// 统计各字符个数
            counter[str.charAt(i) - 'a']++;
        }

        StringBuilder builder = new StringBuilder(str.length());
        for (int i = 0; i < counter.length; i++) {
            char ch = (char) (i + 'a');
            for (int k = 0; k < counter[i]; k++) {// 该字符出现次数
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
