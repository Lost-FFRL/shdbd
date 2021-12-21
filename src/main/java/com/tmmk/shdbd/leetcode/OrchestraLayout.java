package com.tmmk.shdbd.leetcode;

import com.sun.org.apache.xalan.internal.xsltc.dom.StepIterator;

/**
 * 某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
 * <p>
 * 为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
 * <p>
 * image.png
 * <p>
 * 请返回位于场地坐标 [Xpos,Ypos] 的成员所持乐器编号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 3, Xpos = 0, Ypos = 2
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * image.png
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = 4, Xpos = 1, Ypos = 2
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * image.png
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 10^9
 * 0 <= Xpos, Ypos < num
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/SNJvJP
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2021-12-21 20:07
 */
public class OrchestraLayout {

    public static void main(String[] args) {
        //        System.out.println(orchestraLayout(5, 0, 0));
        //        System.out.println(orchestraLayout(5, 0, 1));
        //        System.out.println(orchestraLayout(5, 0, 2));

        System.out.println(orchestraLayout(449572, 209397, 306801));

        //        System.out.println(orchestraLayout(4, 2, 2));
    }

    public static int orchestraLayout(long num, long xPos, long yPos) {
        System.out.println("************");
        // 求 xPos 与 yPos所在圈层的起点坐标。
        long start = Math.min(Math.min(xPos, num - xPos - 1), Math.min(yPos, num - yPos - 1));
        long length = num - start * 2;
        // 计算出起点坐标的值
        long startVal = (num * num - length * length) % 9 + 1;
        System.out.println("start= " + start);
        System.out.println("val= " + startVal);
        System.out.println("length= " + length);
        Long result;
        // 针对数据所在圈层进行计算，分为四个部分：上下左右
        if (length == 1) {
            result = startVal;
        } else if (xPos == start) {
            // 上- 增量：y坐标 - start
            result = (startVal + (yPos - start)) % 9;
        } else if (yPos == (num - start - 1)) {
            // 右-增量：上 + x坐标 - start
            result = (startVal + length - 1 + xPos - start) % 9;
        } else if (xPos == (num - start - 1)) {
            // 下-增量：上 + 右 + y坐标-start
            result = (startVal + length * 2 - 2 + (length - 1 + start - yPos)) % 9;
        } else {
            // 左-
            result = (startVal + length * 3 - 3 + (length - 1 + start - xPos)) % 9;
        }
        if (result == 0) {
            return 9;
        } else {
            return result.intValue();
        }
    }
}
