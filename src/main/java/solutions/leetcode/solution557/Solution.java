package solutions.leetcode.solution557;

class Solution {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (String str: strings) {
            stringBuilder.append(new StringBuilder(str).reverse());
            stringBuilder.append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
        System.out.println(solution.reverseWords("God Ding"));
    }
}
