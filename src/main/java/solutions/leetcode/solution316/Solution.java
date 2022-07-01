package solutions.leetcode.solution316;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Integer> stack = new Stack<>();

        boolean[] inStack = new boolean[26];
        int index;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            if (!inStack[index]) {
                while (!stack.empty() && stack.peek() > index && lastIndex[stack.peek()] > i) {
                    inStack[stack.pop()] = false;
                }
                stack.push(index);
                inStack[index] = true;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.empty()) {
            stringBuilder.append((char) (stack.pop() + 'a'));
        }

        return stringBuilder.reverse().toString();
    }
}
