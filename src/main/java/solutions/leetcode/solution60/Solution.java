package solutions.leetcode.solution60;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        int factorial = 1;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int i = 2; i <= n; i++) {
            factorial = factorial * i;
        }

        String result = "";
        k--;
        while (n >= 1) {
            factorial = factorial / n;
            int index = k / factorial;
            result = result + list.get(index);
            list.remove(index);
            n--;
            k = k - factorial * index;
        }

        return result;
    }
}
