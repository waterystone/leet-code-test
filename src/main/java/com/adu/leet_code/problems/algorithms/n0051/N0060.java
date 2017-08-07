package com.adu.leet_code.problems.algorithms.n0051;

import java.util.HashMap;
import java.util.Map;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3):
 * 
 * <pre>
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 * </pre>
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author yunjie.du
 * @date 2017/8/4 18:16
 * @see <a href="https://leetcode.com/problems/permutation-sequence/description/">60. Permutation Sequence</a>
 */
public class N0060 {
    /**
     * 思想：根据跳过的数，从高到低依次确定各位的值。
     * 
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder(n);
        Map<Integer, Integer> factorialMap = buildFactorialMap(n);// 一次生成0-n的阶乘，避免重复计算
        boolean[] used = new boolean[n];// 标记1-n这n个数字的使用状态

        for (int i = 1; i <= n; i++) {// 从高到低依次确认各位的数字
            int skip = 0, remainFactorial = factorialMap.get(n - i), count = 1;// remainFactorial为剩余个数的阶乘，便于统计跳过数；count为跳过的数。
            for (; count <= n; count++) {
                if (skip + remainFactorial >= k) {// 如果下一阶段越界
                    break;
                }
                skip += remainFactorial;
            }

            int num = findNthUnUsed(used, count);// 找到第count个未使用的数字，即该位的数字。
            used[num - 1] = true;// 该数字标记为已使用状态
            builder.append(num);// 添加到结果中
            k -= skip;// k要减去本位的跳过数，方便下一位的计算
        }

        return builder.toString();
    }

    /**
     * 找到第n个未使用的数字
     * 
     * @param used
     * @param n
     * @return
     */
    private int findNthUnUsed(boolean[] used, int n) {
        int count = 0;
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && ++count == n) {
                return i + 1;
            }
        }

        return 0;// just fake.
    }

    /**
     * 计算0-n的阶乘
     * 
     * @param n
     * @return key为0-n的数，value为相应的阶乘。
     */
    private Map<Integer, Integer> buildFactorialMap(int n) {
        Map<Integer, Integer> res = new HashMap<>(n);
        res.put(0, 1);
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            res.put(i, factorial);
        }

        return res;
    }
}
