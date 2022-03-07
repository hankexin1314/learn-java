package com.leetcode;

import java.util.Arrays;

/**
 * @author kexinhan
 * @date 2022/3/7 10:32
 */
public class P3 {
    /**
     * 错误做法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] pre = new int[256];
        Arrays.fill(pre, -1);
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (pre[c] != -1) {
                res = Math.max(res, i - pre[c]);
            }
            pre[c] = i;
        }
        return res;
    }

    /**
     * 错误做法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] pre = new int[256];
        Arrays.fill(pre, -1);
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            res = Math.max(res, i - pre[c]);
            pre[c] = i;
        }
        return res;
    }

    /**
     * 错误
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] pre = new int[256];
        Arrays.fill(pre, -1);
        char[] chars = s.toCharArray();
        int res = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (pre[c] >= left) {
                res = Math.max(res, i - left);
                left = i;
            }
            pre[c] = i;
        }
        res = Math.max(res, chars.length - left);
        return res;
    }

    /**
     * 清晰的定义滑动窗口左右边界的含义
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] pre = new int[256];
        Arrays.fill(pre, -1);
        char[] chars = s.toCharArray();
        // [l, r]，左右都闭合，为不重复序列
        int l = 0, r = 0;
        int res = 0;
        while (r < chars.length) {
            char c = chars[r];
            if (pre[c] != -1) {
                l = Math.max(l, pre[c] + 1);
            }
            pre[c] = r;
            res = Math.max(res, r - l + 1);
            r ++;
        }
        return res;
    }

    public static void main(String[] args) {
        P3 p = new P3();
        p.lengthOfLongestSubstring2("pwwkew");
    }
}
