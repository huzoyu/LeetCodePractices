package com.zhongyu.hu;


/**
 *
 * 357. Count Numbers with Unique Digits
 *
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding [11,22,33,44,55,66,77,88,99])
 *
 * Credits:
 * Special thanks to @memoryless for adding this problem and creating all test cases.
 */
public class CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        int[] arr = new int[n+1];
        arr[0]=1; // x can be 0

        for(int i=1; i<=n; i++){
            arr[i]=9;
            for(int j=9; j>=9-i+2; j--){
                arr[i] *= j;
            }
        }

        int result =0;
        for(int i: arr)
            result += i;

        return result;
    }
}
