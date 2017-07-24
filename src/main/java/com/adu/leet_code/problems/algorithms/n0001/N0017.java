package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * 
 * <pre>
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/24 14:50
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description">Letter Combinations
 *      of a Phone Number</a>
 */
public class N0017 {
    private static String[] LETTER_LIST = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return res;
        }

        genComb(digits, "", res);

        return res;
    }

    private void genComb(String digits, String comb, List<String> res) {
        if (digits.isEmpty()) {
            res.add(comb);
            return;
        }

        String letters = LETTER_LIST[digits.charAt(0) - '2'];
        String next = digits.substring(1);
        for (int i = 0; i < letters.length(); i++) {
            genComb(next, comb + letters.charAt(i), res);
        }
    }
}
