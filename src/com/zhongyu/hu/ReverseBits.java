package com.zhongyu.hu;

/**
 *
 * 190. Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example:
 *
 * Input: 43261596
 * Output: 964176192
 * Explanation:
 * 43261596 represented in binary as 00000010100101000001111010011100,
 * return 964176192 represented in binary as 00111001011110000010100101000000.
 */

public class ReverseBits {

    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                r |= 1;
            }
            n >>= 1;
            r <<= 1;
        }
        if ((n & 1) == 1) {
            r |= 1;
        }
        return r;
    }
}
