package com.zhongyu.hu;

public class BullsAndCows {
    /**
     * 299. Bulls and Cows
     *
     * You are playing the following Bulls and Cows game with your friend: You write down
     * a number and ask your friend to guess what the number is. Each time your friend makes
     * a guess, you provide a hint that indicates how many digits in said guess match your
     * secret number exactly in both digit and position (called "bulls") and how many digits
     * match the secret number but locate in the wrong position (called "cows"). Your friend
     * will use successive guesses and hints to eventually derive the secret number.
     *
     * Write a function to return a hint according to the secret number and friend's guess,
     * use A to indicate the bulls and B to indicate the cows.
     *
     * Please note that both secret number and friend's guess may contain duplicate digits.
     *
     * Example 1:
     *
     * Input: secret = "1807", guess = "7810"
     *
     * Output: "1A3B"
     *
     * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
     * Example 2:
     *
     * Input: secret = "1123", guess = "0111"
     *
     * Output: "1A1B"
     *
     * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
     * Note: You may assume that the secret number and your friend's guess only contain digits,
     * and their lengths are always equal.
     *
     * 思路：
     * 字符串遍历对比,得出bows数量，顺便用10个长度的int数组记每种数字出现的次数
     * 然后再遍历int数组，取两边对比的最小值，当无重复时，总有一边为0，
     * 当重复时，小的那边总是cows数量
     *
     *
     */

    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int[] snum = new int[10];
        int[] gnum = new int[10];
        int A = 0;
        for(int i=0;i<s.length;++i){
            if(s[i] == g[i]){A++;}
            snum[s[i]-'0']++;
            gnum[g[i]-'0']++;
        }
        int B = 0;
        for(int i=0;i<10;++i){
            B = B + Math.min(snum[i],gnum[i]);
        }
        StringBuilder sb =  new StringBuilder();
        sb.append(A);sb.append("A");sb.append(B-A);sb.append("B");
        return sb.toString();
    }
}
