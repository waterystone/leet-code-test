package com.adu.leet_code.problems.algorithms.n0051;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * @author yunjie.du
 * @date 2017/8/9 11:33
 * @see <a href="https://leetcode.com/problems/climbing-stairs/description/">70. Climbing Stairs</a>
 */
public class N0070 {
    /**
     * 思想：可以跳一步或两步，那么在n处的路径数f(n)=f(n+1)+f(n+2)
     * 
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int a = 0, b = 1, c = 1;// 用三个变量代替数组,abc为相邻的三个数
        for (int i = n - 2; i >= 0; i--) {// 从后向前
            a = b + c;// a前移

            c = b;// c前移
            b = a;// b前移
        }

        return a;
    }

    /**
     * 思想：可以跳一步或两步，那么在n处的路径数f(n)=f(n+1)+f(n+2)
     * 
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n < 2) {
            return 1;
        }

        int[] steps = new int[n + 1];// 申请n+1维的数组代表每个位置的路径数
        steps[n] = 1;// 终点
        steps[n - 1] = 1;// 倒数第二个点

        for (int i = n - 2; i >= 0; i--) {// 从后往前依次计算
            steps[i] = steps[i + 1] + steps[i + 2];
        }

        return steps[0];
    }
}
