package com.adu.leet_code.problems.algorithms.n0001;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * <pre>
 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/28 16:47
 * @see <a href="https://leetcode.com/problems/search-for-a-range/tabs/description">34. Search for a Range</a>
 */
public class N0034 {
    /**
     * 思想：二分查找。某个中间点命中后，该中间点向前找左边界点，向后找右边界点。
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        int i = 0, j = nums.length - 1, mid = 0;
        boolean found = false;// 标记是否找到

        while (i <= j) {
            mid = (i + j) >> 1;
            if (nums[mid] == target) {
                found = true;
                break;
            }
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        if (!found) {
            return res;
        }

        res[0] = getLeftBorderIndex(nums, target, i, mid);// 左边界下标
        res[1] = getRightBorderIndex(nums, target, mid, j);// 右边界下标
        return res;
    }

    /**
     * 在区间[left,right]内查找target的左边界下标。其中，nums[right]=target。
     * 
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    private int getLeftBorderIndex(int[] nums, int target, int left, int right) {
        if (nums[left] == target) {// 最左边即命中，直接返回
            return left;
        }

        for (int i = 0; i < 3; i++) {// 很多时间，相同元素并不多。在right点往前查3次，看是否可以查到。（顺序查找法）
            if (right-- > 0 && nums[right] != target) {
                return right + 1;
            }
        }

        // 二分查找法
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                right = mid - 1;
                if (nums[right] != target) {
                    return right + 1;
                }
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    /**
     * 在区间[left,right]内查找target的右边界下标。其中，nums[left]=target。
     * 
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    private int getRightBorderIndex(int[] nums, int target, int left, int right) {
        if (nums[right] == target) {// 最右边即命中，直接返回
            return right;
        }
        for (int i = 0; i < 3; i++) {// 很多时间，相同元素并不多。在left点往前查3次，看是否可以查到。（顺序查找法）
            if (left++ < nums.length - 1 && nums[left] != target) {
                return left - 1;
            }
        }

        // 二分查找法
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                left = mid + 1;
                if (nums[left] != target) {
                    return left - 1;
                }
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
