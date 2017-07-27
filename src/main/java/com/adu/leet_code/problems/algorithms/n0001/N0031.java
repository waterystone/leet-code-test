package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending
 * order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand
 * column.
 * 
 * <pre>
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/27 14:57
 * @see <a href="https://leetcode.com/problems/next-permutation/tabs/description">31. Next Permutation</a>
 */
public class N0031 {
    /**
     * 思想：从后往前找个首个降序的元素a，然后和后边大于a的最小元素b进行交换。此时a后边的元素依然是降序的，再将其反转改为升序即可。
     * 
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int i = nums.length - 2;
        for (; i >= 0; i--) {// 从尾往前扫
            if (nums[i] < nums[i + 1]) {// 找到第一个降序的元素
                int leastBiggerIndex = findLeastBiggerIndex(nums, i + 1, nums[i]);// 找到后边大于该元素的最小元素
                swap(nums, i, leastBiggerIndex);// 交换。交换后后边的元素依然保持降序
                break;
            }
        }

        // 后边的元素是降序的，要对其进行升序才能获得字典序的下一个。
        reverse(nums, i + 1, nums.length - 1);

    }

    /**
     * 反转对应区间内的元素
     * 
     * @param nums
     * @param start 起始下标，包括。
     * @param end 结束下标，包括。
     */
    private void reverse(int[] nums, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    /**
     * 从数组指定下标开始，找到大于x的最小值。
     * 
     * @param nums 从i开始降序，且i处元素>x。
     * @param i 开始下标，包括。
     * @param x
     * @return
     */
    private int findLeastBiggerIndex(int[] nums, int i, int x) {
        int k = i;
        for (; k < nums.length; k++) {
            if (nums[k] <= x) {
                break;// 首个小于x的元素
            }
        }

        return k - 1;// 返回上一个元素的下标
    }

    /**
     * 交换
     * 
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
