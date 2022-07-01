package solutions.leetcode.solution25;

import solutions.leetcode.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        head = reverseNextGroup(head, k);
        return head;
    }

    private ListNode reverseNextGroup(ListNode firstNode, int k) {
        if (firstNode == null)
            return null;
        int count = 1;
        ListNode currentNode = firstNode;
        while (count < k) {
            currentNode = currentNode.next;
            if (currentNode == null)
                return firstNode;
            count++;
        }
        ListNode lastNode = currentNode;
        ListNode previousNode = reverseNextGroup(currentNode.next, k);
        currentNode = firstNode;
        ListNode nextNode;

        while (currentNode != lastNode) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        lastNode.next = previousNode;
        return lastNode;
    }
}
