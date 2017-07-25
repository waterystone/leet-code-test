package com.adu.leet_code.problems.algorithms.n0001;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * 
 * <pre>
 * For example, given n = 3, a solution set is:
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/7/25 14:56
 * @see <a href="https://leetcode.com/problems/generate-parentheses/#/description">Generate Parentheses</a>
 */
public class N0022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        return generate(res, "", 0, 2 * n);
    }

    /**
     * @param res
     * @param prefix 前缀
     * @param credit 前缀里待匹配的正向括号，可以认为累积的信用值。如(()，则其credit为1。
     * @param n 剩余子串大小
     * @return
     */
    private List<String> generate(List<String> res, String prefix, int credit, int n) {
        if (n == 1) {// 串尾只能是)
            res.add(prefix + ")");
            return res;
        }

        if (credit < n) {//如果信用值小于n，说明还是可以再放正向括号的。
            generate(res, prefix + "(", credit + 1, n - 1);
        }
        if (credit > 0) {//如果信用值大于0，说明可以放反向括号。
            generate(res, prefix + ")", credit - 1, n - 1);
        }

        return res;
    }
}
