package solutions.leetcode.solution82;

import solutions.leetcode.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode current;
        do {
            current = head;
            head = removeCurrentDuplicates(head);
        }
        while (head != null && head != current);

        if (head == null)
            return null;

        ListNode prev;

        while (current.next != null) {
            prev = current;
            ListNode temp = prev.next;

            prev.next = removeCurrentDuplicates(current.next);

            if (prev.next == temp) {
                current = prev.next;
            }
        }
        return head;
    }

    private ListNode removeCurrentDuplicates(ListNode current) {
        if (current.next == null || current.next.val != current.val)
            return current;

        while (current.next != null && current.next.val == current.val) {
            current = current.next;
        }

        return current.next;
    }
}
