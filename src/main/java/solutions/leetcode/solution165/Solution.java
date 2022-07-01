package solutions.leetcode.solution165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.0*");
        String[] versions2 = version2.split("\\.0*");

        int length = Math.max(versions1.length, versions2.length);

        int[] v1 = new int[length];
        int[] v2 = new int[length];

        for (int i = 0; i < versions1.length; i++) {
            if (!versions1[i].equals(""))
                v1[i] = Integer.parseInt(versions1[i]);
        }

        for (int i = 0; i < versions2.length; i++) {
            if (!versions2[i].equals(""))
                v2[i] = Integer.parseInt(versions2[i]);
        }

        for (int i = 0; i < length; i++) {
            if (v1[i] > v2[i])
                return 1;
            if (v1[i] < v2[i])
                return -1;
        }

        return 0;
    }
}
