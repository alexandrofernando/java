package P1201__Intervals;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-18
 * Time: 19:06:42
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int distances[] = new int[50005];
        Edge edges[] = new Edge[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            b++;
            int c = in.nextInt();
            edges[i] = new Edge(a, b, c);
            if (a < min) {
                min = a;
            }
            if (b > max) {
                max = b;
            }
        }
        for (int i = min + 1; i <= max; i++) {
            distances[i] = Integer.MIN_VALUE;
        }
        boolean change = true;
        while (change == true) {
            change = false;
            for (int i = 0; i < n; i++) {
                if (distances[edges[i].from] != Integer.MIN_VALUE && distances[edges[i].from] + edges[i].weight > distances[edges[i].to]) {
                    distances[edges[i].to] = distances[edges[i].from] + edges[i].weight;
                    change = true;
                }
            }
            for (int i = min; i < max; i++) {
                if (distances[i] != Integer.MIN_VALUE && distances[i] > distances[i + 1]) {
                    distances[i + 1] = distances[i];
                    change = true;
                }
            }
            for (int i = max; i > min; i--) {
                if (distances[i] != Integer.MIN_VALUE && distances[i] - 1 > distances[i - 1]) {
                    distances[i - 1] = distances[i] - 1;
                    change = true;
                }
            }
        }
        System.out.println(distances[max]);
    }
}

class Edge {
    int from;
    int to;
    int weight;

    public Edge(int theFrom, int theTo, int theWeight) {
        this.from = theFrom;
        this.to = theTo;
        this.weight = theWeight;
    }
}