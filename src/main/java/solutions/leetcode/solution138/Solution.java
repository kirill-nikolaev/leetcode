package solutions.leetcode.solution138;

import solutions.leetcode.Node;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node result = new Node(head.val);

        Node currentResult = result;
        Node currentHead = head;

        while (currentHead.next != null) {
            currentResult.next = new Node(currentHead.next.val);
            currentResult = currentResult.next;
            currentHead = currentHead.next;
        }

        currentResult = result;
        currentHead = head;


        while (currentHead != null) {
            Node currentRandomResult = result;
            Node currentRandomHead = head;

            while (currentRandomHead != currentHead.random) {
                currentRandomHead = currentRandomHead.next;
                currentRandomResult = currentRandomResult.next;
            }
            currentResult.random = currentRandomResult;

            currentResult = currentResult.next;
            currentHead = currentHead.next;
        }

        return result;
    }
}
