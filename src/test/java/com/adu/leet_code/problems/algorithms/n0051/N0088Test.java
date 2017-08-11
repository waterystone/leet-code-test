package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/11 15:25
 */
public class N0088Test extends BaseTest {
    private N0088 n0088 = new N0088();

    @Test
    public void merge() {
        int[] nums1 = { 1, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0, 0, 0 }, nums2 = { 2, 4, 6, 8 };
        n0088.merge(nums1, 5, nums2, 4);
        logRes(nums1);
    }
}
