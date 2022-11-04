package solutions.leetcode.solution345;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < sb.length(); i++) {
            char ch = Character.toLowerCase(sb.charAt(i));
            if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u'))
                indexes.add(i);
        }

        for (int i = 0; i < indexes.size() / 2; i++) {
            swap(sb, indexes.get(i), indexes.get(indexes.size() - i - 1));
        }

        return sb.toString();
    }

    private void swap(StringBuilder sb, int first, int second) {
        char firstChar = sb.charAt(first);
        sb.setCharAt(first, sb.charAt(second));
        sb.setCharAt(second, firstChar);
    }
}