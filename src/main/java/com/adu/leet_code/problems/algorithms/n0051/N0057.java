package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

import com.adu.leet_code.problems.util.Stringfy;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * <pre>
 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * </pre>
 * 
 * <pre>
 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/4 16:25
 * @see <a href="https://leetcode.com/problems/insert-interval/description/">57. Insert Interval</a>
 */
public class N0057 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals.isEmpty()) {
            res.add(newInterval);
            return res;
        }

        int preStart = newInterval.start, preEnd = newInterval.end;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < preStart) {// 如果还没到
                res.add(interval);
                continue;
            }

            if (interval.start > preEnd) {// 如果已经过了
                res.add(new Interval(preStart, preEnd));
                while (i < intervals.size()) {// 添加余下的区间
                    res.add(intervals.get(i++));
                }

                return res;
            }

            // merge
            preStart = Math.min(interval.start, preStart);
            preEnd = Math.max(interval.end, preEnd);
        }
        res.add(new Interval(preStart, preEnd));

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
