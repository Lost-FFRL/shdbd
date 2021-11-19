package com.tmmk.shdbd.math;

/**
 * 03 | 迭代法：不用编程语言的自带函数，你会如何计算平方根？
 *
 * 什么是逖代法?
 * 迭代法,其实就是不断地用旧的变量值,递推计算新的变量值。
 * 迭代法的思想很容易通过计算机语言中的循环语言来实现。
 * 我们可以通过循环语句,让计算机重复执行迭代中的递推步骤,推导出变量的最终值。
 *
 * 2,说代法的基本步懼是什么?
 * 确定用于送代的变量
 * 建立进代变量之间的进推关系。
 * 控制选代的过程。
 *
 * 3说代法有什么具体应用?
 * 求政值的精确或者近似解。
 * 在一定范国内查找目标值。
 * 机器学习算法中的送代.
 *
 * @author Lost
 * @version 4.14.0
 * @date 2021-08-03 21:36
 */
public class lesson3 {

    /*
     * 迭代法（Iterative Method
     */

    // 经典应用场景： 定位数据表的，分表设计

    /**
     * @Description: 算算舍罕王给了多少粒麦子
     * * @param grid-放到第几格
     * * @return long-麦粒的总数
     */
    public static long getNumberOfWheat(int grid) {
        long sum = 0;      // 麦粒总数
        long numberOfWheatInGrid = 0;
        // 当前格子里麦粒的数量
        numberOfWheatInGrid = 1;
        // 第一个格子里麦粒的数量
        sum += numberOfWheatInGrid;
        for (int i = 2; i <= grid; i++) {
            numberOfWheatInGrid *= 2;   // 当前格子里麦粒的数量是前一格的2倍
            sum += numberOfWheatInGrid;   // 累计麦粒总数
        }
        return sum;
    }

    /**
     * 计算大于 1 的正整数之平方根
     *
     * @param n-待求的数
     * @param deltaThreshold-误差的阈值
     * @param maxTry-二分查找的最大次数
     * @return double-平方根的解
     */
    public static double getSquareRoot(int n, double deltaThreshold, int maxTry) {
        // 负数没有平方根，0的平方根是0
        if (n <= 1) {
            return -1.0;
        }
        // 设定了 计算大于 1 的正整数
        double min = 1.0, max = (double) n;
        for (int i = 0; i < maxTry; i++) {
            double middle = (min + max) / 2;
            double square = middle * middle;
            // 误差阀值的设定，是小于 1 的
            double delta = Math.abs((square / n) - 1);
            if (delta <= deltaThreshold) {
                return middle;
            } else {
                if (square > n) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }

        return -2.0;
    }
}