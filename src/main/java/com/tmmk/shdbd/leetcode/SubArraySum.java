package com.tmmk.shdbd.leetcode;

import javax.sound.midi.Soundbank;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * @author Lost
 * @date 2020-05-19 10:36
 * @see
 * @since 2.0.0
 */
public class SubArraySum {

    public static void main(String[] args) {
        // 连续计算也属于
        int[] nums = {217,-315,-999,-537,116,46,971,31,-978,-796,-613,80,-668,952,505,306,-405,884,435,-795,89,539,170,-963,360,-27,699,951,440,-163,-996,820,-548,40};
        int k = -94;
        int tmp = 0;
        int num = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            tmp = 0;
            for (int j = i; j < size; j++) {
                tmp += nums[j];
                if (tmp == k) {
                    num++;
                }
            }
        }
        System.out.println(num);
    }

}
