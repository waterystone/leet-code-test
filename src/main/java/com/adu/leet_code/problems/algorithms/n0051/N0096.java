package com.adu.leet_code.problems.algorithms.n0051;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * <pre>
 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/8/14 15:42
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees/description/">96. Unique Binary Search
 *      Trees</a>
 */
public class N0096 {
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }

        int[] f = new int[n + 1];
        f[0] = 1;

        // 1:0-0
        // 2:0-1,1-0
        // 3:0-2,1-1,2-0
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j] * f[i - 1 - j];
            }
        }

        return f[n];
    }

    /**
     * 思想：1-n每个值依次当root，在某个值k当root时，左子树区间[1,k-1]及右子树区间[k+1,n]都有多种形态。将左子树和右子树的形态数x、y相乘，即为k为root的形态数。
     *
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        if (n < 1) {
            return 0;
        }
        Map<String, Integer> cache = new HashMap<>(n * n);
        return numTrees(1, n, cache);
    }

    private int numTrees(int start, int end, Map<String, Integer> cache) {
        String key = String.format("%s-%s", start, end);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int sum = 0;

        if (start > end) {
            sum = 1;
        } else {
            for (int k = start; k <= end; k++) {
                int left = numTrees(start, k - 1, cache);
                int right = numTrees(k + 1, end, cache);
                sum += left * right;
            }
        }

        cache.put(key, sum);
        return sum;
    }
}
