package solutions.leetcode.solution2162;

import java.util.ArrayList;

public class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int seconds = targetSeconds % 60;
        int minutes = targetSeconds / 60;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int[] array = new int[4];

        if (minutes != 100) {
            array[0] = minutes / 10;
            array[1] = minutes % 10;
            array[2] = seconds / 10;
            array[3] = seconds % 10;
        } else {
            seconds = 60 + seconds;
            minutes--;
            array[0] = minutes / 10;
            array[1] = minutes % 10;
            array[2] = seconds / 10;
            array[3] = seconds % 10;
        }
        arrayList.add(array);

        if (minutes != 0 && seconds < 40) {
            array = new int[4];
            minutes--;
            seconds = seconds + 60;
            array[0] = minutes / 10;
            array[1] = minutes % 10;
            array[2] = seconds / 10;
            array[3] = seconds % 10;
            arrayList.add(array);
        }

        if (arrayList.size() == 1)
            return getMoves(startAt, moveCost, pushCost, arrayList.get(0));
        else {
            int first = getMoves(startAt, moveCost, pushCost, arrayList.get(0));
            int second = getMoves(startAt, moveCost, pushCost, arrayList.get(1));
            return Math.min(first, second);
        }
    }

    private int getMoves(int startAt, int moveCost, int pushCost, int[] array) {
        int first = 0;
        for (int i = 0; i < 4; i++) {
            if (array[i] != 0) {
                first = i;
                break;
            }
        }
        int moves = 0;
        for (int i = first; i < 4; i++) {
            if (startAt != array[i]) {
                startAt = array[i];
                moves += moveCost;
            }
            moves += pushCost;
        }

        return moves;
    }
}
