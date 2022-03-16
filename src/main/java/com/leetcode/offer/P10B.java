package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/16 15:46
 */
public class P10B {
    public int numWays(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i ++) {
            int tmp = a;
            a = b;
            b = (tmp + b) % 1000000007;
        }
        return b;
    }
}
