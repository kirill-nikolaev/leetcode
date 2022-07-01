package solutions.leetcode.context282.solution3;

public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long first = 1;
        long last = Long.MAX_VALUE / 2;
        long current;
        long number;
        if ((getNumberOfTotalTrips(time, 1)) >= totalTrips)
            return 1L;
        while (last - first > 1) {
            current = (last + first) / 2;
            number = getNumberOfTotalTrips(time, current);
            if (number < totalTrips) {
                first = current;
            } else {
                last = current;
            }
        }
        return last;
    }
    private long getNumberOfTotalTrips(int[] time, long maxTime) {
        long number = 0;
        for (int i = 0; i < time.length; i++) {
            number += maxTime / time[i];
            if (number < 0)
                return Long.MAX_VALUE;
        }
        return number;
    }
}
