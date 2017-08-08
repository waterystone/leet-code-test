package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author yunjie.du
 * @date 2017/8/8 15:37
 * @see <a href="https://leetcode.com/problems/plus-one/description/">66. Plus One</a>
 */
public class N0066 {
    /**
     * 思想：从后往前找到第一个非9的数，该位置的数+1，其后的数都置为零。
     * 
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int lastNotNine = digits.length - 1;// 从后往前第一个非9的位置
        for (; lastNotNine >= 0; lastNotNine--) {
            if (digits[lastNotNine] != 9) {
                break;
            }
        }
        if (lastNotNine == -1) {// 如果全为9
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }

        digits[lastNotNine]++;// 非9位置的数+1，其后的数都置为零。
        for (int i = lastNotNine + 1; i < digits.length; i++) {
            digits[i] = 0;
        }

        return digits;
    }

    /**
     * 思想：逐位计算。
     * 
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        int[] result = new int[digits.length];
        int carry = 1;// 代表+1
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            if (sum > 9) {
                sum = 0;
                carry = 1;
            } else if (carry != 0) {
                carry = 0;
            }

            result[i] = sum;
        }

        if (carry == 0) {
            return result;
        }

        // 如果整体有进位
        return copyWithCarry(result);
    }

    private int[] copyWithCarry(int[] digits) {
        int[] result = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i + 1] = digits[i];
        }

        result[0] = 1;
        return result;
    }
}
