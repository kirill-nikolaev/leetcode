package solutions.leetcode.solution21;

import solutions.leetcode.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        ListNode listNode;

        if (list1.val <= list2.val) {
            listNode = list1;
            list1 = list1.next;
        } else {
            listNode = list2;
            list2 = list2.next;
        }

        ListNode current = listNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }

        return listNode;
    }
}
