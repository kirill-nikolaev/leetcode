package solutions.leetcode.solution19;

import solutions.leetcode.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int listLength;
        ListNode current;

        listLength = 0;
        current = head;
        while (current != null) {
            current = current.next;
            listLength++;
        }

        n = listLength - n;

        if (n == 0)
            return head.next;

        ListNode previous = head;
        current = head.next;
        for (int i = 1; i < n; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;

        return head;
    }
}