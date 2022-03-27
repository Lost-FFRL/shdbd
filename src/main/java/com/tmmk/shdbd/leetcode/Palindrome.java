package com.tmmk.shdbd.leetcode;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 *  
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2022-3-27 16:12
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        if( 0 == x % 10){
            return false;
        }
        Integer pal = 0;
        int val = x;
        while (val >= 10) {
            pal = pal * 10 + val % 10;
            val = val / 10;
        }
        pal = pal * 10 + val;
        System.out.println(pal);
        return pal.equals(x);
    }

    public static boolean isPalindrome1(int x) {
        String p = String.valueOf(x);
        int size = p.length() / 2;
        int mod = p.length() % 2 + size;
        for (int i = 0; i < size; i++) {
            if (p.charAt(i) != p.charAt(p.length() - 1 - i)
                || p.charAt(size - 1 - i) != p.charAt(mod + i)) {
                return false;
            }
        }
        return true;
    }
}
