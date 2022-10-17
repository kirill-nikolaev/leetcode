package solutions.leetcode.solution1832;

public class Solution1 {
    public boolean checkIfPangram(String sentence) {
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            if (!sentence.contains(Character.toString(c)))
                return false;
        }
        return true;
    }
}
