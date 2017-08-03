package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/3 17:07
 */
public class N0049Test extends BaseTest {
    private N0049 n0049 = new N0049();

    @Test
    public void groupAnagrams() {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> res = n0049.groupAnagrams(strs);
        print(res);
    }
}
