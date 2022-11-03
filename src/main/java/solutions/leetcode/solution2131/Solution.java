package solutions.leetcode.solution2131;

import java.util.HashMap;

public class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> wordsNumber = new HashMap<>();

        for (String str: words) {
            wordsNumber.put(str, wordsNumber.getOrDefault(str, 0) + 1);
        }

        boolean hasPalindrome = false; //есть ли слово - палиндром, которое встречается в массиве слов нечетное
                                        // количество раз

        int count = 0;

        for(String str: wordsNumber.keySet()) {
            if (str.charAt(0) == str.charAt(1)) {
                int number = wordsNumber.get(str);
                if (number % 2 == 1) {
                    hasPalindrome = true;
                    number--;
                }
                count += number;
            } else {
                String reverseStr = new String(new char[]{str.charAt(1), str.charAt(0)});

                if (wordsNumber.containsKey(reverseStr))
                    count += Math.min(wordsNumber.get(str), wordsNumber.get(reverseStr));
            }
        }

        count *= 2;

        if (hasPalindrome)
            count += 2;

        return count;
    }
}
