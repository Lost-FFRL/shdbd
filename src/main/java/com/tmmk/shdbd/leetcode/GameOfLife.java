package com.tmmk.shdbd.leetcode;

import javax.sound.midi.Soundbank;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * <p>
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * 进阶：
 * <p>
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @date 2020-04-02 9:18
 * @see
 * @since 1.9.0
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        if (null == board) {
            return;
        }
        int xLen = board.length;
        int yLen = 0, num = 0;
        for (int i = 0; i < xLen; i++) {
            yLen = board[i].length;
            for (int j = 0; j < yLen; j++) {
                num = liveNum(i, j, xLen, yLen, board);
                if (0 == board[i][j]) {
                    // 0 -> 1 改为 3
                    board[i][j] = num == 3 ? 3 : 0;
                } else {
                    // 1 -> 0 改为 2
                    board[i][j] = num >= 2 && num <= 3 ? 1 : 2;
                }
            }
        }
        // 还原标记
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] % 2;
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
        int num = 0, idx1 = 0, idx2 = 0, size = 2;
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
                num += record[idx1][idx2] % 2;
            }
        }
        return num;
    }


}
