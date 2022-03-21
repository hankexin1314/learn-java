package com.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kexinhan
 * @date 2022/3/17 10:55
 */
public class P17 {
    List<String> tmp = new ArrayList<>();
    char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }
        dfs(new StringBuilder(), n);
        int[] res = new int[tmp.size() - 1];
        int index = 0;
        for (String s: tmp) {
            int num = helper(s);
            if (num != -1) {
                res[index] = num;
                index ++;
            }
        }
        return res;
    }
    // n表示该固定第几位了，从左到右
    private void dfs(StringBuilder cur, int n) {
        if(n == 0) {
            tmp.add(cur.toString());
            return;
        }
        for (char c: num) {
            cur.append(c);
            dfs(cur, n - 1);
            cur.setLength(cur.length() - 1);
        }
    }

    private int helper(String s) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                start = i + 1;
            }
            else {
                break;
            }
        }
        s = s.substring(start);
        if (s.length() == 0) {
            return -1;
        }
        else {
            return Integer.parseInt(s);
        }
    }

    public static void main(String[] args) {
        P17 p17 = new P17();
        p17.printNumbers(1);
    }
}
