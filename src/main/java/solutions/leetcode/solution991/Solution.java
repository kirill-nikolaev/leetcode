package solutions.leetcode.solution991;

public class Solution {
    public int brokenCalc(int startValue, int target) {
        if (target < startValue) return startValue - target;

        int power = (int) Math.ceil(Math.log((double) target / startValue) / Math.log(2));
        int result = power;

        int powerOf2 =  (int) Math.pow(2, power);
        int difference = startValue * powerOf2 - target;
        result = result + difference / powerOf2;
        difference = difference % powerOf2;
        powerOf2 = powerOf2 / 2;
        while (difference > 0) {
            if (difference >= powerOf2) {
                difference = difference - powerOf2;
                result++;
            }
            powerOf2 = powerOf2 / 2;
        }

        return result;
    }
}
