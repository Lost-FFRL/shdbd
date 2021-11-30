package com.tmmk.shdbd.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * <p>
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * <p>
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * <p>
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 * 示例 2：
 * <p>
 * 输入：code = [1,2,3,4], k = 0
 * 输出：[0,0,0,0]
 * 解释：当 k 为 0 时，所有数字都被 0 替换。
 * 示例 3：
 * <p>
 * 输入：code = [2,4,9,3], k = -2
 * 输出：[12,5,6,13]
 * 解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 *  
 * <p>
 * 提示：
 * <p>
 * n == code.length
 * 1 <= n <= 100
 * 1 <= code[i] <= 100
 * -(n - 1) <= k <= n - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/defuse-the-bomb
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2021-11-18 18:18
 */
public class DefuseTheBomb {

    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        //         * 输入：code = [5,7,1,4], k = 3
        //            * 输出：[12,10,16,13]
        //         * 输入：code = [2,4,9,3], k = -2
        //            * 输出：[12,5,6,13]
        // [10,5,7,7,3,2,10,3,6,9,1,6] -4
        // [22,26,22,28,29,22,19,22,18,21,28,19]
        //        System.out.println(Arrays.toString(d4(new int[] {5, 7, 1, 4}, 3)));
        System.out.println(Arrays.toString(d4(new int[] {10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6}, -4)));
        System.out.println(Arrays.toString(d4(new int[] {2, 4, 9, 3}, -2)));
    }

    public static int[] d4(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int length = code.length;
        int total = 0;
        int size = k > 0 ? k : k * -1;
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            total += k > 0 ? code[i + 1] : code[length - 1 - size + i];
            temp[i] = k > 0 ? code[i] : code[length - 1 - i];
        }
        for (int i = 0; i < length - 1; i++) {
            if (k > 0) {
                code[i] = total;
                total -= code[i + 1];
                total += (i + 1 + size < length ? code[i + 1 + size] : temp[i + 1 + size - length]);
            } else {
                code[length - 1 - i] = total;
                total -= (length - 1 - i - 1 >= 0 ? code[length - 1 - i - 1] : temp[(length - 1 - i - 1) * -1]);
                total += (0 <= length - 1 - i - size - 1 ? code[length - 1 - i - size - 1] :
                    temp[(length - 1 - i - size) * -1]);
            }
        }
        code[k > 0 ? length - 1 : 0] = total;
        return code;
    }

    public static int[] d3(int[] code, int k) {
        if (k == 0) {
            for (int i = 0; i < code.length; i++) {
                code[i] = 0;
            }
            return code;
        }
        int length = code.length;
        int[] result = new int[length];
        int total = 0;
        int size = k > 0 ? k : k * -1;
        for (int i = 0; i < size; i++) {
            total += k > 0 ? code[i + 1] : code[length - size + i];
        }
        for (int i = 0; i < length - 1; i++) {
            result[i] = total;
            if (k > 0) {
                total -= code[i + 1];
                total += code[i + 1 + size < length ? i + 1 + size : i + 1 + size - length];
            } else {
                total += code[i];
                total -= code[i <= size - 1 ? length - size + i : i - size];
            }
        }
        result[length - 1] = total;
        return result;
    }

    public static int[] d2(int[] code, int k) {
        if (k == 0) {
            for (int i = 0; i < code.length; i++) {
                code[i] = 0;
            }
            return code;
        }
        int idx, total = 0, length = code.length;
        int size = k > 0 ? k : k * -1;
        int[] tmp = new int[size];
        if (k > 0) {
            for (int i = 0; i < size; i++) {
                total += code[i + 1];
                tmp[i] = code[i];
            }
            for (int i = 0; i < length; i++) {
                code[i] = total;
                if (i <= length - 1) {
                    continue;
                }
                total -= code[i + 1];
                total += i + size < length ? code[i + size] : tmp[i + size - length];
            }
        }
        return code;
    }

    public static int[] decrypt(int[] code, int k) {
        if (k == 0) {
            for (int i = 0; i < code.length; i++) {
                code[i] = 0;
            }
            return code;
        }
        int idx, total = 0, length = code.length;
        int size = k > 0 ? k : k * -1;
        int[] tmp = new int[size];

        if (k > 0) {
            for (int i = 0; i < length; i++) {
                if (i < k) {
                    tmp[i] = code[i];
                }
                total = 0;
                for (int j = 1; j <= k; j++) {
                    if (i + j >= length) {
                        total += tmp[i + j - length];
                    } else {
                        total += code[i + j];
                    }
                    code[i] = total;
                }
            }
        } else {
            idx = 0;
            for (int i = length - 1; i >= 0; i--) {
                if (idx < size) {
                    tmp[idx] = code[i];
                    idx++;
                }
                total = 0;
                for (int j = 1; j <= size; j++) {
                    if (i - j < 0) {
                        total += tmp[-1 * (i - j + 1)];
                    } else {
                        total += code[i - j];
                    }
                }
                code[i] = total;
            }
        }
        return code;
    }

}
