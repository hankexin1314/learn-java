package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/21 10:45
 */
public class P18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (head != null && head.val != val) {
            head = head.next;
            pre = pre.next;
        }
        if (head != null) {
            pre.next = head.next;
            head.next = null;
        }
        return dummyHead.next;
    }
}
