package solutions.leetcode.solution509;

public class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int f1 = 0;
        int f2 = 1;
        int f3;

        for (int i = 1; i < n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(0));
        System.out.println(solution.fib(1));
    }
}
