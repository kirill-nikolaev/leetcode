package solutions.leetcode.solution1832;

import java.util.HashSet;

public class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            hashSet.add(sentence.charAt(i));
        }
        return hashSet.size() == 26;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
