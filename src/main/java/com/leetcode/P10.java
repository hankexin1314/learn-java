package com.leetcode;

/**
 * @author kexinhan
 * @date 2022/3/8 14:23
 */
public class P10 {
    private char[] charS;
    private char[] charP;

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        charS = s.toCharArray();
        charP = p.toCharArray();
        return helper(charS.length - 1, charP.length - 1, '#');
    }

    // pre 表示上一个字符
    private boolean helper(int sIndex, int pIndex, char pre) {
        if (sIndex < 0 && pIndex < 0) {
            return true;
        }
        if (pIndex < 0) {
            return false;
        }
        if (sIndex >= 0) {
            if (pre == '*') {
                if (charS[sIndex] == charP[pIndex] || charP[pIndex] == '.') {
                    return helper(sIndex, pIndex - 1, charP[pIndex]) || helper(sIndex - 1, pIndex, '*');
                } else {
                    return helper(sIndex, pIndex - 1, charP[pIndex]);
                }
            } else {
                if (charS[sIndex] == charP[pIndex] || charP[pIndex] == '.') {
                    return helper(sIndex - 1, pIndex - 1, charP[pIndex]);
                } else if (charP[pIndex] == '*') {
                    return helper(sIndex, pIndex - 1, charP[pIndex]);
                } else {
                    return false;
                }
            }
        } else {
            if (charP[pIndex] == '*') {
                return helper(sIndex, pIndex - 1, charP[pIndex]);
            }
            if (pre != '*') {
                return false;
            } else {
                return helper(sIndex, pIndex - 1, charP[pIndex]);
            }
        }
    }

    public static void main(String[] args) {
        P10 p10 = new P10();
        System.out.println(p10.isMatch("ab", ".*"));
    }
}
