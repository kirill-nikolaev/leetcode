package solutions.leetcode.solution20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if (stack.empty())
                    return false;
                char lastChar = stack.pop();
                if ((lastChar == '(' && ch != ')') || (lastChar == '[' && ch != ']') || (lastChar == '{' && ch != '}'))
                    return false;
            }
        }
        return stack.empty();
    }
}
