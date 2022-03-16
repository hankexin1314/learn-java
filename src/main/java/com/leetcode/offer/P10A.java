package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/16 15:42
 */
public class P10A {
    public int fib(int n) {
        int a = 1, b = 0;
        for (int i = 0; i < n; i ++) {
            int tmp = a;
            a = b;
            b = (tmp + b) % 1000000007;
        }
        return b;
    }
}
