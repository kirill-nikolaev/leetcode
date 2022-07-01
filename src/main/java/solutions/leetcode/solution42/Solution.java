package solutions.leetcode.solution42;

public class Solution {
    public int trap(int[] heights) {
        int maxHeight = 0;
        int leftMaxHeitCoordinate = 0;
        int rightMaxHeitCoordinate = 0;
        int heightNumber = heights.length;
        for (int i = 0; i < heightNumber; i++) {
            if (heights[i] > maxHeight) {
                leftMaxHeitCoordinate = rightMaxHeitCoordinate = i;
                maxHeight = heights[i];
            } else if (heights[i] == maxHeight) {
                rightMaxHeitCoordinate = i;
            }
        }
        int waterVolume = 0;
        if (leftMaxHeitCoordinate != 0) {
            int left = 0;
            int next = 1;
            int blockVolume = 0;
            while (next <= leftMaxHeitCoordinate) {
                if (heights[next] > heights[left]) {
                    waterVolume = waterVolume + (next - left - 1) * heights[left] - blockVolume;
                    left = next;
                    next++;
                    blockVolume = 0;
                }
                else {
                    blockVolume += heights[next];
                    next++;
                }
            }
        }
        if (rightMaxHeitCoordinate != heightNumber - 1) {
            int right = heightNumber - 1;
            int next = right - 1;
            int blockVolume = 0;
            while (next >= leftMaxHeitCoordinate) {
                if (heights[next] > heights[right]) {
                    waterVolume = waterVolume + (right - next - 1) * heights[right] - blockVolume;
                    right = next;
                    next--;
                    blockVolume = 0;
                }
                else {
                    blockVolume += heights[next];
                    next--;
                }
            }
        }
        if (leftMaxHeitCoordinate != rightMaxHeitCoordinate) {
            int blockVolume = 0;
            for (int i = leftMaxHeitCoordinate + 1; i < rightMaxHeitCoordinate; i++) {
                blockVolume = blockVolume + heights[i];
            }
            waterVolume = waterVolume + (rightMaxHeitCoordinate - leftMaxHeitCoordinate - 1)
                    * heights[rightMaxHeitCoordinate] - blockVolume;
        }

        return waterVolume;
    }
}
