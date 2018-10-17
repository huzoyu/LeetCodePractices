package com.zhongyu.hu;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> dict = new HashMap<>();
        int start = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Integer pre = dict.get(ch);
            if (pre != null && pre >= start) {
                res = Math.max(res, i - start);
                start = pre + 1;
            }
            dict.put(ch, i);
        }
        return Math.max(s.length()-start, res);
    }
}
