package solutions.leetcode.solution4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        double answer;
        int i1 = 0, i2 = 0;
        for (int i = 0; i < nums3.length; i++) {
            if (i1 == nums1.length) {
                nums3[i] = nums2[i2];
                i2++;
            } else if (i2 == nums2.length) {
                nums3[i] = nums1[i1];
                i1++;
            } else {
                if (nums1[i1] < nums2[i2]) {
                    nums3[i] = nums1[i1];
                    i1++;
                } else
                {
                    nums3[i] = nums2[i2];
                    i2++;
                }
            }
        }
        if (nums3.length % 2 == 1) {
            answer = nums3[nums3.length / 2];
        } else {
            answer = (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2.0;
        }
        return answer;
    }
}
