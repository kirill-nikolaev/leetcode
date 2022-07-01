package solutions.leetcode.solution946;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int currentIndex = -1;
        int nextIndex;
        for (int i = 0; i < popped.length; i++) {
            nextIndex = getPrev(pushed, popped[i], currentIndex);
            if (nextIndex >= 0) {
                currentIndex = nextIndex;
                pushed[currentIndex] = -1;
                continue;
            }

            nextIndex = getOneOfNext(pushed, popped[i], currentIndex);
            if (nextIndex >= 0) {
                currentIndex = nextIndex;
                pushed[currentIndex] = -1;
            }
            else
                return false;
        }
        return true;
    }

    private int getPrev(int[] pushed, int number, int index) {
        do {
            index--;
        }
        while (index >= 0 && pushed[index] == -1);
        if (index < 0 || pushed[index] != number)
            return -1;
        return index;
    }

    private int getOneOfNext(int[] pushed, int number, int index) {
        for (int i = index + 1; i < pushed.length; i++) {
            if (pushed[i] == number)
                return i;
        }
        return -1;
    }
}
