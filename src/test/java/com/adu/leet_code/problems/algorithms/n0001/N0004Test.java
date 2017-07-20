package com.adu.leet_code.problems.algorithms.n0001;

import com.adu.leet_code.problems.algorithms.n0001.N0004;
import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/19 18:52
 */
public class N0004Test extends BaseTest {
    private N0004 n0004 = new N0004();

    @Test
    public void findMedianSortedArrays() {
        int[] nums1 = new int[] { 1, 2 };
        int[] nums2 = new int[] { 3, 4 };
        double res = n0004.findMedianSortedArrays(nums1, nums2);

        logRes(res);
    }

}
