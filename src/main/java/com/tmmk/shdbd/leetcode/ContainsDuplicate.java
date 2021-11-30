package com.tmmk.shdbd.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2021-11-18 18:07
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};

        System.out.println(containsDuplicate(nums));
    }

public static boolean containsDuplicate(int[] nums) {
    if (null != nums && nums.length > 1) {
        int temp;
        int size = nums.length;
        // 采用与前一位比较方式，循环从第二位开始
        for (int i = 1; i < size; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            } else if (nums[i] < nums[i - 1]) {
                // 排序，循环判断：
                // 排序后的数组,示例: 1,2,3...
                temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
                for (int j = i - 1; j > 0; j--) {
                    if (nums[j] == nums[j - 1]) {
                        return true;
                    } else if (nums[j] < nums[j - 1]) {
                        temp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    return false;
}
}
