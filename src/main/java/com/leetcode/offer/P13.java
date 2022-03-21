package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/17 9:58
 */
public class P13 {
    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0 || k < 0) {
            return 0;
        }
        boolean[][] aux = new boolean[m][n];
        return dfs(aux, 0, 0, k);
    }
    private int dfs(boolean[][] aux, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= aux.length || j >= aux[0].length || aux[i][j]) {
            return 0;
        }
        if (sum(i, j) <= k) {
            aux[i][j] = true;
            return 1 + dfs(aux, i + 1, j, k) + dfs(aux, i, j + 1, k);
        }
        return 0;
    }

    private int sum(int m, int n) {
        int res = 0;
        while(m != 0) {
            res += (m % 10);
            m /= 10;
        }
        while(n != 0) {
            res += (n % 10);
            n /= 10;
        }
        return res;
    }
}
