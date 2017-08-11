package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A
 * gray code sequence must begin with 0.
 * 
 * <pre>
 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 * </pre>
 * 
 * Note:
 * <ol>
 * <li>For a given n, a gray code sequence is not uniquely defined.</li>
 * <li>For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.</li>
 * <li>For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.</li>
 * </ol>
 *
 * @author yunjie.du
 * @date 2017/8/11 15:41
 * @see <a href="https://leetcode.com/problems/gray-code/description/">text</a>
 */
public class N0089 {
    /**
     * 思想：假设n-1位生成的格雷码序列是A1,A2...Am-1,Am，则n位生成的是在前边加个1并逆序遍历，即：1Am,1Am-1...1A2,1A1。
     * 
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>((int) Math.pow(2, n));// 总共有2^n个
        res.add(0);// 初始时只有0
        for (int i = 1; i <= n; i++) {// 逐位递增生成
            int curLength = res.size(), carry = 1 << i - 1;// carry相当于最前边+1
            for (int j = curLength - 1; j >= 0; j--) {// 逆序在前边所有数前+1
                res.add(carry + res.get(j));
            }
        }

        return res;
    }
}
