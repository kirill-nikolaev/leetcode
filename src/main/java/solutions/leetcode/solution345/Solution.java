package solutions.leetcode.solution345;

class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();

        int first = 0;
        int last = s.length() - 1;

        while (true) {
            for (; first < s.length(); first++) {
                char ch = Character.toLowerCase(str[first]);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    break;
            }

            for (; last >= 0; last--) {
                char ch = Character.toLowerCase(str[last]);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    break;
            }

            if (first >= last)
                break;

            char temp = str[first];
            str[first] = str[last];
            str[last] = temp;

            first++;
            last--;
        }

        return new String(str);
    }
}