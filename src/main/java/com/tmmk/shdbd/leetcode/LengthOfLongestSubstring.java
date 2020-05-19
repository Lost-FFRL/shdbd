package com.tmmk.shdbd.leetcode;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 *
 * @author zhangpeijun
 * @date 2020/5/7
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        String str = "aa";
        System.out.println(set(str));
    }

    public static int set(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int subLen = 0;
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end++;
            if (!set.add(s.charAt(i))) {
                start = end;
            }
            subLen = Math.max(subLen, end - start + 1);
        }
        return subLen;
    }

    public int first(String str) {
        int length = str.length();
        String subStr = "";
        int subLen = 0;
        String tmp;
        for (int i = 0; i < length; i++) {
            tmp = str.substring(i, i + 1);
            if (subStr.contains(tmp)) {
                subLen = Math.max(subLen, subStr.length());
                subStr = subStr.substring(subStr.lastIndexOf(tmp) + 1) + tmp;
            } else {
                subStr = subStr + tmp;
            }
        }
        return Math.max(subLen, subStr.length());
    }

    public static int list(String str) {
        int length = str.length();
        List<String> list = new LinkedList<>();
        int subLen = 0;
        String tmp;
        for (int i = 0; i < length; i++) {
            tmp = str.substring(i, i + 1);
            if (list.contains(tmp)) {
                subLen = subLen > list.size() ? subLen : list.size();
                list = list.subList(list.lastIndexOf(tmp) + 1, list.size());
            }
            list.add(tmp);
            System.out.println(list);
        }
        return subLen > list.size() ? subLen : list.size();
    }


}
