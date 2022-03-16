package com.leetcode.jianzhioffer;

public class P2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        // 进位
        int extra = 0;
        while(l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int sum = l1.val + l2.val + extra;
            extra = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (extra != 0) {
            cur.next = new ListNode(extra);
        }
        return dummyHead.next;
    }
}
