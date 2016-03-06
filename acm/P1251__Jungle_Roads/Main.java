package P1251__Jungle_Roads;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-31
 * Time: 5:35:25
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int parents[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            ArrayList<Road> roads = new ArrayList<Road>();
            for (int i = 0; i < n - 1; i++) {
                in.next();
                int K = in.nextInt();
                for (int j = 0; j < K; j++) {
                    String str = in.next();
                    int cost = in.nextInt();
                    int index = str.charAt(0) - 'A';
                    roads.add(new Road(i, index, cost));
                }
            }
            Collections.sort(roads);
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = -1;
            }
            int total = 0;
            int pos = 0;
            for (int i = 0; i < n - 1; i++) {
                Road road;
                int root1;
                int root2;
                do {
                    road = roads.get(pos);
                    pos++;
                    root1 = searchRoot(road.v1);
                    root2 = searchRoot(road.v2);
                } while (root1 == root2);
                parents[root1] = root2;
                total += road.cost;
            }
            System.out.println(total);
        }
    }

    static int searchRoot(int v) {
        while (parents[v] != -1) {
            v = parents[v];
        }
        return v;
    }
}

class Road implements Comparable<Road> {
    int v1;
    int v2;
    int cost;

    public Road(int V1, int V2, int theCost) {
        this.v1 = V1;
        this.v2 = V2;
        this.cost = theCost;
    }

    public int compareTo(Road another) {
        return this.cost - another.cost;
    }
}
