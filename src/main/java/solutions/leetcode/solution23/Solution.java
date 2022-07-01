package solutions.leetcode.solution23;

import solutions.leetcode.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode first;
        ListNode current;

        int length = createBinaryHeap(lists);

        if (length == 0)
            return null;

        first = lists[0];
        current = first;

        length = removeTop(lists, length);

        while (length > 0) {
            current.next = lists[0];
            current = current.next;
            length = removeTop(lists, length);
        }

        return first;
    }

    private int createBinaryHeap(ListNode[] lists) {
        int length = lists.length;

        for (int i = 0; i < length; i++) {
            if (lists[i] == null) {
                length--;
                swap(lists, i, length);
                i--;
            }
        }


        for (int i = 1; i < length; i++) {
            int child = i;
            int parent = (i - 1) / 2;
            while (child > 0 && lists[parent].val > lists[child].val) {
                swap(lists, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }

        return length;
    }

    private void swap(ListNode[] lists, int x, int y) {
        ListNode temp = lists[x];
        lists[x] = lists[y];
        lists[y] = temp;
    }

    private int removeTop(ListNode[] lists, int length) {
        lists[0] = lists[0].next;
        if (lists[0] == null) {
            swap(lists, 0, length - 1);
            length = length - 1;
        }
        balanceBinaryHeap(lists, length);
        return length;
    }

    private void balanceBinaryHeap(ListNode[] lists, int length) {
        int parent = 0;
        int firstChild = 1;
        int secondChild = 2;

        while (firstChild < length) {
            if (secondChild >=  length) {
                if (lists[firstChild].val < lists[parent].val) {
                    swap(lists, firstChild, parent);
                }
                break;
            } else {
                if (lists[firstChild].val < lists[parent].val) {
                    if (lists[firstChild].val <= lists[secondChild].val) {
                        swap(lists, firstChild, parent);
                        parent = firstChild;
                    } else {
                        swap(lists, secondChild, parent);
                        parent = secondChild;
                    }
                } else if (lists[secondChild].val < lists[parent].val) {
                    swap(lists, secondChild, parent);
                    parent = secondChild;
                } else
                    break;
                firstChild = 2 * parent + 1;
                secondChild = 2 * parent + 2;
            }
        }
    }
}
