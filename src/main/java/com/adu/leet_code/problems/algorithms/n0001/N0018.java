package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * 
 * <pre>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/7/24 15:34
 * @see <a href="https://leetcode.com/problems/4sum/#/description">4Sum</a>
 */
public class N0018 {
    /**
     * 思想：先排序，双层循环先拿到前两个数，再从后边的列表中求得另两个数。
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);// 先排序

        for (int i = 0; i < nums.length - 3; i++) {// 第一个元素
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {// 若以i起始的4个最小和已经大于target，直接跳出
                break;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {// 若以i起始的4个最大和还小于target，则跳过i
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {// 跳过重复
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {// 第二个元素
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {// 若确定i,j后，最小和已大于target，直接跳出
                    break;
                }
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) {// 若确定i,j后，最大和还小于target，则跳过j
                    continue;
                }
                if (j != i + 1 && nums[j] == nums[j - 1]) {// 路过重复
                    continue;
                }

                int left = j + 1, right = nums.length - 1, twoTarget = target - nums[i] - nums[j];
                while (left < right) {// 第三个和第四个元素
                    int twoSum = nums[left] + nums[right];
                    if (twoSum == twoTarget) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {// 跳过重复
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {// 跳过重复
                            right--;
                        }
                        left++;
                        right--;
                    } else if (twoSum < twoTarget) {
                        left++;
                    } else {
                        right--;
                    }
                } // 第三、四个元素
            } // 第二个元素
        } // 第一个元素

        return res;
    }
}
