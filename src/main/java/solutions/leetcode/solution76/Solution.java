package solutions.leetcode.solution76;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, CharacterNumber> characterNumbers =  createHashMap(t);
        HashSet<Character> characters = createHashSet(t);
        int firstCharResult = -1;
        int lastCharResult = -1;
        int minLength = Integer.MAX_VALUE;
        int firstCharPos = 0;

        for (int i = 0; i < s.length(); i++) {
            if (characterNumbers.containsKey(s.charAt(i))) {
                CharacterNumber cn = characterNumbers.get(s.charAt(i));
                cn.setCurrentNumber(cn.getCurrentNumber() + 1);
                if (cn.getCurrentNumber() == cn.getRightNumber())
                    characters.remove(s.charAt(i));
            }

            while (characters.isEmpty()) {
                if (characterNumbers.containsKey(s.charAt(firstCharPos))) {
                    CharacterNumber cn = characterNumbers.get(s.charAt(firstCharPos));
                    cn.setCurrentNumber(cn.getCurrentNumber() - 1);
                    if (cn.getCurrentNumber() == cn.getRightNumber() - 1) {
                        characters.add(s.charAt(firstCharPos));

                        if (minLength > i - firstCharPos) {
                            minLength = i - firstCharPos;
                            firstCharResult = firstCharPos;
                            lastCharResult = i;
                        }
                    }
                }
                firstCharPos++;
            }
        }

        if (firstCharResult == -1)
            return "";
        else
            return s.substring(firstCharResult, lastCharResult + 1);
    }

    private HashMap<Character, CharacterNumber> createHashMap(String str) {
        HashMap<Character, CharacterNumber> characterNumbers = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            CharacterNumber cn;
            if (!characterNumbers.containsKey(str.charAt(i))) {
                cn = new CharacterNumber(0, 1);
                characterNumbers.put(str.charAt(i), cn);
            }
            else {
                cn = characterNumbers.get(str.charAt(i));
                cn.setRightNumber(cn.getRightNumber() + 1);
            }
        }

        return characterNumbers;
    }

    private HashSet<Character> createHashSet (String str) {
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            characters.add(str.charAt(i));
        }

        return characters;
    }

    private class CharacterNumber {
        int currentNumber;
        int rightNumber;

        public CharacterNumber(int currentNumber, int rightNumber) {
            this.currentNumber = currentNumber;
            this.rightNumber = rightNumber;
        }

        public int getCurrentNumber() {
            return currentNumber;
        }

        public void setCurrentNumber(int currentNumber) {
            this.currentNumber = currentNumber;
        }

        public int getRightNumber() {
            return rightNumber;
        }

        public void setRightNumber(int rightNumber) {
            this.rightNumber = rightNumber;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
        System.out.println(solution.minWindow("a", "aa"));
    }
}
