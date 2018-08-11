package com.zhongyu.hu;

/**
 * 503. Next Greater Element II
 *
 * Given a circular array (the next element of the last element is the first element
 * of the array), print the Next Greater Number for every element. The Next Greater
 * Number of a number x is the first greater number to its traversing-order next in
 * the array, which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */

public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boolean find = false;
            int j = i + 1;
            for (int k = 0; k < nums.length; k++) {
                if (j >= nums.length) j = 0;
                if (nums[j] > nums[i]) {
                    find = true;
                    res[i] = nums[j];
                    break;
                }
                j++;
            }
            if (!find) res[i] = -1;
        }
        return res;
    }
}
