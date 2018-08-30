package com.zhongyu.hu;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
 *  there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 *  To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 *  All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 *  Example:
 *
 *  Input:
 *  A = [ 1, 2]
 *  B = [-2,-1]
 *  C = [-1, 2]
 *  D = [ 0, 2]
 *
 *  Output:
 *  2
 *
 *  Explanation:
 *  The two tuples are:
 *  1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 *  2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if (A.length != B.length || B.length != C.length || C.length != D.length
                || A.length == 0)
            return 0;


        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        // 默认数组ABCD有共同的length
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m1.put(A[i] + B[j], m1.getOrDefault(A[i] + B[j], 0) + 1);
                m2.put(C[i] + D[j], m2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }

        int res = 0;

        for (int x : m1.keySet()) {
            res += m2.containsKey(-x) ? m1.get(x) * m2.get(-x) : 0;
        }

        return res;
    }
}
