package com.adu.leet_code.problems.algorithms.n0051;

import java.util.LinkedList;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * <pre>
 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/9 12:31
 * @see <a href="https://leetcode.com/problems/simplify-path/description/">71. Simplify Path</a>
 */
public class N0071 {
    /**
     * 思想：用链表（方便尾部添加/删除操作）保存各个子路径，遇到常规路径添加到链表尾部，遇到"."忽略，遇到".."删除链表尾结点。最后再把链表里的子路径串接起来。
     * 
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        if (path.length() < 2) {// 如果是"/"
            return path;
        }

        LinkedList<String> list = new LinkedList<>();// 链表保存各子路径
        int startIndex = 1;
        while (startIndex < path.length()) {
            startIndex = ignoreContinuousSpliter(path, startIndex);// 忽略连续的"/"
            if (startIndex == -1) {
                break;
            }
            int endIndex = getSubPathEndIndex(path, startIndex);// 所在子路径最后一个字母的位置

            String subPath = path.substring(startIndex, endIndex + 1);// 子路径

            if ("..".equals(subPath)) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
            } else if (!".".equals(subPath)) {
                list.add(subPath);
            }

            startIndex = endIndex + 2;// 下一个子路径的开始位置
        }

        return buildSimplifyPath(list);// 构建简化后的路径
    }

    /**
     * 忽略开始处连续的"/"
     * 
     * @param path
     * @param startIndex
     * @return 首个非"/"的位置，如果后边全是"/"返回-1.
     */
    private int ignoreContinuousSpliter(String path, int startIndex) {
        for (int i = startIndex; i < path.length(); i++) {
            if (path.charAt(i) != '/') {
                return i;
            }
        }

        return -1;
    }

    /**
     * 从指定位置开始，找到所在子路径的最后一个字母位置。
     * 
     * @param path
     * @param startIndex
     * @return
     */
    private int getSubPathEndIndex(String path, int startIndex) {
        for (int i = startIndex + 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                return i - 1;
            }
        }

        return path.length() - 1;
    }

    /**
     * 从链表构建简化的路径
     * 
     * @param list
     * @return
     */
    private String buildSimplifyPath(LinkedList<String> list) {
        if (list.isEmpty()) {
            return "/";
        }

        StringBuilder builder = new StringBuilder();
        for (String subPath : list) {
            builder.append('/').append(subPath);
        }

        return builder.toString();
    }

}
