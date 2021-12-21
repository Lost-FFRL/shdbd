package com.tmmk.shdbd.leetcode;

import java.io.ByteArrayOutputStream;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2021-12-15 21:31
 */
public class SolutionStr {

    public static void main(String[] args) {
        System.out.println(strStr4("mississippi", "issipi"));
        System.out.println(strStr4("aaabbaa", "bba"));
    }

    public static int strStr4(String haystack, String needle) {
        // 通过 2 ms
        if (needle.length() == 0) {
            return 0;
        } else if (needle.length() <= haystack.length()) {
            char[] hay = haystack.toCharArray();
            char[] n = needle.toCharArray();
            int index = 0;
            char star = n[0];
            char end = n[n.length - 1];
            while (index <= hay.length - n.length) {
                if (hay[index] == star && hay[index + n.length - 1] == end) {
                    boolean flag = true;
                    int i = 0;
                    while (++i < n.length - 1) {
                        if (hay[index + i] != n[i]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return index;
                    }
                }
                index++;
            }
        }
        return -1;
    }

    public static int strStr3(String haystack, String needle) {
        // 通过 2 ms
        int result = -1;
        if (needle.length() == 0) {
            result = 0;
        } else if (needle.length() <= haystack.length()) {
            char[] hay = haystack.toCharArray();
            char[] n = needle.toCharArray();
            int index = 0;
            while (index <= hay.length - n.length) {
                if (hay[index] == n[0] && hay[index + n.length - 1] == n[n.length - 1]) {
                    boolean flag = true;
                    for (int i = 1; i < n.length - 1; i++) {
                        if (hay[index + i] != n[i]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        result = index;
                        break;
                    }
                }
                index++;
            }
        }
        return result;
    }

    public static int strStr2(String haystack, String needle) {
        // 通过 14ms
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        String[] arr = haystack.split(needle);
        if (arr.length == 0) {
            return 0;
        }
        return arr.length != 1 || (arr.length == 1 && haystack.length() != arr[0].length()) ? arr[0].length() : -1;
    }

    public static int strStr1(String haystack, String needle) {
        // 通过 355 ms
        int result = -1;
        if (needle.length() == 0) {
            result = 0;
        } else if (needle.length() <= haystack.length()) {
            char[] hay = haystack.toCharArray();
            char[] n = needle.toCharArray();
            int index = 0;
            while (index < hay.length) {
                if (hay[index] == n[0] && index <= hay.length - n.length) {
                    boolean flag = true;
                    for (int i = 1; i < n.length; i++) {
                        if (hay[index + i] != n[i]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        result = index;
                        break;
                    }
                }
                index++;
            }
        }
        return result;
    }

    public static int strStr0(String haystack, String needle) {
        // 通过 416 ms
        return haystack.indexOf(needle);
    }
}
