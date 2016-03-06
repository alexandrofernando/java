package P1797__Heavy_Transportation;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-9
 * Time: 10:33:03
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            int weights[][] = new int[n + 1][];
            for (int i = 1; i <= n; i++) {
                weights[i] = new int[i + 1];
                for (int j = 1; j <= i; j++) {
                    weights[i][j] = -1;
                }
            }
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                int weight = in.nextInt();
                if (start > end) {
                    weights[start][end] = weight;
                } else {
                    weights[end][start] = weight;
                }
            }
            int max[] = new int[n + 1];
            max[1] = 0;
            for (int i = 2; i <= n; i++) {
                max[i] = weights[i][1];
            }
            PriorityQueue<Crossing> order = new PriorityQueue<Crossing>();
            for (int i = 2; i <= n; i++) {
                order.offer(new Crossing(i, max[i]));
            }
            while (true) {
                Crossing head = order.poll();
                if (head.index == n) {
                    break;
                }
                PriorityQueue<Crossing> temp = new PriorityQueue<Crossing>();
                while (order.isEmpty() == false) {
                    Crossing crossing = order.poll();
                    int weight;
                    if (head.index > crossing.index) {
                        weight = weights[head.index][crossing.index];
                    } else {
                        weight = weights[crossing.index][head.index];
                    }
                    max[crossing.index] = Math.max(crossing.currentMax, Math.min(head.currentMax, weight));
                    temp.offer(new Crossing(crossing.index, max[crossing.index]));
                }
                order = temp;
            }
            System.out.println("Scenario #" + t + ":");
            System.out.println(max[n]);
            System.out.println();
        }
    }
}

class Crossing implements Comparable<Crossing> {
    int index;
    int currentMax;

    public Crossing(int theIndex, int theCurrentMax) {
        this.index = theIndex;
        this.currentMax = theCurrentMax;
    }

    public int compareTo(Crossing another) {
        return another.currentMax - this.currentMax;
    }
}