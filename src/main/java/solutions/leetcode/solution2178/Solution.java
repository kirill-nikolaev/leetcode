package solutions.leetcode.solution2178;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) {
            return new ArrayList<Long>();
        }

        ArrayList<Long> numbers = new ArrayList<>();
        long number = 2;
        long currentSum = 0;
        while (finalSum - currentSum >= number) {
            numbers.add(number);
            currentSum = currentSum + number;
            number += 2;

        }
        long lastNumber = numbers.remove(numbers.size() - 1);
        numbers.add(lastNumber + finalSum - currentSum);
        return numbers;
    }
}
