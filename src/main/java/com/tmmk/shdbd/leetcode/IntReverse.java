package com.tmmk.shdbd.leetcode;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntReverse {

    public static void main(String[] args) {
        System.out.println(new IntReverse().reverse3(0));
        System.out.println(new IntReverse().reverse3(124));
        System.out.println(new IntReverse().reverse3(-103));
        System.out.println(new IntReverse().reverse3(-2147483648));

    }

    public int reverse(Integer x) {
        String val = x.toString();
        StringBuffer sb = new StringBuffer();
        for (int i = val.length() - 1; i >= 0; i--) {
            sb.append(val.charAt(i));
        }
        return Integer.valueOf(sb.toString());
    }

    public int reverse2(int x) {
        if (x == 0) {
            return 0;
        }
        Long val = x > 0 ? x : x * -1L;
        val = Long.valueOf(new StringBuffer(val.toString()).reverse().toString());
        val = x > 0 ? val : val * -1;
        return val > Integer.MAX_VALUE || val < Integer.MIN_VALUE ? 0 : val.intValue();
    }

    public int reverse3(int x) {
        if (x >= -10 && x < 10) {
            return x;
        }
        Long val = x * (x > 0 ? 1L : -1L);
        Long result = 0L;
        while (val >= 10) {
            result = result * 10 + val % 10;
            val = val / 10;
        }
        result = result * 10 + val;
        result = x > 0 ? result : result * -1;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : result.intValue();
    }

    public int reverse1(int x) {
        if (x == 0) {
            return 0;
        }
        Long val = Long.valueOf(new StringBuffer(Integer.valueOf(x).toString().replace("-", "")).reverse().toString());
        val = x > 0 ? val : val * -1;
        return val > Integer.MAX_VALUE || val < Integer.MIN_VALUE ? 0 : val.intValue();
    }

}
