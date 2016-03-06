package P2485__Highways;

import java.util.Scanner;
import java.io.File;
import java.util.PriorityQueue;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = cin.nextInt();
            int distances[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distances[i][j] = cin.nextInt();
                }
            }
            boolean used[] = new boolean[N];
            PriorityQueue<Highway> order = new PriorityQueue<Highway>();
            used[0] = true;
            for (int i = 1; i < N; i++) {
                order.offer(new Highway(0, i, distances[0][i]));
            }
            int longest = Integer.MIN_VALUE;
            for (int i = 0; i < N - 1; i++) {
                Highway head;
                do {
                    head = order.poll();
                } while (used[head.v2] == true);
                if (head.length > longest) {
                    longest = head.length;
                }
                used[head.v2] = true;
                for (int j = 0; j < N; j++) {
                    if (used[j] == false) {
                        order.offer(new Highway(head.v2, j,
                                                distances[head.v2][j]));
                    }
                }
            }
            System.out.println(longest);
        }
    }
}


class Highway implements Comparable<Highway> {
    int v1;
    int v2;
    int length;
    public Highway(int V1, int V2, int theLength) {
        this.v1 = V1;
        this.v2 = V2;
        this.length = theLength;
    }

    public int compareTo(Highway another) {
        return this.length - another.length;
    }
}
