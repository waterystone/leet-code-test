package com.adu.leet_code.problems.algorithms.n0001;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 
 * <pre>
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 * </pre>
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * <pre>
 Example 1:

 Input: 1
 Output: "1"
 * </pre>
 * 
 * <pre>
 Example 2:

 Input: 4
 Output: "1211"
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/1 15:12
 * @see <a href="https://leetcode.com/problems/count-and-say/description/">38. Count and Say</a>
 */
public class N0038 {
    /**
     * 思想：一层一层读。
     * 
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) {
            return res;
        }

        for (int i = 2; i <= n; i++) {
            res = countAndSay(res);
        }

        return res;
    }

    private String countAndSay(String str) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == str.charAt(i - 1)) {
                count++;
                continue;
            }

            builder.append(count).append(str.charAt(i - 1));
            count = 1;
        }

        builder.append(count).append(str.charAt(str.length() - 1));

        return builder.toString();
    }
}
