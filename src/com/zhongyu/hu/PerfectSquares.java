package com.zhongyu.hu;

/**
 *
 * 279. Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect
 * square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

public class PerfectSquares {


    public int numSquares(int n) {
        if(n < 1) {
            return 0;
        }
        int[] min = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            int tmp = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                tmp = Math.min(tmp, min[i - j * j] + 1);
            }
            min[i] = tmp;
        }

        return min[n];
    }
}
