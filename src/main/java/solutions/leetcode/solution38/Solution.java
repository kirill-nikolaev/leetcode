package solutions.leetcode.solution38;

public class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            result = getNextSequence(result);
        }

        return result.toString();
    }

    private StringBuilder getNextSequence(StringBuilder sequence) {
        char currentChar = sequence.charAt(0);
        int count = 1;
        StringBuilder nextSequence = new StringBuilder();

        for (int i = 1; i < sequence.length(); i++) {
            if (currentChar == sequence.charAt(i))
                count++;
            else {
                nextSequence.append(count).append(currentChar);
                currentChar = sequence.charAt(i);
                count = 1;
            }
        }
        nextSequence.append(count).append(currentChar);

        return nextSequence;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(30));
    }
}
