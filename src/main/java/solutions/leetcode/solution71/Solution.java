package solutions.leetcode.solution71;

import java.util.Stack;

public class Solution {

    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("")) continue;
            if (strings[i].equals(".")) continue;
            if (strings[i].equals("..")) {
                if (!stack.empty()) stack.pop();
                continue;
            }
            stack.push(strings[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            stringBuilder.append("/").append(stack.get(i));
        }
        String string = stringBuilder.toString();
        return string.equals("") ? "/" : string;
    }
}
