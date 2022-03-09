package com.leetcode;

/**
 * @author kexinhan
 * @date 2022/3/8 10:49
 */
public class P5 {
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        int maxLength = 1;
        int i = 0, j = 0;
        for (int index = 0; index < chars.length; index++) {
            i = index;
            j = index;
            while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
                if (j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    l = i;
                    r = j;
                }
                i--;
                j++;
            }
            i = index;
            j = index + 1;
            while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
                if (j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    l = i;
                    r = j;
                }
                i--;
                j++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int index = l; index <= r; index++) {
            res.append(chars[index]);
        }
        return res.toString();
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int max = 1;
        int l = 0, r = 0;
        boolean[][] dp = new boolean[len][len];
        for (int index = 0; index < len; index++) {
            for (int i = 0; i < len - index; i ++) {
                int j = index + i;
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    dp[i][j] = (chars[i] == chars[j]);
                } else {
                    dp[i][j] = (chars[i] == chars[j] && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && (j - i + 1) > max) {
                    max = j - i + 1;
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        P5 p5 = new P5();
        p5.longestPalindrome2("babad");
    }
}
