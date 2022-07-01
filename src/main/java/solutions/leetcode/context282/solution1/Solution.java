package solutions.leetcode.context282.solution1;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < pref.length()) {
                continue;
            }
            boolean b = true;
            for (int j = 0; j < pref.length(); j++) {
                if (words[i].charAt(j) != pref.charAt(j))
                    b = false;
            }
            if (b)
                count++;
        }
        return count;
    }
}
