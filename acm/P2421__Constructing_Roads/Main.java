package P2421__Constructing_Roads;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
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
    static int parents[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int distances[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                distances[i][j] = cin.nextInt();
            }
        }
        parents = new int[N + 1];
        ArrayList<ArrayList<Integer>>
                connects = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            ArrayList<Integer> s = new ArrayList<Integer>();
            s.add(i);
            connects.add(s);
        }
        int Q = cin.nextInt();
        for (int i = 0; i < Q; i++) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int headA = head(a);
            int headB = head(b);
            if (headA != headB) {
                ArrayList<Integer> connectA = connects.get(headA);
                ArrayList<Integer> connectB = connects.get(headB);
                connectA.addAll(connectB);
                connects.set(headB, null);
                parents[headB] = headA;
                parents[b] = headA;
            }
        }
        int start = head(1);
        boolean used[] = new boolean[N + 1];
        for (int i = 0; i < connects.get(start).size(); i++) {
            used[connects.get(start).get(i)] = true;
        }
        PriorityQueue<Road> order = new PriorityQueue<Road>();
        for (int i = 1; i <= N; i++) {
            if (used[i] == true) {
                for (int j = 1; j <= N; j++) {
                    if (used[j] == false) {
                        order.offer(new Road(i, j, distances[i][j]));
                    }
                }
            }
        }
        ArrayList<Integer> heads = new ArrayList<Integer>();
        for (int i = 1; i <= N; i++) {
            if (i != start && parents[i] == 0) {
                heads.add(i);
            }
        }
        int total = 0;
        while (heads.isEmpty() == false) {
            Road first;
            do {
                first = order.poll();
            } while (used[first.v2] == true);
            int h = head(first.v2);
            total += first.length;
            for (int i = 0; i < connects.get(h).size(); i++) {
                used[connects.get(h).get(i)] = true;
            }
            for (int i = 0; i < connects.get(h).size(); i++) {
                int v1 = connects.get(h).get(i);
                for (int j = 1; j <= N; j++) {
                    if (used[j] == false) {
                        order.offer(new Road(v1, j, distances[v1][j]));
                    }
                }
            }
            connects.set(h, null);
            heads.remove(new Integer(h));
        }
        System.out.println(total);
    }

    static int head(int p) {
        int h = p;
        while (parents[h] != 0) {
            h = parents[h];
        }
        if (p != h) {
            parents[p] = h;
        }
        return h;
    }
}


class Road implements Comparable<Road> {
    int v1;
    int v2;
    int length;
    public Road(int V1, int V2, int theLength) {
        this.v1 = V1;
        this.v2 = V2;
        this.length = theLength;
    }

    public int compareTo(Road another) {
        return this.length - another.length;
    }
}
