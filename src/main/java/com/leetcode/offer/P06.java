package com.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kexinhan
 * @date 2022/3/16 15:09
 */
public class P06 {
    List<Integer> arr;
    public int[] reversePrint(ListNode head) {
        arr = new ArrayList<>();
        dfs(head);
        int[] res = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    public void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        dfs(head.next);
        arr.add(head.val);
    }
}
