package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kexinhan
 * @date 2022/3/10 11:32
 */
public class P17 {
    private List<String> res;
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        char[] chars = digits.toCharArray();
        helper(chars, 0, new StringBuilder());
        return res;
    }

    private void helper(char[] chars, int index, StringBuilder sb) {
        if (index == chars.length) {
            res.add(sb.toString());
            return;
        }
        int num = chars[index] - '0';
        char[] btn = map[num].toCharArray();
        for (char c: btn) {
            sb.append(c);
            helper(chars, index + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
