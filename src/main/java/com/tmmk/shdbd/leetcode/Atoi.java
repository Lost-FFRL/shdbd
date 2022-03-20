package com.tmmk.shdbd.leetcode;

/**
 * TODO <功能详细描述>
 *
 * @author Lost
 * @version 1.0.0
 * @date 2022-3-20 14:30
 */
public class Atoi {

    char[] chars = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        System.out.println(new Atoi().myAtoi1("000042"));
    }

    public int myAtoi1(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Long result = 0L;
        boolean flag = true;
        int mul = 1;
        char val;
        for (int i = 0; i < s.length(); i++) {
            val = s.charAt(i);
            if (flag && (' ' == val)) {
                continue;
            } else if (flag && ('-' == val || '+' == val)) {
                flag = false;
                mul = '-' == val ? -1 : 1;
                continue;
            }
            if ('0' > val || val > '9') {
                break;
            }
            flag = false;
            result = result > 0 ? result * mul : result;
            result = result * 10 + Integer.parseInt(String.valueOf(val)) * mul;
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return result.intValue();
    }

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String result = "";
        char f = '+';
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && ('-' == s.charAt(i) || '+' == s.charAt(i))) {
                f = s.charAt(i);
                continue;
            }
            if (!find(s.charAt(i))) {
                break;
            }
            if (result.length() > 11) {
                break;
            }
            if ("0".equals(result)) {
                result = "";
            }
            result += s.charAt(i);
        }
        if ("".equals(result)) {
            return 0;
        }
        Long l = Long.valueOf(f + result);
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return l.intValue();
        }
    }

    public boolean find(char c) {
        for (char aChar : chars) {
            if (c == aChar) {
                return true;
            }
        }
        return false;
    }
}
