package solutions.leetcode.contest292.solution1;

public class Solution {
    public String largestGoodInteger(String num) {
        int count = 0;
        char max = 1;
        char current = 0;
        for (int i = 0; i < num.length(); i++) {
            if (current == num.charAt(i))
                count++;
            else {
                current = num.charAt(i);
                count = 1;
            }

            if (count == 3)
                max = (char) Math.max(current, max);
        }
        if (max == 1)
            return "";
        return "" + max + max + max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestGoodInteger("42334325"));
        System.out.println(solution.largestGoodInteger("423334325"));
    }
}
