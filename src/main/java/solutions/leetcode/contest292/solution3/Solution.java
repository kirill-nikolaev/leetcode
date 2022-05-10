package solutions.leetcode.contest292.solution3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private long modulo;
    public int countTexts(String pressedKeys) {
        modulo = 1_000_000_007;
        long result = 1;
        List<Character> characterList = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        char currentChar = pressedKeys.charAt(0);
        int currentNumber = 1;
        for (int i = 1; i < pressedKeys.length(); i++) {
            if (currentChar != pressedKeys.charAt(i)) {
                characterList.add(currentChar);
                numbers.add(currentNumber);
                currentNumber = 1;
                currentChar = pressedKeys.charAt(i);
            } else
                currentNumber++;
        }
        characterList.add(currentChar);
        numbers.add(currentNumber);
        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i) == '7' || characterList.get(i) == '9')
                result = (result * findNumber4(numbers.get(i))) % modulo;
            else
                result = (result * findNumber3(numbers.get(i))) % modulo;
        }
        System.out.println(result);
        return (int) result;
    }

    private long findNumber3(int n) {

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;
        long[] array = new long[n];
        array[0] = 1;
        array[1] = 2;
        array[2] = 4;
        for (int i = 3; i < n; i++) {
            array[i] = array[i - 3] * 4 + array[i - 2] * 2 + array[i - 1] + 1;
        }
        return array[n - 1] % modulo;
    }

    private long findNumber4(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;
        if (n == 4)
            return 12;
        long[] array = new long[n];
        array[0] = 1;
        array[1] = 2;
        array[2] = 4;
        array[3] = 12;
        for (int i = 4; i < n; i++) {
            array[i] = array[i - 4] * 12 + array[i - 3] * 4 + array[i - 2] * 2 + array[i - 1] + 1;
        }
        return array[n - 1] % modulo;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countTexts("2222"));
        System.out.println(solution.countTexts("222222222222222222222222222222222222"));
    }
}
