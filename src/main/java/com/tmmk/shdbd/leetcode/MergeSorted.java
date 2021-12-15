package com.tmmk.shdbd.leetcode;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *  
 * <p>
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2021-12-08 19:12
 */
public class MergeSorted {

    public static void main(String[] args) {

        int[] array = new int[] {1, 3, 5, 0};
        new MergeSorted().merge4(array, 3, new int[] {4}, 1);
        System.out.println(Arrays.toString(array));
        array = new int[] {1};
        new MergeSorted().merge4(array, 1, new int[] {}, 0);
        System.out.println(Arrays.toString(array));
        array = new int[] {0};
        new MergeSorted().merge4(array, 0, new int[] {1}, 1);
        System.out.println(Arrays.toString(array));
    }

    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (m < 0 || n < 0) {
                nums1[m < 0 ? n : m] = m < 0 ? nums2[n--] : nums1[m--];
                continue;
            }
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m--];
            } else {
                nums1[m + n + 1] = nums2[n--];
            }
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int idx = n + m + 1; idx >= 0; idx--) {
            if (m < 0 || n < 0) {
                if (m < 0) {
                    nums1[idx] = nums2[n--];
                } else {
                    nums1[idx] = nums1[m--];
                }
                continue;
            }
            if (nums1[m] > nums2[n]) {
                nums1[idx] = nums1[m--];
            } else {
                nums1[idx] = nums2[n--];
            }
        }
    }

    public void mergeT(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int idx = n + m + 1; idx >= 0; idx--) {
            if (m < 0 || n < 0) {
                if (m < 0) {
                    nums1[idx] = nums2[n--];
                } else {
                    nums1[idx] = nums1[m--];
                }
                continue;
            }
            if (nums1[m] > nums2[n]) {
                nums1[idx] = nums1[m--];
            } else {
                nums1[idx] = nums2[n--];
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //        for (int i = 0, j = i; i < n + m; i++) {
        //            if (nums1[m - 1] < nums2[0]) {
        //                i = i == 0 ? m : i;
        //                nums1[i] = nums2[i - m];
        //            } else {
        //
        //            }
        //        }
        int[] result = new int[m + n];
        for (int idx = 0, i = idx, j = idx; idx < m + n; idx++) {
            if (i == m || j == n) {
                if (i == m) {
                    result[idx] = nums2[j++];
                } else {
                    result[idx] = nums1[i++];
                }
                continue;
            }
            if (nums1[i] < nums2[j]) {
                result[idx] = nums1[i++];
            } else {
                result[idx] = nums2[j++];
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 通过，成立，内存有消耗
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void test() {
        int[] a = new int[] {10, 2, 1, 6, 3, 9, 6, 5};
        for (int i = 0, j = i; i < a.length - 1; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == 0) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
        System.out.println(Arrays.toString(a));
    }
}
