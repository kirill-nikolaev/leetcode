package solutions.leetcode.solution1328;

public class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1)
            return "";
        int i = 0;
        while (i < palindrome.length() / 2) {
            if (palindrome.charAt(i) != 'a')
                return new StringBuilder(palindrome).replace(i, i + 1, "a").toString();
            i++;
        }
        i = palindrome.length();
        return palindrome.substring(0, palindrome.length() - 1) + 'b';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.breakPalindrome("abccba"));
        System.out.println(solution.breakPalindrome("a"));
        System.out.println(solution.breakPalindrome("aa"));
    }
}
