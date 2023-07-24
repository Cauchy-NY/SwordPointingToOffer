package questions;

import questions.utils.ListNode;

public class Question22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head, second = head;
        while (k > 0 && first != null) {
            first = first.next;
            k--;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
