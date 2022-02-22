package com.tmmk.shdbd.leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * 通过次数594,701提交次数1,446,965
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2022-1-24 19:06
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(find1(new int[] {1, 2}, new int[] {2}));
        System.out.println(find1(new int[] {1, 2}, new int[] {3, 4}));
        System.out.println(find1(new int[] {0, 0}, new int[] {0, 0}));
        System.out.println(find1(new int[] {}, new int[] {1}));
        System.out.println(find1(new int[] {2}, new int[] {}));
    }

    public static double find1(int[] nums1, int[] nums2) {
        // 数组从第 0 位开始计算
        int avg = (nums1.length + nums2.length) / 2;
        boolean odd = (nums1.length + nums2.length) % 2 != 0;
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        } else if (nums1.length == 0) {
            return odd ? nums2[avg] : (nums2[avg] + nums2[avg - 1] + 0.0) / 2;
        } else if (nums2.length == 0) {
            return odd ? nums1[avg] : (nums1[avg] + nums1[avg - 1] + 0.0) / 2;
        }
        double pre = 0, next = 0;
        int idx = 0, idx1 = 0,idx2 = 0;
        avg = avg + 1;
        while (idx < avg) {
            if (idx1 == nums1.length || idx2 == nums2.length) {
                if (idx1 == nums1.length) {
                    pre = next;
                    next = nums2[idx2];
                    idx2++;
                } else {
                    pre = next;
                    next = nums1[idx1];
                    idx1++;
                }
            } else {
                if (nums1[idx1] > nums2[idx2]) {
                    pre = next;
                    next = nums2[idx2];
                    idx2++;
                } else if (nums1[idx1] < nums2[idx2]) {
                    pre = next;
                    next = nums1[idx1];
                    idx1++;
                } else {
                    pre = next;
                    next = nums1[idx1];
                    idx++;
                    if (idx == avg) {
                        break;
                    }
                    pre = next;
                    next = nums2[idx2];
                    // 相等时为了方便计算：随意取一个
                    idx1++;
                    idx2++;
                }
            }
            idx++;
        }
        return odd ? next : (next + pre + 0.0) / 2;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 数组从第 0 位开始计算，此处不需要 +1
        int avg = (nums1.length + nums2.length) / 2;
        boolean odd = (nums1.length + nums2.length) % 2 != 0;
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        } else if (nums1.length == 0) {
            return odd ? nums2[avg] : (nums2[avg] + nums2[avg - 1] + 0.0) / 2;
        } else if (nums2.length == 0) {
            return odd ? nums1[avg] : (nums1[avg] + nums1[avg - 1] + 0.0) / 2;
        }
        double result = 0;
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx < avg) {
            if (idx1 >= nums1.length) {
                //                break;
                int i = avg - idx + idx2;
                return odd ? nums2[i] : (nums2[i] + nums2[i - 1] + 0.0) / 2;
            } else if (idx2 >= nums2.length) {
                int i = avg - idx + idx1;
                return odd ? nums1[i] : (nums1[i] + nums1[i - 1] + 0.0) / 2;
            } else {
                if (nums1[idx1] > nums2[idx2]) {
                    result = nums2[idx2];
                    idx2++;
                } else if (nums1[idx1] < nums2[idx2]) {
                    result = nums1[idx1];
                    idx1++;
                } else {
                    idx++;
                    result = nums1[idx1];
                    if (idx == avg) {
                        return odd ? Math.min(nums1[idx1], nums2[idx2]) : (nums1[idx1] + nums2[idx2] + 0.0) / 2;
                    }
                    // 相等时为了方便计算：随意取一个
                    idx1++;
                    idx2++;
                }
                idx++;
            }
        }
        return result;
    }
}
