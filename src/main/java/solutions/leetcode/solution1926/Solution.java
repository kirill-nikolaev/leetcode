package solutions.leetcode.solution1926;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int n;
    private int m;
    public int nearestExit(char[][] maze, int[] entrance) {
        n = maze.length;
        m = maze[0].length;
        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == '.')
                    field[i][j] = -1;
                else
                    field[i][j] = -2;
            }
        }
        field[entrance[0]][entrance[1]] = 0;
        Cell cell = new Cell(entrance[0], entrance[1], 0);

        Queue<Cell> queue = new LinkedList<>();

        addCells(queue, cell, field);

        while (!queue.isEmpty()) {
            cell = queue.remove();
            if (isExit(cell))
                return cell.distance;
            addCells(queue, cell, field);
        }

        return -1;
    }

    private boolean isExit(Cell cell) {
        return cell.x == 0 || cell.x == n - 1 || cell.y == 0 || cell.y == m - 1;
    }
    private void addCells(Queue<Cell> queue, Cell cell, int[][] field) {
        if (cell.x != 0) {
            if (field[cell.x - 1][cell.y] == -1) {
                field[cell.x - 1][cell.y] = 0;
                queue.add(new Cell(cell.x - 1, cell.y, cell.distance + 1));
            }
        }

        if (cell.x != n - 1) {
            if (field[cell.x + 1][cell.y] == -1) {
                field[cell.x + 1][cell.y] = 0;
                queue.add(new Cell(cell.x + 1, cell.y, cell.distance + 1));
            }
        }

        if (cell.y != 0) {
            if (field[cell.x][cell.y - 1] == -1) {
                field[cell.x][cell.y - 1] = 0;
                queue.add(new Cell(cell.x, cell.y - 1, cell.distance + 1));
            }
        }

        if (cell.y != m - 1) {
            if (field[cell.x][cell.y + 1] == -1) {
                field[cell.x][cell.y + 1] = 0;
                queue.add(new Cell(cell.x, cell.y + 1, cell.distance + 1));
            }
        }
    }

    private class Cell {
        int x;
        int y;
        int distance;

        public Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}

