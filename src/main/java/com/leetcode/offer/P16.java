package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/17 10:47
 */
public class P16 {
    public double myPow(double x, int n) {
        double res = 1.0;
        int tmp = Math.abs(n);
        while (tmp != 0) {
            if ((tmp & 1) == 1) {
                res *= x;
            }
            x *= x;
            tmp = (tmp >>> 1);
        }
        return n > 0 ? res : 1 / res;
    }
}
