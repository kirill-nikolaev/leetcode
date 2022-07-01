package solutions.leetcode.solution5217;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        MyComparator myComparator = new MyComparator(mapping);
        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }
        Arrays.sort(integers, myComparator);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = integers[i];
        }
        myComparator.compare(338, 38);

        return nums;
    }
    private class MyComparator implements Comparator<Integer> {
        private final int[] mapping;

        MyComparator(int[] mapping) {
            this.mapping = mapping;
        }

        @Override
        public int compare(Integer a, Integer b) {
            int aLength = (int) Math.log10(a) + 1;
            int bLength = (int) Math.log10(b) + 1;
            if (a == 0)
                aLength = 1;
            if (b == 0)
                bLength = 1;
            int max = Math.max(aLength, bLength);

            for (int i = max; i > 0; i--) {
                int aDigit = (a / (int) Math.pow(10, i - 1)) % 10;
                int bDigit = (b / (int) Math.pow(10, i - 1)) % 10;
                if (i > aLength) {
                    if (mapping[bDigit] != 0)
                        return -1;
                } else if (i > bLength) {
                    if (mapping[aDigit] != 0)
                        return 1;
                }
                else {
                    if (mapping[aDigit] > mapping[bDigit])
                        return 1;
                    else if (mapping[aDigit] < mapping[bDigit])
                        return -1;
                }

            }
            return 0;
        }
    }
}
