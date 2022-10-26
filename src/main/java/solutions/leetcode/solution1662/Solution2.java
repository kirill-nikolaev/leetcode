package solutions.leetcode.solution1662;

public class Solution2 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();

        for (String s : word1) {
            stringBuilder1.append(s);
        }

        for (String s : word2) {
            stringBuilder2.append(s);
        }

        return stringBuilder1.toString().equals(stringBuilder2.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
        System.out.println(solution.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
    }
}
