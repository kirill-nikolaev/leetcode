package solutions.leetcode.solution1047;

public class Solution1 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index = 0;

        while (index + 1< sb.length()) {
            if (sb.charAt(index) == sb.charAt(index + 1)) {
                sb.deleteCharAt(index + 1);
                sb.deleteCharAt(index);
                if (index > 0)
                    index--;
            } else
                index++;
        }

        return sb.toString();
    }
}
