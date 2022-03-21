package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/17 10:13
 */
public class P14A {
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j ++) {
                max = Math.max(max, j * Math.max(i - j, dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
