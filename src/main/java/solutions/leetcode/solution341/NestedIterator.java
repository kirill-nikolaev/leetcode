package solutions.leetcode.solution341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private final List<Integer> list;
    private int current;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = convertToList(nestedList);
        current = 0;
    }

    @Override
    public Integer next() {
        return list.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current < list.size();
    }

    private List<Integer> convertToList(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger())
                list.add(nestedInteger.getInteger());
            else
                list.addAll(convertToList(nestedInteger.getList()));
        }
        return list;
    }
}
