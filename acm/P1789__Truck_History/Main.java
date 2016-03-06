package P1789__Truck_History;

import java.util.Scanner;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-15
 * Time: 0:54:41
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            if (N == 0) {
                break;
            }
            String codes[] = new String[N];
            for (int i = 0; i < N; i++) {
                codes[i] = in.next();
            }
            int distances[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distances[i][j] = countDiff(codes[i], codes[j]);
                }
            }
            boolean used[] = new boolean[N];
            int min[] = new int[N];
            for (int i = 0; i < N; i++) {
                min[i] = Integer.MAX_VALUE;
            }
            PriorityQueue<Element> queue = new PriorityQueue<Element>();
            int sum = 0;
            int index = 0;
            for (int i = 0; i < N - 1; i++) {
                used[index] = true;
                for (int j = 0; j < N; j++) {
                    if (!used[j] && distances[index][j] < min[j]) {
                        queue.offer(new Element(distances[index][j], j));
                        min[j] = distances[index][j];
                    }
                }
                Element head;
                do {
                    head = queue.poll();
                } while (used[head.to]);
                index = head.to;
                sum += head.distance;
            }
            System.out.println("The highest possible quality is 1/" + sum + ".");
        }
    }

    static int countDiff(String a, String b) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}

class Element implements Comparable<Element> {
    int distance;
    int to;

    Element(int theDistance, int theTo) {
        this.distance = theDistance;
        this.to = theTo;
    }

    public int compareTo(Element another) {
        return this.distance - another.distance;
    }
}