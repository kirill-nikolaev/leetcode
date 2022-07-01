package solutions.leetcode.solution61;

import solutions.leetcode.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int listLength = 1;
        ListNode current = head;

        while (current.next != null) {
            listLength++;
            current = current.next;
        }

        k = k % listLength;

        if (k == 0)
            return head;
        else
            k = listLength - k;

        current.next = head;
        current = head;

        for (int i = 1; i < k; i++) {
            current = current.next;
        }


        head = current.next;

        current.next = null;

        return head;
    }
}
