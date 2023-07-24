package questions;

import questions.utils.ListNode;

public class Question06 {
    public int[] reversePrint(ListNode head) {
        ListNode prev = null;
        int cnt = 0;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
            cnt++;
        }

        int[] ret = new int[cnt];
        int index = 0;
        while (prev != null) {
            ret[index++] = prev.val;
            prev = prev.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        Question06 question06 = new Question06();
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);
        int[] ret = question06.reversePrint(node1);
        for (int i : ret) {
            System.out.println(i);
        }
    }
}
