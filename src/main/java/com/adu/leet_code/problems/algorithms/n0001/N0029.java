package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author yunjie.du
 * @date 2017/7/26 18:11
 * @see <a href="https://leetcode.com/problems/divide-two-integers/#/description">Divide Two Integers</a>
 */
public class N0029 {
    /**
     * 思想：利用左移/右移对除数不断乘除2。
     * 
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        long y = Math.abs((long) dividend), x = Math.abs((long) divisor);
        if (y < x) {
            return 0;
        }

        long res = 0, origX = x;

        long ratio = 1;// 标记divisor的倍数n。
        while (y > x) {// x,2x,4x,8x...找到不小于y的nx。
            x = multi2(x);
            ratio = multi2(ratio);
        }

        while (true) {
            if (y < origX) {// 剩余的数已经不够再除了
                break;
            }

            if (y < x) {// y小于除数x了，那么x要进行衰减。
                x = div2(x);
                ratio = div2(ratio);
                continue;
            }

            y -= x;// 减去除数
            res += ratio;// 加上相应的倍数
        }

        res = (dividend ^ divisor) < 0 ? -res : res;// 正负号
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }

    private long multi2(long x) {
        return x << 1;
    }

    private long div2(long x) {
        return x >> 1;
    }
}
