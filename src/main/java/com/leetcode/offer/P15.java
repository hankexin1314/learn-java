package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/17 10:42
 */
public class P15 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n = (n >>> 1);
        }
        return res;
    }
}
