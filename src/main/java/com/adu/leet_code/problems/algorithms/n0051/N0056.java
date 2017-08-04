package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.adu.leet_code.problems.util.Stringfy;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * <pre>
 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/4 15:51
 * @see <a href="https://leetcode.com/problems/merge-intervals/description/">56. Merge Intervals</a>
 */
public class N0056 {
    /**
     * 思想：先按区间的首部排序，然后逐个合并。
     * 
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {// 先排序
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int preStart = intervals.get(0).start, preEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {// 逐个合并
            Interval interval = intervals.get(i);
            if (interval.end <= preEnd) {// 如果本区间在上个范围内
                continue;
            }

            if (interval.start <= preEnd && interval.end > preEnd) {// 如果有重叠
                preEnd = interval.end;
                continue;
            }

            // 无重叠
            res.add(new Interval(preStart, preEnd));
            preStart = interval.start;
            preEnd = interval.end;
        }

        res.add(new Interval(preStart, preEnd));// 添加最后一个
        return res;
    }

    public static class Interval extends Stringfy {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

    }
}
