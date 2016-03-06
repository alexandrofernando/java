package P2253__Frogger;

import java.util.Scanner;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-15
 * Time: 4:36:31
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = 1;
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            Stone stones[] = new Stone[n];
            for (int i = 0; i < n; i++) {
                stones[i] = new Stone(in.nextInt(), in.nextInt());
            }
            PriorityQueue<Element> orderQueue = new PriorityQueue<Element>();
            orderQueue.offer(new Element(0, 0, 0));
            while (true) {
                Element head = orderQueue.poll();
                if (stones[head.to].visited == true) {
                    continue;
                }
                if (head.to == 0) {
                    stones[0].minDistance = 0;
                    stones[0].visited = true;
                } else {
                    stones[head.to].minDistance = Math.max(stones[head.from].minDistance, head.distance);
                    if (head.to == 1) {
                        break;
                    }
                    stones[head.to].visited = true;
                }
                for (int i = 1; i < n; i++) {
                    if (stones[i].visited == false) {
                        int x1 = stones[head.to].x;
                        int y1 = stones[head.to].y;
                        int x2 = stones[i].x;
                        int y2 = stones[i].y;
                        double temp = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                        orderQueue.offer(new Element(head.to, i, temp));
                    }
                }
            }
            System.out.println("Scenario #" + test);
            test++;
            System.out.printf("Frog Distance = %.3f\n", stones[1].minDistance);
            System.out.println();
        }
    }
}

class Stone {
    int x;
    int y;
    boolean visited;
    double minDistance;

    public Stone(int X, int Y) {
        this.x = X;
        this.y = Y;
        this.visited = false;
    }
}

class Element implements Comparable<Element> {
    int from;
    int to;
    double distance;

    public Element(int theFrom, int theTo, double theDistance) {
        this.from = theFrom;
        this.to = theTo;
        this.distance = theDistance;
    }

    public int compareTo(Element another) {
        if (this.distance < another.distance) {
            return -1;
        } else if (this.distance > another.distance) {
            return 1;
        } else {
            return 0;
        }
    }
}