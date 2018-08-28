package com.zhongyu.hu;

import java.util.HashMap;

/**
 *
 * 788. Rotated Digits
 *
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X.  Each digit must be rotated
 * - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8
 * rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other,
 * and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 *
 * N  will be in range [1, 10000].
 */
public class RotatedDigits {
    public int rotatedDigits(int N)
    {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(9, 6);


        for(int i=1; i<=N; i++)
        {
            int number = i;
            int newNumber = 0;
            int m = 1;

            while(number > 0)
            {
                int digit = number % 10;     // get the digit

                if(map.containsKey(digit))  // check if digit can be rotated
                {
                    newNumber = map.get(digit) * m + newNumber;
                    number /= 10;
                    m *= 10;
                }
                else    // if digit is invalid
                {
                    break;
                }
            }

            if(number == 0 && i != newNumber)
                count++;

        }

        return count;
    }
}
