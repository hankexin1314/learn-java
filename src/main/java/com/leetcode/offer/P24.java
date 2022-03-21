package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/21 15:03
 */
public class P24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
    public ListNode reverseList2(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode res = helper(cur.next, cur);
        cur.next = pre;
        return res;
    }
}
