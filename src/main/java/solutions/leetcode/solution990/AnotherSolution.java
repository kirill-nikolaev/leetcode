package solutions.leetcode.solution990;

import java.util.ArrayList;

public class AnotherSolution {
    public boolean equationsPossible(String[] equations) {
        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                char firstChar = equations[i].charAt(0);
                int firstCharPosition = getPosition(firstChar, stringArrayList);

                char secondChar = equations[i].charAt(3);
                int secondCharPosition = getPosition(secondChar, stringArrayList);

                if (firstCharPosition == secondCharPosition) {
                    if (firstCharPosition == -1) {
                        stringArrayList.add("" + firstChar + secondChar);
                    }
                }
                else {
                    if (firstCharPosition > secondCharPosition) {
                        int tempInt = firstCharPosition;
                        firstCharPosition = secondCharPosition;
                        secondCharPosition = tempInt;
                        firstChar = secondChar;
                    }

                    if (firstCharPosition == -1) {
                        stringArrayList.add(stringArrayList.remove(secondCharPosition) + firstChar);
                    } else {
                        stringArrayList.add(
                                stringArrayList.remove(secondCharPosition) + stringArrayList.remove(firstCharPosition)
                        );
                    }
                }
            }
        }
        boolean result = true;

        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '!') {
                if (equations[i].charAt(0) == equations[i].charAt(3)) {
                    result = false;
                    break;
                }
                int firstCharPosition = getPosition(equations[i].charAt(0), stringArrayList);
                int secondCharPosition = getPosition(equations[i].charAt(3), stringArrayList);
                if (firstCharPosition == secondCharPosition && firstCharPosition != -1) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    int getPosition(char ch, ArrayList<String> stringArrayList) {
        int position = -1;
        for (int i = 0; i < stringArrayList.size(); i++) {
            if (stringArrayList.get(i).indexOf(ch) >= 0) {
                position = i;
                break;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        AnotherSolution solution = new AnotherSolution();
        System.out.println(solution.equationsPossible(new String[]{"a==b","b!=a"}));
        System.out.println(solution.equationsPossible(new String[]{"b==a","a==b"}));
    }
}
