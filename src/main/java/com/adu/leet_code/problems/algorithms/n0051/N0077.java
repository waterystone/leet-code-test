package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * <pre>
 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/10 11:16
 * @see <a href="https://leetcode.com/problems/combinations/description/">77. Combinations</a>
 */
public class N0077 {
    /**
     * 思想：递归。对于当前数n、k，有两种情况：
     * <ol>
     * <li>如果选n，则下一次从n-1个数里选k-1个数；</li>
     * <li>如果不选n，则下一次从n-1个数里选k个数。</li>
     * </ol>
     * 
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(n, k, new ArrayList<>(), res);

        return res;
    }

    private void combine(int n, int k, List<Integer> curList, List<List<Integer>> res) {
        if (k > n) {// 如果剩余的数不够k个了，直接返回
            return;
        }
        if (k == 0) {// 都选定了
            res.add(curList);
            return;
        }

        // 不选n，继续
        combine(n - 1, k, new ArrayList<>(curList), res);

        // 选n，继续
        curList.add(n);
        combine(n - 1, k - 1, new ArrayList<>(curList), res);
    }

}
