package com.zhongyu.hu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 *
 * Note:
 * Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function
 * returns 0 when the reversed integer overflows.
 *
 * 思路：模计算获得尾数，存入队列，符号放入字符串，然后取队列头拼字符串，
 * 最后转化为int，try\catch一下超出范围报错时返回0.
 */


public class ReverseInteger {

    public static void main(String args[]){
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-1534236469));
    }

    public int reverse(int x) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean minus = false;
        StringBuffer stringBuffer = new StringBuffer();
        int out = 0;
        System.out.println(x);
        if(x<0){
            minus = true;
            x = x*-1;
            while (x/10>0){
                queue.offer(x%10);
                x=x/10;
            }
        }else{
            while (x/10>0){
                queue.offer(x%10);
                x=x/10;
            }
        }
        queue.offer(x);
        if(minus) stringBuffer.append('-');
        while(queue.peek()!=null){
            stringBuffer.append(queue.poll());
        }
        System.out.println(stringBuffer.toString());
        try{
            out = Integer.parseInt(stringBuffer.toString());
        }catch (Exception e){
            return 0;
        }
        return out;
    }
}
