package com.tmmk.shdbd.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: s = "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: s = "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2022-1-5 19:17
 */
public class RomanToInt {

    public static void main(String[] args) {
        //        输入: s = "MCMXCIV"
        //        输出: 1994
        //        解释: M = 1000, CM = 900, XC = 90, IV = 4.
        System.out.println(roman4("MCMXCIV"));
    }

    private static int roman3(String roman) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};
        int pre = map.get(roman.substring(roman.length() - 1));
        int result = pre;
        int minus = 0;
        for (int i = roman.length() - 2; i >= 0; i--) {
            int idx = map.get(roman.substring(i, i + 1));
            if (idx < pre && minus < 1) {
                result -= idx;
                minus++;
            } else {
                result += idx;
                minus = 0;
            }
            pre = idx;
        }
        return result;
    }

    private static int roman2(String roman) {
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        byte[] refer = "IVXLCDM".getBytes();
        int size = roman.length();
        byte[] bytes = roman.getBytes();
        int pre = values[getIdx(refer, bytes[size - 1])];
        int result = pre;
        int minus = 0;
        for (int i = size - 2; i >= 0; i--) {
            int idx = values[getIdx(refer, bytes[i])];
            if (idx < pre && minus < 1) {
                result -= idx;
                minus++;
            } else {
                result += idx;
                minus = 0;
            }
            pre = idx;
        }
        return result;
    }

    private static int getIdx(byte[] bytes, byte value) {
        for (int i = 0; i < bytes.length; i++) {
            if (value == bytes[i]) {
                return i;
            }
        }
        return 0;
    }

    private static int roman4(String roman) {
        String refer = "IVXLCDM";
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        int size = roman.length();
        int pre = 0;
        int result = 0;
        int minus = 0;
        int idx;
        for (int i = size - 1; i >= 0; i--) {
            idx = values[refer.indexOf(roman.substring(i, i + 1))];
            if (idx < pre && minus < 1) {
                result -= idx;
                minus++;    
            } else {
                result += idx;
                minus = 0;
            }
            pre = idx;
        }
        return result;
    }

    private static int roman(String roman) {
        // I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        ArrayList<String> list = new ArrayList<>();
        list.add("I");
        list.add("V");
        list.add("X");
        list.add("L");
        list.add("C");
        list.add("D");
        list.add("M");
        int pre = list.indexOf(roman.substring(roman.length() - 1));
        int result = values[pre];
        int minus = 0;
        for (int i = roman.length() - 2; i >= 0; i--) {
            int idx = list.indexOf(roman.substring(i, i + 1));
            if (idx < pre && minus < 1) {
                result -= values[idx];
                minus++;
            } else {
                result += values[idx];
                minus = 0;
            }
            pre = idx;
        }
        return result;
    }
}
