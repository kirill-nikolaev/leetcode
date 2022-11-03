package solutions.leetcode.solution2131;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        assertEquals(6, solution.longestPalindrome(new String[]{"lc","cl","gg"}));
    }


    @Test
    void Test2() {
        Solution solution = new Solution();
        assertEquals(8, solution.longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
    }

    @Test
    void Test3() {
        Solution solution = new Solution();
        assertEquals(2, solution.longestPalindrome(new String[]{"cc","ll","xx"}));
    }
}