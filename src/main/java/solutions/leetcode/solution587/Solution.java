package solutions.leetcode.solution587;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Solution {
    private final double delta = 0.000001;
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 2)
            return trees;

        if (treesInOneLine(trees))
            return trees;

        List<Coordinates> result = new ArrayList<>(findFirstTrees(trees));
        result.sort(Comparator.comparingInt(a -> a.y));
        Coordinates last = result.get(0);
        Coordinates curr = result.get(result.size() - 1);
        Coordinates prev = new Coordinates(curr.x, curr.y - 1);

        do {
            List<Coordinates> listToAdd = findNextTrees(trees, prev, curr);
            Coordinates next = listToAdd.get(0);

            for (int i = 1; i < listToAdd.size(); i++) {
                if (Math.abs(curr.x - next.x) + Math.abs(curr.y - next.y) <
                        Math.abs(curr.x - listToAdd.get(i).x) + Math.abs(curr.y - listToAdd.get(i).y)) {
                    next = listToAdd.get(i);
                }
            }
            prev = curr;
            curr = next;
            result.addAll(listToAdd);
        } while (!curr.equals(last));

        int[][] resultArray = new int[result.size() - 1][2];

        for (int i = 1; i < result.size(); i++) {
            resultArray[i - 1][0] = result.get(i).x;
            resultArray[i - 1][1] = result.get(i).y;

        }

        return resultArray;
    }

    private List<Coordinates> findNextTrees(int[][] trees, Coordinates prev, Coordinates curr) {
        double min = 1;
        List<Coordinates> result = new ArrayList<>();

        for (int i = 0; i < trees.length; i++) {
            double angle = findAngle(trees[i][0], trees[i][1], prev, curr);
            if (Math.abs(min - angle) < delta)
                result.add(new Coordinates(trees[i][0], trees[i][1]));
            else if (angle < min) {
                min = angle;
                result.clear();
                result.add(new Coordinates(trees[i][0], trees[i][1]));
            }
        }

        return result;
    }

    private double findAngle(int x, int y, Coordinates prev, Coordinates curr) {
        int ax = curr.x - prev.x;
        int ay = curr.y - prev.y;
        int bx = curr.x - x;
        int by = curr.y - y;

        return (double)(ax * bx + ay * by) / (Math.sqrt(ax * ax + ay * ay) * Math.sqrt(bx * bx + by * by));
    }

    private boolean treesInOneLine(int[][] trees) {
        boolean b = true;
        for (int i = 1; i < trees.length; i++) {
            if (trees[i][0] != trees[0][0]) {
                b = false;
                break;
            }
        }
        if (b) return true;

        b = true;
        for (int i = 1; i < trees.length; i++) {
            if (trees[i][1] != trees[0][1]) {
                b = false;
                break;
            }
        }
        if (b) return true;

        b = true;

        double tg =  ((double) trees[0][0] - trees[1][0]) / (trees[0][1] - trees[1][1]);
        for (int i = 2; i < trees.length; i++) {
            if (Math.abs(((double) trees[0][0] - trees[i][0]) / (trees[0][1] - trees[i][1]) - tg) > delta) {
                b = false;
                break;
            }
        }

        return b;
    }

    private List<Coordinates> findFirstTrees(int[][] trees) {
        List<Coordinates> result = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < trees.length; i++) {
            if (min > trees[i][0])
                min = trees[i][0];
        }

        for (int i = 0; i < trees.length; i++) {
            if (min == trees[i][0])
                result.add(new Coordinates(trees[i][0], trees[i][1]));
        }

        return result;
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
