package solutions.leetcode.solution2007;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1)
            return new int[0];

        int[] result = new int[changed.length/2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Arrays.sort(changed);
        for (int i = 0; i < changed.length; i++) {
            hashMap.put(changed[i], hashMap.getOrDefault(changed[i], 0) + 1);
        }

        int n = 0;
        for (int i = 0; i < changed.length; i++) {
            if (hashMap.containsKey(changed[i]) && hashMap.get(changed[i]) != 0) {
                hashMap.put(changed[i], hashMap.get(changed[i]) - 1);
                if (hashMap.containsKey(changed[i] * 2) && hashMap.get(changed[i] * 2) != 0) {
                    result[n] = changed[i];
                    n++;

                    hashMap.put(changed[i] * 2, hashMap.get(changed[i] * 2) - 1);
                }
                else {
                    result = new int[0];
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{1,3,4,2,6,8})));
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{6,3,0,1})));
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{0,1,0,0})));

    }
}
