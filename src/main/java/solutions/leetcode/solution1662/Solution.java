package solutions.leetcode.solution1662;

public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int charCount1 = 0;
        int charCount2 = 0;

        for (int i = 0; i < word1.length; i++) {
            charCount1 += word1[i].length();
        }

        for (int i = 0; i < word2.length; i++) {
            charCount2 += word2[i].length();
        }

        if (charCount1 != charCount2)
            return false;

        int charNumber = charCount1;

        int currentWord1 = 0;
        int currentChar1 = 0;

        int currentWord2 = 0;
        int currentChar2 = 0;

        for (int i = 0; i < charNumber; i++) {
            if (word1[currentWord1].charAt(currentChar1) != word2[currentWord2].charAt(currentChar2))
                return false;

            currentChar1++;
            currentChar2++;

            if (word1[currentWord1].length() == currentChar1) {
                currentChar1 = 0;
                currentWord1++;
            }

            if (word2[currentWord2].length() == currentChar2) {
                currentChar2 = 0;
                currentWord2++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
        System.out.println(solution.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
    }
}
