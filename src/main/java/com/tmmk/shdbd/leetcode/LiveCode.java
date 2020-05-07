package com.tmmk.shdbd.leetcode;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * @author zhangpeijun
 * @date 2020/4/16
 */
public class LiveCode {

    public static void main(String[] args) {
        int[][] board = new int[4][3];
        board[0][0] = 0;
        board[0][1] = 1;
        board[0][2] = 0;
        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 1;
        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;
        board[3][0] = 0;
        board[3][1] = 0;
        board[3][2] = 0;
        out(board);
        gameOfLife(board);
        out(board);
        System.out.println();
        System.out.println("[0,0,0,],[1,0,1,],[0,1,1,],[0,1,0]");

    }

    public static void out(int[][] record){
        for (int[] x : record) {
            System.out.print("[");
            for (int i : x) {
                System.out.print(i +",");
            }
            System.out.print("],");
        }
        System.out.println();
    }

    public static void gameOfLife(int[][] board) {
        if (null == board) {
            return;
        }
        int xLen = board.length;
        int yLen = 0, tmp = 0, num = 0;
        int[][] result = copy(board);
        for (int i = 0; i < xLen; i++) {
            yLen = board[i].length;
            for (int j = 0; j < yLen; j++) {
                num = liveNum(i, j, xLen, yLen, result);
                if (0 == board[i][j]) {
                    board[i][j] = num == 3 ? 1 : 0;
                } else {
                    board[i][j] = num == 2 || num == 3 ? 1 : 0;
                }
            }
        }
    }


    public static int[][] copy(int[][] record) {
        int[][] result = new int[record.length][];
        for (int i = 0; i < record.length; i++) {
            result[i] = new int[record[i].length];
            for (int j = 0; j < record[i].length; j++) {
                result[i][j] = record[i][j];
            }
        }
        return result;
    }

    public static int liveNum(int x, int y, int xSize, int ySize, int[][] record) {
        int num = 0;
        int idx1 = 0, idx2 = 0,size = 2;
        for (int i = -1; i < size; i++) {
            idx1 = x + i;
            if (idx1 < 0 || idx1 >= xSize) {
                continue;
            }
            for (int j = -1; j < size; j++) {
                idx2 = y + j;
                if (idx2 < 0 || idx2 >= ySize) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                num += record[idx1][idx2];
            }
        }
        return num;
    }
}
