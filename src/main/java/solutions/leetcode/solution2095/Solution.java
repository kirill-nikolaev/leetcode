package solutions.leetcode.solution2095;


import solutions.leetcode.ListNode;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        int size = getSize(head);
        deleteNode(head, size/2);

        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private void deleteNode(ListNode node, int place) {
        for (int i = 1; i < place; i++) {
            node = node.next;
        }
        node.next = node.next.next;
    }
}
