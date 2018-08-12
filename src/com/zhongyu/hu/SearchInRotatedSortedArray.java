package com.zhongyu.hu;

/**
 * 33. Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */

public class SearchInRotatedSortedArray {
    public static int[] nums = {4,5,9,0,2,3};

    public static void main(String[] args) {
        System.out.println(search(nums, 0));
    }


    public static int search(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == A[m])
                return m;
            if (A[m] < A[r]) {
                if (target > A[m] && target <= A[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else {
                if (target >= A[l] && target < A[m])
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return -1;


    }
}
