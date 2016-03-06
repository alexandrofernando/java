package P2395__Out_of_Hay;

import java.util.Scanner;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-22
 * Time: 22:52:43
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int lengths[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                lengths[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < M; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int L = in.nextInt();
            lengths[A][B] = Math.min(lengths[A][B], L);
            lengths[B][A] = lengths[A][B];
        }
        int max[] = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            max[i] = Integer.MAX_VALUE;
        }
        boolean visited[] = new boolean[N + 1];
        visited[1] = true;
        PriorityQueue<Road> orderQueue = new PriorityQueue<Road>();
        for (int i = 2; i <= N; i++) {
            if (lengths[1][i] != Integer.MAX_VALUE) {
                orderQueue.offer(new Road(1, i, lengths[1][i]));
            }
        }
        for (int i = 0; i < N - 1; i++) {
            Road road;
            while (true) {
                road = orderQueue.poll();
                if (visited[road.from] == true && visited[road.to] == false) {
                    break;
                }
            }
            max[road.to] = Math.max(max[road.from], road.distance);
            visited[road.to] = true;
            for (int j = 2; j <= N; j++) {
                if (visited[j] == false && lengths[road.to][j] != Integer.MAX_VALUE) {
                    orderQueue.offer(new Road(road.to, j, lengths[road.to][j]));
                }
            }
        }
        int result = 0;
        for (int i = 2; i <= N; i++) {
            if (max[i] > result) {
                result = max[i];
            }
        }
        System.out.println(result);
    }
}

class Road implements Comparable<Road> {
    int from;
    int to;
    int distance;

    public Road(int theFrom, int theTo, int theDistance) {
        this.from = theFrom;
        this.to = theTo;
        this.distance = theDistance;
    }

    public int compareTo(Road another) {
        return this.distance - another.distance;
    }
}