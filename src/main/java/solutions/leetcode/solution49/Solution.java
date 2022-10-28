package solutions.leetcode.solution49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);

            if (!hashMap.containsKey(str)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(str, list);
            } else {
                hashMap.get(str).add(strs[i]);
            }
        }
        return new ArrayList<>(hashMap.values());
    }
}
