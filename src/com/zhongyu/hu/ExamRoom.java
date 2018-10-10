package com.zhongyu.hu;

/**
 *
 * 855. Exam Room
 *
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 *
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.
 * If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room,
 * then the student sits at seat number 0.)
 *
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing
 * what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p
 * now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.
 *
 *
 *
 * Example 1:
 *
 * Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student​​​​​​​ sits at the last seat number 5.
 * ​​​​​​​
 *
 * Note:
 *
 * 1 <= N <= 10^9
 * ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
 * Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 */
import java.awt.Point;
import java.util.TreeSet;

public class ExamRoom {

    private int N;
    private TreeSet<Integer> seats = new TreeSet<>();
    private TreeSet<Point> pq = new TreeSet<>(
            (Point p1, Point p2) -> {
                int d1 = getDistance(p1);
                int d2 = getDistance(p2);
                if (d1 == d2) {
                    return p1.x - p2.x;
                }
                return d2 - d1;
            });

    public ExamRoom(int N) {
        this.N = N;
        seats.add(-1);
        seats.add(N);
        pq.add(new Point(-1, N));
    }

    private int getDistance(Point p) {
        int mid = getMid(p.x, p.y);
        if (p.x < 0) {
            return p.y - mid;
        } else if (p.y == this.N) {
            return mid - p.x;
        }
        return Math.min(p.y - mid, mid - p.x);
    }

    private int getMid(int left, int right) {
        if (left < 0) return 0;
        if (right == this.N) return this.N - 1;
        return (left + right) / 2;
    }

    public int seat() {
        Point p = pq.pollFirst();
        int left = p.x, right = p.y;
        int mid = getMid(left, right);
        seats.add(mid);
        pq.add(new Point(left, mid));
        pq.add(new Point(mid, right));
        return mid;
    }

    public void leave(int p) {
        int left = seats.lower(p);
        int right = seats.higher(p);
        seats.remove(p);
        pq.remove(new Point(left, p));
        pq.remove(new Point(p, right));
        pq.add(new Point(left, right));
    }
}


/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */