package solutions.leetcode.solution12;


public class Solution1 {
    static final char[] chars = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    static final int[] ints = new int[]{1, 5, 10, 50, 100, 500, 1000};

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        for (int i = ints.length - 1; i >= 0; i -= 2) {
            int count = num / ints[i];
            if (count == 9) {
                result.append(chars[i]).append(chars[i + 2]);
                num -= 9 * ints[i];
                continue;
            }

            if (count == 4) {
                result.append(chars[i]).append(chars[i + 1]);
                num -= 4 * ints[i];
                continue;
            }

            if (count > 4) {
                result.append(chars[i + 1]);
                num -= 5 * ints[i];
                count -= 5;
            }

            result.append(String.valueOf(chars[i]).repeat(count));
            num -= count * ints[i];
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.intToRoman(1994));
        System.out.println(solution1.intToRoman(58));
        System.out.println(solution1.intToRoman(3));
    }
}
