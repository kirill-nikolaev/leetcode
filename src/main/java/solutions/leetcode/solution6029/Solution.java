package solutions.leetcode.solution6029;

public class Solution {
    private int[] answer;
    private int[] bobArrows;
    private int maxScore;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        answer = new int[12];
        bobArrows = new int[12];
        maxScore = 0;
        bestScore(numArrows, 11, aliceArrows, 0);
        int sum = 0;
        for (int i = 1; i < 12; i++) {
            sum += answer[i];
        }
        answer[0] = numArrows - sum;
        return answer;
    }

    private void bestScore(int notUsedArrows, int target, int[] alice, int score) {
        if (notUsedArrows == 0 || target == 0) {
            if (score > maxScore) {
                for (int i = 0; i < 12; i++) {
                    answer[i] = bobArrows[i];
                }
                maxScore = score;
            }
            return;
        }
        bestScore(notUsedArrows, target - 1, alice, score);
        if (notUsedArrows > alice[target]) {
            bobArrows[target] = alice[target] + 1;
            notUsedArrows = notUsedArrows - alice[target] - 1;
            bestScore(notUsedArrows, target - 1, alice, score + target);
            bobArrows[target] = 0;
        }
    }
}
