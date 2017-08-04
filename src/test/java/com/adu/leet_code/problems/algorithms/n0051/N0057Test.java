package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/4 16:52
 */
public class N0057Test extends BaseTest {
    private N0057 n0057 = new N0057();
    private List<N0057.Interval> intervals;

    @Test
    public void insert() {
        List<N0057.Interval> res = n0057.insert(intervals, new N0057.Interval(4, 9));
        print(res);
    }

    @Before
    public void init() {
        intervals = new ArrayList<>();
        intervals.add(new N0057.Interval(1, 2));
        intervals.add(new N0057.Interval(3, 5));
        intervals.add(new N0057.Interval(6, 7));
        intervals.add(new N0057.Interval(8, 10));
        intervals.add(new N0057.Interval(12, 16));
    }
}
