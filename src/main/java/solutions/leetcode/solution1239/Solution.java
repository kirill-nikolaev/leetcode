package solutions.leetcode.solution1239;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Solution {

    private List<Integer> setNumbers = new ArrayList<>();
    private List<HashSet<Character>> list;
    private int[][] matrix;
    private int n;
    private int maxLength;
    private int currentLength;

    public int maxLength(List<String> arr) {
        list = createListOfSets(arr);
        maxLength = 0;
        currentLength = 0;

        n = list.size();
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (checkSets(list.get(i), list.get(j))) {
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            findMaxLength(i);
        }

        return maxLength;
    }

    private List<HashSet<Character>> createListOfSets(List<String> arr) {
        List<HashSet<Character>> list = new ArrayList<>();
        for (String s : arr) {
            HashSet<Character> set = s.chars().mapToObj(c -> (char) c)
                    .collect(Collectors.toCollection(HashSet::new));

            if (set.size() == s.length())
                list.add(set);
        }

        return list;
    }

    private boolean checkSets(Set<Character> set1, Set<Character> set2) {
        for (Character ch: set1) {
            if (set2.contains(ch))
                return false;
        }

        return true;
    }
    
    private void findMaxLength(int current) {
        boolean bool = true;

        for (int i = 0; i < setNumbers.size(); i++) {
            if (matrix[current][setNumbers.get(i)] != 1) {
                bool = false;
                break;
            }
        }

        if (bool) {
            setNumbers.add(current);
            currentLength += list.get(current).size();
            for (int i = current + 1; i < n; i++) {
                if (matrix[current][i] == 1)
                    findMaxLength(i);
            }

            maxLength = Math.max(currentLength, maxLength);
            currentLength-= list.get(current).size();
            setNumbers.remove(setNumbers.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxLength(List.of(new String[]{"cha","r","act","ers"})));
        System.out.println(solution.maxLength(List.of(new String[]{"abcdefghijklmnopqrstuvwxyz"})));
        System.out.println(solution.maxLength(List.of(new String[]{"un","iq","ue"})));
    }
}
