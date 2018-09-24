package com.zhongyu.hu;

/**
 *
 * 552. Student Attendance Record II
 *
 * Given a positive integer n, return the number of all possible attendance records with length n,
 * which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
 *
 * A student attendance record is a string that only contains the following three characters:
 *
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or
 * more than two continuous 'L' (late).
 *
 * Example 1:
 * Input: n = 2
 * Output: 8
 * Explanation:
 * There are 8 records with length 2 will be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" won't be regarded as rewardable owing to more than one absent times.
 * Note: The value of n won't exceed 100,000.
 *
 */
public class StudentAttendanceRecordII {

    public int checkRecord(int n) {
        int[] dp = {1, 1, 0, 1, 0, 0};
        for (int i = 2; i <= n; i++) {
            dp = new int[]{sum(dp, 0, 2), dp[0], dp[1], sum(dp, 0, 5), dp[3], dp[4]};
        }
        return sum(dp, 0, 5);
    }
    private int sum(int[] dp, int start, int end) {
        final int MOD = 1000000007;
        int res = 0;
        for (int i = start; i <= end; i++) {
            res = (res + dp[i]) % MOD;
        }
        return res;
    }

}
