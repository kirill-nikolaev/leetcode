package solutions.leetcode.solution36;

import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hashSet = new HashSet();
        for (int i = 0; i < 9; i++) {
            hashSet.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (hashSet.contains(board[i][j]))
                        return false;
                    else
                        hashSet.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            hashSet.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (hashSet.contains(board[j][i]))
                        return false;
                    else
                        hashSet.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            hashSet.clear();
            for (int j = 0; j < 9; j++) {
                int x = i % 3 * 3 + j % 3;
                int y = i / 3 * 3 + j / 3;
                if (board[x][y] != '.') {
                    if (hashSet.contains(board[x][y]))
                        return false;
                    else
                        hashSet.add(board[x][y]);
                }
            }
        }
        return true;
    }
}
