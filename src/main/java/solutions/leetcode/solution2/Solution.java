package solutions.leetcode.solution2;

import solutions.leetcode.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode first, ListNode second) {
        ListNode current = first;
        int firstLength = 1;

        while (current.next != null) {
            firstLength++;
            current = current.next;
        }

        int secondLength = 1;
        current = second;

        while (current.next != null) {
            secondLength++;
            current = current.next;
        }

        if (firstLength < secondLength) {
            ListNode temp = first;
            first = second;
            second = temp;
        }

        sumLists(first, second);

        editList(first);

        return first;
    }

    private void sumLists(ListNode first, ListNode second) {
        ListNode current = first;
        while (second != null) {
            current.val = current.val + second.val;
            current = current.next;
            second = second.next;
        }
    }

    private void editList(ListNode listNode) {
        ListNode current = listNode;
        while (current != null) {
            if (current.val >= 10) {
                current.val = current.val % 10;
                if (current.next != null) {
                    current.next.val = current.next.val + 1;
                } else {
                    current.next = new ListNode(1);
                }
            }
            current = current.next;
        }
    }
}
