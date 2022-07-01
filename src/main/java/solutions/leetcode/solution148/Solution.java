package solutions.leetcode.solution148;

import solutions.leetcode.ListNode;

public class Solution {
    public ListNode sortList(ListNode first) {
        if ((first == null) || (first.next == null)) {
            return first;
        }
        ListNode last = first;
        int k = 1;
        while (last.next != null) {
            last = last.next;
            k++;
        }

        first = mergeSort(first, last, k);

        return first;
    }
    private ListNode merge(ListNode first, ListNode second) {
        ListNode mergedList;

        if (first.val < second.val) {
            mergedList = first;
            first = first.next;
        } else {
            mergedList = second;
            second = second.next;
        }

        ListNode current = mergedList;

        while (first != null && second != null) {
            if (first.val < second.val) {
                current.next = first;
                current = current.next;
                first = first.next;
            } else {
                current.next = second;
                current = current.next;
                second = second.next;
            }
        }
        if (first == null) {
            current.next = second;
        } else {
            current.next = first;
        }
        return mergedList;
    }

    private ListNode mergeSort(ListNode first, ListNode last, int number)  {
        int firstNumber = number / 2;
        int secondNumber = number - firstNumber;
        int k = 1;
        ListNode current = first;

        while (k < firstNumber) {
            current = current.next;
            k++;
        }
        if (secondNumber > 1) {
            last = mergeSort(current.next, last, secondNumber);
        }
        current.next = null;
        if (firstNumber > 1) {
            first = mergeSort(first, current, firstNumber);
        }

        first = merge(first, last);
        return first;
    }
}
