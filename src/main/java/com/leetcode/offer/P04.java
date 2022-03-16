package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/16 15:04
 */
public class P04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0) {
            int num = matrix[i][j];
            if(target == num) {
                return true;
            }
            else if (target > num) {
                i ++;
            }
            else {
                j --;
            }
        }
        return false;
    }
}
