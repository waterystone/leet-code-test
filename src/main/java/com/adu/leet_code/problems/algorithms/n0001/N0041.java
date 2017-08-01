package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * <pre>
 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.
 * </pre>
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author yunjie.du
 * @date 2017/8/1 18:43
 * @see <a href="https://leetcode.com/problems/first-missing-positive/description/">41. First Missing Positive</a>
 */
public class N0041 {
    /**
     * 思想：利用下标和元素值的关系，将正数元素放到其值对应的下标处。再遍历数组，找到首个下标与元素值不对应的元素。
     * 
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            if (e <= 0 || e == i + 1) {// 如果非正数，或者该位置已对应，则跳过
                continue;
            }

            // 下面，该元素需要移动到合适的位置
            nums[i] = 0;// 该位置用零填充

            while (e > 0 && e <= nums.length) {
                // e的下一个目标位置是e-1处
                if (nums[e - 1] == e) {// 如果e-1处已经是e，则跳出
                    break;
                }

                int temp = nums[e - 1];// 保存e-1处的元素
                nums[e - 1] = e;// 设置e-1处的映射值
                e = temp;// 循环对原e-1处的值进行处理，直到e不能映射到e-1处为止
            }

        }

        for (int i = 0; i < nums.length; i++) {// 遍历数组，找到首个下标与元素值不对应的元素
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;// 如果数组里都对应了，则返回数组长度+1
    }
}
