package com.tmmk.shdbd.math;

import java.math.BigInteger;
import java.util.Map;

/**
 * TODO <功能详细描述>
 *
 * @author Lost
 * @date 2020-03-06 9:53
 * @see
 * @since 2.7.0
 */
public class Lesson1 {
    /**
     * @param decimalSource
     * @return String
     * @Description: 十进制转换成二进制
     */
    public static String decimalToBinary(int decimalSource) {
        //转换成BigInteger类型，默认是十进制
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        //参数2指定的是转化成二进制
        return bi.toString(2);
    }

    /**
     * @param binarySource
     * @return int
     * @Description: 二进制转换成十进制
     */
    public static int binaryToDecimal(String binarySource) {
        //转换为BigInteger类型，参数2指定的是二进制
        BigInteger bi = new BigInteger(binarySource, 2);
        //默认转换成十进制
        return Integer.parseInt(bi.toString());
    }

    /**
     * @param num-等待移位的十进制数, m-向左移的位数
     * @return int-移位后的十进制数
     * @Description: 向左移位
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * @param num-等待移位的十进制数, m-向右移的位数
     * @return int-移位后的十进制数
     * @Description: 向右移位
     */
    public static int rightShift(int num, int m) {
        // 右移，涉及符号位问题。
        // 根本原因是 Java 的二进制数值中最高一位是符号位
        // 当符号位为 0 时，表示该数值为正数；当符号位为 1 时，表示该数值为负数
        // 逻辑右移(>>>):逻辑右移 1 位，左边补 0 即可。
        // 而算术右移(>>): 算术右移时保持符号位不变，除符号位之外的右移一位并补符号位 1。补的 1 仍然在符号位之后。
        return num >>> m;
    }


    /**
     * @param num1-第一个数字，num2-第二个数字
     * @return 二进制按位“或”的结果
     * @Description: 二进制按位“或”的操作
     */
    public static int or(int num1, int num2) {

        return (num1 | num2);

    }

    /**
     * @param num1-第一个数字，num2-第二个数字
     * @return 二进制按位“与”的结果
     * @Description: 二进制按位“与”的操作
     */
    public static int and(int num1, int num2) {

        return (num1 & num2);

    }

    /**
     * @param num1-第一个数字，num2-第二个数字
     * @return 二进制按位“异或”的结果
     * @Description: 二进制按位“异或”的操作
     */

    public static int xor(int num1, int num2) {

        return (num1 ^ num2);

    }

    public static String decimalToBinary1(int decimalSource) {
        StringBuilder sb = new StringBuilder();
        if (decimalSource > 0) {
            int tmp = decimalSource;
            while (tmp != 0) {
                // 求余是一种方式
                // sb.append(tmp % 2);
                // 同1“与”也可以
                sb.append(tmp & 1);
                tmp = tmp >> 1;
            }
        } else if (decimalSource < 0 ){
            // 1.补充符号显示，示例：-111
            // 2.补全32位显示，示例：111111***00111
        }
        else {
            sb.append("0");
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(53));
        System.out.println(decimalToBinary1(53));

    }
}
