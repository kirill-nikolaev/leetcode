package solutions.leetcode.solution30;

import java.util.*;

public class Solution {
    private HashSet<Integer> result = new HashSet<>();
    private HashSet<Integer> usedWords = new HashSet<>();
    private Deque<Integer> deque = new LinkedList<>();

    public List<Integer> findSubstring(String s, String[] words) {
        result.clear();
        int n = words.length;
        int l = words[0].length();
        List<Set<Integer>> indexes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            indexes.add(new HashSet<>());
            int index = 0;
            while ((index = s.indexOf(words[i], index)) >= 0) {
                indexes.get(i).add(index);
                index++;
            }
            if (indexes.get(i).size() == 0)
                return new ArrayList<>();
        }
        int lastIndex = s.length() - n * l;
        for (int i = 0; i <= lastIndex; i++) {
            usedWords.clear();
            deque.clear();
            if (!result.contains(i))
                findStartOfSubstring(i, indexes, l, n);
        }
        return new ArrayList<>(result);
    }

    private void findStartOfSubstring(int index, List<Set<Integer>> indexes, int l, int n) {
        if (usedWords.size() == n) {
            result.add(index - l * n);
            if (indexes.get(deque.getLast()).contains(index)) {
                deque.push(deque.pollLast());
                findStartOfSubstring(index + l, indexes, l, n);
            }
        }
        int nextIndex = -1;
        for (int i = 0; i < indexes.size(); i++) {
            if (!usedWords.contains(i) && indexes.get(i).contains(index)) {
                usedWords.add(i);
                deque.push(i);
                nextIndex = index + l;
                break;
            }
        }
        if (nextIndex >= 0)
            findStartOfSubstring(nextIndex, indexes, l, n);
    }
}
