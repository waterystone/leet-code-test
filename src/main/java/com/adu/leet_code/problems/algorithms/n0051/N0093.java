package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * <pre>
 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/8/14 10:43
 * @see <a href="https://leetcode.com/problems/restore-ip-addresses/description/">93. Restore IP Addresses</a>
 */
public class N0093 {
    /**
     * 思想：递归。每递归到一个元素，有两种情况：截止该元素，形成一个新号段；不截止，继续递归。
     * 
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();

        restoreIpAddresses(chars, 0, 0, new ArrayList<>(), res);
        return res;
    }

    /**
     * @param chars
     * @param i 当前元素
     * @param prevIndex 目前号段的最前边字符的下标。
     * @param curList 当前列表
     * @param res
     */
    private void restoreIpAddresses(char[] chars, int i, int prevIndex, List<String> curList, List<String> res) {
        if (chars.length - i + curList.size() < 4) {// 如果剩余元素个数不够需要号段数了
            return;
        }

        if (curList.size() == 3) {// 就差最后一个号段了，只能看看剩余元素是不是合法的
            if (isLegal(chars, i, chars.length - 1)) {// 判断合法
                curList.add(new String(chars, i, chars.length - i));
                res.add(String.join(".", curList));
            }

            return;
        }

        if (!isLegal(chars, prevIndex, i)) {// 如果该元素在当前号段中已非法
            return;

        }

        // 将当前元素加入当前号段中，并截止。
        List<String> newList = new ArrayList<>(curList);
        newList.add(new String(chars, prevIndex, i - prevIndex + 1));
        restoreIpAddresses(chars, i + 1, i + 1, newList, res);

        // 在当前元素不截止，继续走。
        if (!(chars[i] == '0' && prevIndex == i)) {// 如果当前号段只有当前元素并且当前元素是'0',就不能继续走了（不能是0**的情况）。
            restoreIpAddresses(chars, i + 1, prevIndex, new ArrayList<>(curList), res);
        }
    }

    /**
     * 判断子串是否能形成一个合法号段
     * 
     * @param chars
     * @param start
     * @param end
     * @return
     */
    private boolean isLegal(char[] chars, int start, int end) {
        int count = end - start + 1;// 个数
        if (count > 3 || (start != end && chars[start] == '0')) {// 如果长度大于3，或者是0开头的情况
            return false;
        }

        if (count < 3) {// 如果长度小于3，直接合法
            return true;
        }

        // 1**,2a*(a<5),25a(a<=5)
        return chars[start] == '1' || (chars[start] == '2'
                && (chars[start + 1] < '5' || (chars[start + 1] == '5' && chars[start + 2] <= '5')));
    }

}
