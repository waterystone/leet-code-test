package com.adu.leet_code.problems.algorithms.n0051;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose an array sorted in ascending order is rotated at some
 * pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * The array may contain duplicates.
 * 
 * @author yunjie.du
 * @date 2017/8/10 16:33
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/">81. Search in Rotated
 *      Sorted Array II</a>
 */
public class N0081 {
    /**
     * 思想：先找到中间最大值的位置，如果在最大值的左边，那么在左边二分查找；如果在右边，那么在右边二分查找。
     * 
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        if (nums[0] == target) {// 旋转点命中
            return true;
        }

        int maxValueIndex = findMaxValueIndex(nums);// 找到分界处的最大值

        int left = target > nums[0] ? 0 : maxValueIndex + 1, right = target > nums[0] ? maxValueIndex : nums.length - 1;// 左区间
                                                                                                                        // OR
                                                                                                                        // 右区间

        while (left <= right) {// 二分查找
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            }

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    private int findMaxValueIndex(int[] nums) {
        int left = 0, right = nums.length - 1;// left一直在左区间，right一直在右区间
        while (left < right) {
            while (left < nums.length - 1 && nums[left + 1] == nums[left]) {// 路过相同元素
                left++;
            }
            while (right > 0 && nums[right - 1] == nums[right]) {// 路过相同元素
                right--;
            }
            if (right - left <= 1) {// left与right距离不超过1
                return nums[right] >= nums[left] ? right : left;// 有可能没有旋转，一直升序
            }

            int mid = (left + right) >> 1;
            if (nums[left] < nums[mid]) {
                left = mid;// 不+1，防止跳到右区间
            } else {
                right = mid;// 不+1，防止跳到左区间
            }
        }

        return left;// just fake.
    }
}
