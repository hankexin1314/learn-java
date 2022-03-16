package com.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kexinhan
 * @date 2022/3/16 15:35
 */
public class P09 {
    private LinkedList<Integer> s1;
    private LinkedList<Integer> s2;

    public P09() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        s2.addLast(value);
    }

    public int deleteHead() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.addLast(s2.removeLast());
            }
        }
        if (s1.isEmpty()) {
            return -1;
        } else {
            return s1.removeLast();
        }
    }
}
