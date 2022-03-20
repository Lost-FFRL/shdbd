package com.tmmk.shdbd.leetcode;

/**
 * Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2022-2-22 17:05
 */
public class ZConvert {

    public static void main(String[] args) {
        ZConvert z = new ZConvert();
        System.out.println(z.convert("ab", 1));
        System.out.println(z.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
    }

    public String convert(String s, int numRows) {
        /// 硬解方法
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder[] strArr = new StringBuilder[numRows];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = new StringBuilder();
        }
        int idx = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            strArr[idx].append(s.charAt(i));
            // 按官方的简化：
            if (idx == 0 || idx == numRows - 1) {
                flag = !flag;
            }
            idx += flag ? 1 : -1;
            //            if (flag) {
            //                if (idx == numRows - 1) {
            //                    flag = false;
            //                    idx--;
            //                } else {
            //                    idx++;
            //                }
            //            } else {
            //                if (idx == 0) {
            //                    flag = true;
            //                    idx++;
            //                } else {
            //                    idx--;
            //                }
            //            }
        }
        for (StringBuilder t : strArr) {
            result.append(t.toString());
        }
        return result.toString();
    }
}