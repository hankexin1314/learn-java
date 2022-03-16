package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/16 18:21
 */
public class P12 {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (dfs(board, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int i, int j, int index) {
        if (index >= chars.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == chars[index]) {
            char tmp = board[i][j];
            board[i][j] = '#';
            boolean res = dfs(board, chars, i + 1, j, index + 1) ||
                    dfs(board, chars, i - 1, j, index + 1) ||
                    dfs(board, chars, i, j + 1, index + 1) ||
                    dfs(board, chars, i, j - 1, index + 1);
            board[i][j] = tmp;
            return res;
        }
        return false;
    }
}
