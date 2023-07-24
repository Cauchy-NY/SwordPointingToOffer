package questions;

import questions.utils.ListNode;

public class Question18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode prev = newHead, cur = head;
        while (cur != null && cur.val != val) {
            prev = cur;
            cur = cur.next;
        }
        if (cur != null) {
            prev.next = cur.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
