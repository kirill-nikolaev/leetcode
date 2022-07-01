package solutions.leetcode.context282.solution2;

import java.util.HashMap;

public class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> a = new HashMap<>();
        HashMap<Character, Integer> b = new HashMap<>();
        HashMap<Character, Integer> c = new HashMap<>();
        int sl = s.length();
        int tl = t.length();
        for (int i = 0; i < s.length(); i++) {
            int  n = 1;
            if (a.containsKey(s.charAt(i))) {
                n = a.get(s.charAt(i)) + 1;
            }
            a.put(s.charAt(i), n);
            n = 1;
            if (c.containsKey(s.charAt(i))) {
                n = c.get(s.charAt(i)) + 1;
            }
            c.put(s.charAt(i), n);
        }
        for (int i = 0; i < t.length(); i++) {
            int  n = 1;
            if (b.containsKey(t.charAt(i))) {
                n = b.get(t.charAt(i)) + 1;
            }
            b.put(t.charAt(i), n);
            if (c.containsKey(t.charAt(i))) {
                if (c.get(t.charAt(i)) < n) {
                    c.put(t.charAt(i), n);
                }
            }
            else {
                c.put(t.charAt(i), 1);
            }
        }
        int n = 0;
        for (Character ch: c.keySet()) {
            if (a.containsKey(ch)) {
                n = n + c.get(ch) - a.get(ch);
            }
            else {
                n = n + c.get(ch);
            }

            if (b.containsKey(ch)) {
                n = n + c.get(ch) - b.get(ch);
            }
            else {
                n = n + c.get(ch);
            }

        }


        return n;
    }
}
