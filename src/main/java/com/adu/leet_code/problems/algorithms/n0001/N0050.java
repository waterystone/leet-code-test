package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Implement pow(x, n).
 * 
 * @author yunjie.du
 * @date 2017/8/3 17:55
 * @see <a href="https://leetcode.com/problems/powx-n/description/">50. Pow(x, n)</a>
 */
public class N0050 {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }

        long m = Math.abs((long) n);
        double res = myPositivePow(x, m);
        return n < 0 ? 1 / res : res;
    }

    private double myPositivePow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = myPositivePow(x, n / 2);
        if (n % 2 == 1) {
            return x * half * half;
        }

        return half * half;
    }
}
