package solutions.leetcode.solution37;

import java.util.HashSet;

public class Solution {
    private char[][] board;
    HashSet<Character>[][] possibleSets;
    HashSet<Character>[] tempSets = new HashSet[9];
    char[] tempArray = new char[9];

    public void solveSudoku(char[][] board) {

        this.board = board;
        possibleSets = new HashSet[9][9];
        for (int i = 0; i < 9; i++) {
            tempSets[i] = new HashSet<>();
        }

        fillPossibleSets();

        boolean b;
        int count = 0;
        do {
            b = false;
            for (int i = 0; i < 9; i++) {
                if (correctPossibleSetsInRow(i)) {
                    b = true;
                }

            }

            for (int i = 0; i < 9; i++) {
                if (correctPossibleSetsInColumn(i)) {
                    b = true;
                }
            }
            count++;
        }
        while (b);
        findAllPossibleSudoku(0);
    }

    private boolean findAllPossibleSudoku(int count) {
        while (count < 81) {
            int x = count / 9;
            int y = count % 9;
            if (board[x][y] != '.') {
                count++;
            } else {
                for (Character ch: possibleSets[x][y]) {
                    if (possibleInRow(ch, x, y) && possibleInSquare(ch, x, y) && possibleInColumn(ch, x, y)) {
                        board[x][y] = ch;
                        if (!findAllPossibleSudoku(count + 1)) {
                            board[x][y] = '.';
                        } else {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }


    private void fillPossibleSets() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    possibleSets[i][j] = createSet(i, j);
                }
            }
        }
    }

    private HashSet<Character> createSet(int x, int y) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char ch = '1'; ch <= '9'; ch++) {
            hashSet.add(ch);
        }
        int squareX = x / 3 * 3;
        int squareY = y / 3 * 3;
        for (int i = 0; i < 9; i++) {
            hashSet.remove(board[i][y]);
            hashSet.remove(board[x][i]);
            hashSet.remove(board[squareX / 3 * 3 + i / 3][squareY / 3 * 3 + i % 3]);
        }
        return hashSet;
    }

    private boolean correctPossibleSetsInRow(int row) {
        boolean b = false;
        for (int i = 0; i < 9; i++) {
            tempSets[i].clear();
        }

        findPossibleSetsInRow(row, 0);

        for (int i = 0; i < 9; i++) {
            if (possibleSets[row][i] != null) {
                if (possibleSets[row][i].size() > tempSets[i].size()) {
                    possibleSets[row][i] = new HashSet<>(tempSets[i]);
                    b = true;
                }
                if (possibleSets[row][i].size() == 1) {
                    for (Character ch : possibleSets[row][i]) {
                        board[row][i] = ch;
                    }
                    possibleSets[row][i] = null;
                    b = true;
                }
            }
        }
        return b;
    }

    private void findPossibleSetsInRow(int row, int current) {
        if (current == 9) {
            for (int i = 0; i < 9; i++) {
                tempSets[i].add(tempArray[i]);
            }
        } else {
            if (possibleSets[row][current] == null) {
                tempArray[current] = board[row][current];
                findPossibleSetsInRow(row, current + 1);
            } else {
                for (Character ch : possibleSets[row][current]) {
                    if (possibleInSquare(ch, row, current))
                        if (possibleInColumn(ch, row, current))
                            if (notInTempArray(ch, current)) {
                                tempArray[current] = ch;
                                findPossibleSetsInRow(row, current + 1);
                            }
                }
            }
        }
    }

    private boolean notInTempArray(char ch, int number) {
        for (int i = 0; i < number; i++) {
            if (tempArray[i] == ch)
                return false;
        }
        return true;
    }

    private boolean possibleInSquare(char ch, int row, int column) {
        int x = row / 3 * 3;
        int y = column / 3 * 3;
        for (int i = 0; i < 9; i++) {
            if (board[x + i / 3][y + i % 3] == ch)
                return false;
        }
        return true;
    }


    private boolean possibleInColumn(char ch, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch)
                return false;
        }
        return true;
    }

    private boolean possibleInRow(char ch, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == ch)
                return false;
        }
        return true;
    }

    private boolean correctPossibleSetsInColumn(int column) {
        boolean b = false;
        for (int i = 0; i < 9; i++) {
            tempSets[i].clear();
        }

        findPossibleSetsInColumn(column, 0);

        for (int i = 0; i < 9; i++) {
            if (possibleSets[i][column] != null) {
                if (possibleSets[i][column].size() > tempSets[i].size()) {
                    possibleSets[i][column] = new HashSet<>(tempSets[i]);
                    b = true;
                }
                if (possibleSets[i][column].size() == 1) {
                    for (Character ch : possibleSets[i][column]) {
                        board[i][column] = ch;
                    }
                    possibleSets[i][column] = null;
                    b = true;
                }

            }
        }
        return b;
    }

    private void findPossibleSetsInColumn(int column, int current) {
        if (current == 9) {
            for (int i = 0; i < 9; i++) {
                tempSets[i].add(tempArray[i]);
            }
        } else {
            if (possibleSets[current][column] == null) {
                tempArray[current] = board[current][column];
                findPossibleSetsInColumn(column, current + 1);
            } else {
                for (Character ch : possibleSets[current][column]) {
                    if (possibleInSquare(ch, current, column))
                        if (possibleInRow(ch, current, column))
                            if (notInTempArray(ch, current)) {
                                tempArray[current] = ch;
                                findPossibleSetsInColumn(column, current + 1);
                            }
                }
            }
        }
    }

    private void correctPossibleSetsInSquare(int square) {

    }
}
