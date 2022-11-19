package solutions.leetcode.solution263;

public class Solution {
    public boolean isUgly(int n) {
        if (n == 0)
            return false;
        boolean hasChanges = true;
        while (hasChanges) {
            hasChanges = false;
            if (n % 2 == 0) {
                n = n / 2;
                hasChanges = true;
            }
            if (n % 3 == 0) {
                n = n / 3;
                hasChanges = true;
            }
            if (n % 5 == 0) {
                n = n / 5;
                hasChanges = true;
            }
        }
        return n == 1;
    }
}
