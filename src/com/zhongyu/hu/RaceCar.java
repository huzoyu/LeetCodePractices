package com.zhongyu.hu;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 818. Race Car
 *
 * Your car starts at position 0 and speed +1 on an infinite number line.
 * (Your car can go into negative positions.)
 *
 * Your car drives automatically according to a sequence of instructions
 * A (accelerate) and R (reverse).
 *
 * When you get an instruction "A", your car does the following:
 * position += speed, speed *= 2.
 *
 * When you get an instruction "R", your car does the following:
 * if your speed is positive then speed = -1 , otherwise speed = 1.
 * (Your position stays the same.)
 *
 * For example, after commands "AAR", your car goes to positions 0->1->3->3,
 * and your speed goes to 1->2->4->-1.
 *
 * Now for some target position, say the length of the shortest sequence of
 * instructions to get there.
 *
 * Example 1:
 * Input:
 * target = 3
 * Output: 2
 * Explanation:
 * The shortest instruction sequence is "AA".
 * Your position goes from 0->1->3.
 * Example 2:
 * Input:
 * target = 6
 * Output: 5
 * Explanation:
 * The shortest instruction sequence is "AAARA".
 * Your position goes from 0->1->3->7->7->6.
 *
 *
 * Note:
 *
 * 1 <= target <= 10000.
 */


public class RaceCar {

    private static class PS{
        //Position and Speed
        int position;
        int speed;
        int step;
        boolean positive;


        PS(int position, int speed, int step, boolean positive) {
            this.position = position;
            this.speed = speed;
            this.step = step;
            this.positive = positive;
        }
        PS doA(){
            int add = 1<<speed;
            if(!positive) add = -add;
            return new PS(position+add,speed+1,step+1,positive);
        }
        PS doR(){
            return new PS(position,0,step+1,!positive);
        }
    }
    public int racecar(int target) {
        int nt = -target;
        int t2 = 2*target;

        boolean [][] v = new boolean[28][3*target];//[speed][position]

        Queue<PS> q = new LinkedList<>();
        q.add(new PS(0,0,0,true));
        int iSpeed,iPosition;
        while(true){
            PS ps = q.remove();
            if(ps.position>=t2||ps.position<=nt||ps.speed>=14) continue;
            iSpeed = ps.speed + (ps.positive?14:0);
            iPosition = ps.position + target;
            if(v[iSpeed][iPosition]) continue;
            else v[iSpeed][iPosition] = true;
            PS psA = ps.doA();
            if(psA.position==target) return psA.step;
            q.add(psA);
            q.add(ps.doR());
        }
    }
}
