package a1226;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * <a href="https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_Exist {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (process(board, i, j, 0, chars)) return true;
            }
        }
        return false;
    }

    private boolean process(char[][] board, int i, int j, int cur, char[] toCharArray) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != toCharArray[cur]) {
            return false;
        }
        if (board[i][j] == '1') {
            return false;
        }
        if (cur == toCharArray.length - 1) {
            return true;
        }


        board[i][j] = '1';
        boolean b = process(board, i + 1, j, cur + 1, toCharArray)
                || process(board, i - 1, j, cur + 1, toCharArray)
                || process(board, i, j + 1, cur + 1, toCharArray)
                || process(board, i, j - 1, cur + 1, toCharArray);
        board[i][j] = toCharArray[cur];
        return b;

    }
}
