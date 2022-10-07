package solutions.leetcode.solution990;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public boolean equationsPossible(String[] equations) {
        ArrayList<HashSet<Character>> arrayList= new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            HashSet<Character> hashSet = new HashSet<>();
            hashSet.add(i);
            arrayList.add(hashSet);
        }

        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                int firstCharPosition = findPosition(equations[i].charAt(0), arrayList);

                int secondCharPosition = findPosition(equations[i].charAt(3), arrayList);

                if (secondCharPosition != firstCharPosition) {
                    for (Character ch: arrayList.get(secondCharPosition)) {
                        arrayList.get(firstCharPosition).add(ch);
                    }
                    arrayList.remove(secondCharPosition);
                }
            }
        }

        boolean result = true;

        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '!') {
                int firstCharPosition = findPosition(equations[i].charAt(0), arrayList);
                int secondCharPosition = findPosition(equations[i].charAt(3), arrayList);

                if (firstCharPosition == secondCharPosition) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    int findPosition(char ch, ArrayList<HashSet<Character>> arrayList) {
        int position = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).contains(ch)) {
                position = i;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equationsPossible(new String[]{"a==b","b!=a"}));
        System.out.println(solution.equationsPossible(new String[]{"b==a","a==b"}));
    }
}
