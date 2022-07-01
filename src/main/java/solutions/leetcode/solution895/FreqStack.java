package solutions.leetcode.solution895;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FreqStack {
    private List<LinkedList<Integer>> stacks;
    private HashMap<Integer, Integer> frequency;
    int maxFrequency;

    public FreqStack() {
        stacks = new ArrayList<>();
        stacks.add(new LinkedList<>());
        frequency = new HashMap<>();
    }

    public void push(int val) {
        frequency.put(val, frequency.getOrDefault(val, 0) + 1);
        int currentFrequency = frequency.get(val);
        maxFrequency = Math.max(maxFrequency, currentFrequency);
        if (stacks.size() == maxFrequency)
            stacks.add(new LinkedList<>());
        stacks.get(currentFrequency).push(val);
    }

    public int pop() {
        int element = stacks.get(maxFrequency).pop();
        if (stacks.get(maxFrequency).size() == 0)
            maxFrequency--;
        frequency.put(element, frequency.get(element) - 1);
        return element;
    }
}
