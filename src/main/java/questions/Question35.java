package questions;

import java.util.HashMap;
import java.util.Map;
import util.RandomNode;

public class Question35 {
    public RandomNode copyRandomList(RandomNode head) {
        Map<RandomNode, RandomNode> cache = new HashMap<>();
        RandomNode cur = head;
        RandomNode prev = new RandomNode(-1);
        while (cur != null) {
            RandomNode newNode = new RandomNode(cur.val);
            prev.next = newNode;
            prev = newNode;
            cache.put(cur, newNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            cache.get(cur).random = cache.get(cur.random);
            cur = cur.next;
        }
        return cache.get(head);
    }

    Map<RandomNode, RandomNode> cachedNode = new HashMap<>();

    public RandomNode copyRandomList2(RandomNode head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            RandomNode headNew = new RandomNode(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList2(head.next);
            headNew.random = copyRandomList2(head.random);
        }
        return cachedNode.get(head);
    }

    public RandomNode copyRandomList3(RandomNode head) {
        if (head == null) {
            return null;
        }
        for (RandomNode node = head; node != null; node = node.next.next) {
            RandomNode nodeNew = new RandomNode(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (RandomNode node = head; node != null; node = node.next.next) {
            RandomNode nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        RandomNode headNew = head.next;
        for (RandomNode node = head; node != null; node = node.next) {
            RandomNode nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
