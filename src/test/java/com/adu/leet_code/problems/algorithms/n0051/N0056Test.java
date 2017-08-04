package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/4 15:56
 */
public class N0056Test extends BaseTest {
    private N0056 n0056 = new N0056();
    private List<N0056.Interval> intervals;

    @Test
    public void merge() {
        List<N0056.Interval> res = n0056.merge(intervals);
        print(res);
    }

    @Before
    public void init() {
        intervals = new ArrayList<>();
        intervals.add(new N0056.Interval(1, 4));
        intervals.add(new N0056.Interval(1, 4));
    }
}
