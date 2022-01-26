package com.tmmk.shdbd.leetcode;

import com.sun.media.sound.SoftTuning;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author Lost
 * @version 1.0.0
 * @date 2022-1-19 19:35
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix3(new String[] {"abab", "aba", "a"}));
    }

    public static String longestCommonPrefix3(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int idx = prefix.length();
        for (int j = 1; j < strs.length; j++) {
            if (idx == 0) {
                return "";
            }
            idx = Math.min(idx, strs[j].length());
            for (int i = 0; i < idx; i++) {
                if (prefix.charAt(i) != strs[j].charAt(i)) {
                    idx = i;
                    break;
                }
            }
            prefix = prefix.substring(0, idx);
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        byte[] zeros = strs[0].getBytes();
        int idx = zeros.length;
        for (int j = 1; j < strs.length; j++) {
            byte[] temp = strs[j].getBytes();
            if (temp.length == 0) {
                return "";
            }
            idx = Math.min(idx, temp.length);
            for (int i = 0; i < idx; i++) {
                if (i == 0 && zeros[i] != temp[i]) {
                    return "";
                }
                if (i >= temp.length || zeros[i] != temp[i]) {
                    idx = i;
                    break;
                }
            }
        }
        return new String(Arrays.copyOfRange(zeros, 0, idx));
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        byte[] zeros = strs[0].getBytes();
        StringBuilder comm = new StringBuilder();
        for (int i = 0; i < zeros.length; i++) {
            comm.append(new String(new byte[] {zeros[i]}));
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(comm.toString())) {
                    comm.delete(comm.length() - 1, comm.length());
                    return comm.toString();
                }
            }
        }
        return comm.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        byte[] zeros = strs[0].getBytes();
        byte[] comm = new byte[zeros.length];
        int index = 0;
        for (int i = 0; i < zeros.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                byte[] temp = strs[j].getBytes();
                if (i >= temp.length) {
                    return new String(Arrays.copyOf(comm, index));
                }
                if (zeros[i] != temp[i]) {
                    return new String(Arrays.copyOf(comm, index));
                }
            }
            comm[i] = zeros[i];
            index++;
        }
        return new String(Arrays.copyOf(comm, index));
    }
}
