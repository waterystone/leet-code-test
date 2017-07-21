package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the
 * reversed integer might overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * @author yunjie.du
 * @date 2017/7/21 10:51
 * @see <a href="https://leetcode.com/problems/palindrome-number/#/description">Palindrome Number</a>
 */
public class N0009 {
    /**
     * 思路：通过判断前一半的数和后一半反转的数是否相等。
     * 
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {// 负数、个数是0的直接判负
            return false;
        }

        int reverse = 0;// 回文的数
        while (x > reverse) {// 最多回文一半，x为高一半的数，reverse为低一半的数（若奇位，reverse包含中间那位）。
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        // 偶位判x==reverse,奇位判x==reverse/10。
        return (x == reverse || x == reverse / 10);
    }

}
