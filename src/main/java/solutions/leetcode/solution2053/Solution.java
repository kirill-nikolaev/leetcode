package solutions.leetcode.solution2053;

import java.util.HashMap;

public class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        boolean[] notPresentOnce = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])){
                notPresentOnce[i] = true;
                notPresentOnce[hashMap.get(arr[i])] = true;
            }
            else
                hashMap.put(arr[i], i);

        }
        for (int i = 0; i < arr.length; i++) {
            if (!notPresentOnce[i]) {
                k--;
                if (k == 0)
                    return arr[i];
            }

        }
        return "";
    }
}
