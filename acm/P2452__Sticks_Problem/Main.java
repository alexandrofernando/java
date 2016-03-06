package P2452__Sticks_Problem;

import java.util.Scanner;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-17
 * Time: 6:53:14
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int lengths[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int n = in.nextInt();
            lengths = new int[n];
            for (int i = 0; i < n; i++) {
                lengths[i] = in.nextInt();
            }
            PriorityQueue<Interval> intervals = new PriorityQueue<Interval>();
            if (n >= 2) {
                intervals.offer(new Interval(0, n - 1));
            }
            int result = -1;
            while (intervals.isEmpty() == false) {
                Interval head = intervals.poll();
                int minIndex = head.begin;
                int maxIndex = head.begin;
                for (int i = head.begin + 1; i <= head.end; i++) {
                    if (lengths[i] < lengths[minIndex]) {
                        minIndex = i;
                    }
                    if (lengths[i] > lengths[maxIndex]) {
                        maxIndex = i;
                    }
                }
                if (head.begin == minIndex && head.end == maxIndex) {
                    result = maxIndex - minIndex;
                    break;
                }
                int pos1 = minIndex;
                while (pos1 > head.begin && lengths[pos1 - 1] > lengths[pos1]) {
                    pos1--;
                }
                int pos2 = maxIndex;
                while (pos2 < head.end && lengths[pos2] > lengths[pos2 + 1]) {
                    pos2++;
                }
                if (minIndex < maxIndex) {
                    if (head.begin < pos1) {
                        intervals.offer(new Interval(head.begin, pos1));
                    }
                    if (minIndex < maxIndex) {
                        intervals.offer(new Interval(minIndex, maxIndex));
                    }
                    if (pos2 < head.end) {
                        intervals.offer(new Interval(pos2, head.end));
                    }
                } else {
                    if (head.begin < maxIndex) {
                        intervals.offer(new Interval(head.begin, maxIndex));
                    }
                    if (pos2 < pos1) {
                        intervals.offer(new Interval(pos2, pos1));
                    }
                    if (minIndex < head.end) {
                        intervals.offer(new Interval(minIndex, head.end));
                    }
                }
            }
            System.out.println(result);
        }
    }
}

class Interval implements Comparable<Interval> {
    int begin;
    int end;

    public Interval(int theBegin, int theEnd) {
        this.begin = theBegin;
        this.end = theEnd;
    }

    public int compareTo(Interval another) {
        return (another.end - another.begin) - (this.end - this.begin);
    }
}