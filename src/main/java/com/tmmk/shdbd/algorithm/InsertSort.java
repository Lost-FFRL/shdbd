package com.tmmk.shdbd.algorithm;

import java.util.Arrays;

/**
 * 插入排序算法 <br/>
 * 参考文章: 漫画：什么是插入排序(https://mp.weixin.qq.com/s/McqFXkXucSZldjU46t5cdw) <br/>
 * 时间复杂度：插入排序要进行n-1轮，每一轮在最坏情况下的比较复制次数分别是1次，2，3，4...一直到n-1次，
 *              所以最坏的时间复杂度是0(n^2)<br/>
 * 空间复杂度：没有引入新的数据结构，空间复杂度0(1) <br/>
 * @author Lost
 * @date 2019-08-15 22:02
 * @see
 */
public class InsertSort {

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 13, 45, 77, 88, 99, 66};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        sortDesc(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Integer[] param) {
        // 1、假设把数组的左侧作为有序区，右侧为无序区
        // 2、元素依次与左侧的有序区比较
        // 3、有序区依次往右扩充
        Integer orderIdx = 0;
        Integer startIdx = orderIdx;
        Integer endIdx = startIdx + 1;
        while (startIdx < param.length) {
            if (endIdx > param.length - 1) {
                break;
            }
            while (startIdx >= 0) {
                // 元素依次与有序区元素对比
                if (param[startIdx] > param[endIdx]) {
                    changeVal(param, startIdx, endIdx);
                }
                startIdx--;
                endIdx--;
            }
            // 有序区往右扩充
            orderIdx++;
            startIdx = orderIdx;
            endIdx = startIdx + 1;
        }
    }

    public static void changeVal(Integer[] values, Integer idx1, Integer idx2) {
        // 位置1与位置2的值互换
        Integer temp = values[idx2];
        values[idx2] = values[idx1];
        values[idx1] = temp;
    }

    public static void sortDesc(Integer[] param) {
        // 优化排序方式。
        // sort 采用的是依次比较，然后互换值
        // sortDesc 采用 缓存比较值，移动需要更改值
        // 不过两者都是采用双循环
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 45, 66, 77, 88, 99]
        for (int i = 1; i < param.length; i++) {
            int temp = param[i];
            int j = i - 1;
            for (; j >= 0 && param[j] < temp; j--) {
                param[j + 1] = param[j];
            }
            param[j + 1] = temp;
        }


    }
}
