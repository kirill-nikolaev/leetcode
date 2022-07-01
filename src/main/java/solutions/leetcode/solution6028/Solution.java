package solutions.leetcode.solution6028;

public class Solution {
    public int countCollisions(String directions) {
        int left = 0;
        int right = directions.length() - 1;
        char[] chars = directions.toCharArray();
        int count = 0;
        while (left <= right && chars[left] == 'L')
            left++;
        while (right >= left && chars[right] == 'R')
            right--;
        if (right < left)
            return 0;
        for (int i = left; i <= right; i++) {
            if (chars[i] != 'S')
                count++;
        }
        return count;
    }
}
