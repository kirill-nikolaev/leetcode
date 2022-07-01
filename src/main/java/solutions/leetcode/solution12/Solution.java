package solutions.leetcode.solution12;

public class Solution {
    public String intToRoman(int num) {
        int pos = 1;
        String str = "";
        while (num > 0) {
            str = getString(num % 10, pos) + str;
            pos++;
            num /= 10;
        }
        return str;
    }

    private String getString(int number, int pos) {
        char first;
        char second;
        char third;

        switch (pos) {
            case 1:
                first = 'I';
                second = 'V';
                third = 'X';
                break;
            case 2:
                first = 'X';
                second = 'L';
                third = 'C';
                break;
            case 3:
                first = 'C';
                second = 'D';
                third = 'M';
                break;
            default:
                first = 'M';
                second = 'M';
                third = 'M';
                break;
        }
        if (number == 4)
            return "" + first + second;
        if (number == 9)
            return "" + first + third;

        StringBuilder str = new StringBuilder();

        if (number > 3) {
            str.append(second);
        }

        for (int i = 0; i < number % 5; i++) {
            str.append(first);
        }

        return str.toString();
    }
}
