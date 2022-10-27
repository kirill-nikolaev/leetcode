package solutions.leetcode.solution835;

import java.util.HashSet;
import java.util.Objects;

public class Solution1 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        HashSet<Coordinates> coordinatesSet = new HashSet<>();

        int n = img1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img2[i][j] == 1)
                    coordinatesSet.add(new Coordinates(i, j));
            }
        }

        Coordinates coordinates = new Coordinates(0, 0);
        int max = 0;


        for (int i = -n + 1; i < n; i++) {
            for (int j = -n + 1; j < n; j++) {
                int current = 0;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (img1[k][l]  == 1) {
                            coordinates.x = k + i;
                            coordinates.y = l + j;
                            if (coordinatesSet.contains(coordinates))
                                current++;
                        }
                    }
                }
                max = Math.max(max, current);
            }
        }

        return max;
    }

    private class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinates)) return false;
            Coordinates that = (Coordinates) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}