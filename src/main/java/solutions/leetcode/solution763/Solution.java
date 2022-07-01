package solutions.leetcode.solution763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Range> ranges = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            if (ranges.containsKey(s.charAt(i)))
                ranges.get(s.charAt(i)).lastIndex = i;
            else {
                Range range = new Range(i);
                range.firstIndex = i;
                ranges.put(s.charAt(i), range);
            }
        }
        List<Integer> result = addPartSize(0, s.length() - 1, ranges);

        return result;
    }

    private ArrayList<Integer> addPartSize(int first, int last, HashMap<Character, Range> ranges) {
        if (first > last)
            return new ArrayList<>();

        int firstCurrent = -1;
        int lastCurrent = -1;
        List<Character> charactersToDelete = new ArrayList<>();
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;

            for (Character ch : ranges.keySet()) {
                Range range = ranges.get(ch);

                if (range.firstIndex >= first && range.lastIndex <= last) {

                    if (firstCurrent == -1) {
                        firstCurrent = range.firstIndex;
                        lastCurrent = range.lastIndex;
                        charactersToDelete.add(ch);
                        isChanged = true;
                    }
                    else if (!(range.firstIndex < firstCurrent && range.lastIndex < firstCurrent ||
                            range.firstIndex > lastCurrent && range.lastIndex > lastCurrent)) {

                        firstCurrent = Math.min(range.firstIndex, firstCurrent);
                        lastCurrent = Math.max(range.lastIndex, lastCurrent);
                        charactersToDelete.add(ch);
                        isChanged = true;
                    }
                }
            }
            for (Character ch: charactersToDelete)
                ranges.remove(ch);
            charactersToDelete.clear();
        }

        ArrayList<Integer> result = addPartSize(first, firstCurrent - 1, ranges);
        result.add(lastCurrent - firstCurrent + 1);
        result.addAll(addPartSize(lastCurrent + 1, last, ranges));
        return result;
    }

    private class Range {
        int firstIndex;
        int lastIndex;

        public Range(int index) {
            this.firstIndex = index;
            this.lastIndex = index;
        }
    }
}
