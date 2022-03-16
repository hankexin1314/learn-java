package com.leetcode.jianzhioffer;

import java.util.Arrays;

public class P3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] pre = new int[256];
        Arrays.fill(pre, -1);
        int max = 0;
        int l = 0, r = 0;
        while (r < chars.length) {
            char c = chars[r];
            if (pre[c] < l) {
                max = Math.max(max, r - l + 1);
            }
            else {
                l = pre[c] + 1;
            }
            pre[c] = r;
            r ++;
        }
        return max;
    }
}
