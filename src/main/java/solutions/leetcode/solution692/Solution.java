package solutions.leetcode.solution692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordFrequencyMap = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            wordFrequencyMap.put(words[i], wordFrequencyMap.getOrDefault(words[i], 0) + 1);

        List<String> result = wordFrequencyMap.entrySet().stream()
                .sorted((x, y) -> x.getValue().equals(y.getValue()) ? x.getKey().compareTo(y.getKey()) : y.getValue().compareTo(x.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
//        List<String> result = wordFrequencyMap.entrySet().stream().
//                map(entry->new WordFrequency(entry.getKey(), entry.getValue())).
//                sorted().
//                limit(k).
//                map(WordFrequency::getWord)
//                .collect(Collectors.toList());

        return result;
    }

    private class WordFrequency implements Comparable<WordFrequency>{
        private final String word;
        private final int frequency;

        public WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        public String getWord() {
            return word;
        }

        public int getFrequency() {
            return frequency;
        }

        @Override
        public int compareTo(WordFrequency wordFrequency) {
            if (this.frequency != wordFrequency.getFrequency())
                return wordFrequency.getFrequency() - this.frequency;
            else
                return word.compareTo(wordFrequency.getWord());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
        System.out.println(solution.topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }
}
