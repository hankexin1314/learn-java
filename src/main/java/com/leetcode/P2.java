package com.leetcode;

/**
 * @author kexinhan
 * @date 2022/3/7 10:15
 */
public class P2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // 表示进位
        int add = 0;
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int val = (l1.val + l2.val + add) % 10;
            add = (l1.val + l2.val + add) / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (add != 0) {
            cur.next = new ListNode(add);
        }
        return dummyHead.next;
    }
}
