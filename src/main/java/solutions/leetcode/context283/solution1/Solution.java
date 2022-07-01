package solutions.leetcode.context283.solution1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        for (char i = s.charAt(0); i <= s.charAt(3) ; i++) {
            for (char j = s.charAt(1); j <= s.charAt(4); j++) {
                String str = "" + i + j;
                list.add(str);
            }
        }
        return list;
    }
}
