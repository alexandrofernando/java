package P1158__Traffic_Lights;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int source = cin.nextInt();
        int destination = cin.nextInt();
        int N = cin.nextInt();
        int M = cin.nextInt();
        Junction junctions[] = new Junction[N + 1];
        for (int i = 1; i <= N; i++) {
            junctions[i] = new Junction(cin.next().charAt(0), cin.nextInt(),
                                        cin.nextInt(), cin.nextInt());
        }
        for (int i = 0; i < M; i++) {
            int v1 = cin.nextInt();
            int v2 = cin.nextInt();
            int time = cin.nextInt();
            junctions[v1].adjacents.add(new Adjacent(v2, time));
            junctions[v2].adjacents.add(new Adjacent(v1, time));
        }
        boolean visited[] = new boolean[N + 1];
        int min[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> edges = new PriorityQueue<Edge> ();
        edges.add(new Edge(source, 0));
        while (edges.isEmpty() == false) {
            Edge head = edges.poll();
            if (visited[head.to] == false) {
                min[head.to] = head.time;
                visited[head.to] = true;
                if (head.to == destination) {
                    break;
                }
                for (int i = 0; i < junctions[head.to].adjacents.size(); i++) {
                    Adjacent adj = junctions[head.to].adjacents.get(i);
                    if (visited[adj.to] == false) {
                        int spend = nextTime(min[head.to], junctions[head.to],
                                             junctions[adj.to]);
                        if (spend != Integer.MAX_VALUE) {
                            edges.add(new Edge(adj.to, spend + adj.time));
                        }
                    }
                }
            }
        }
        if (min[destination] == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(min[destination]);
        }
    }

    static int nextTime(int curTime, Junction from, Junction to) {
        int light1 = light(curTime, from);
        int light2 = light(curTime, to);
        if (light1 == light2) {
            return curTime;
        }
        int next1 = nextTime(curTime, from.T, from.mods[0], to.T, to.mods[0],
                             to.durations[0]);
        int next2 = nextTime(curTime, to.T, to.mods[0], from.T, from.mods[0],
                             from.durations[0]);
        int next3 = nextTime(curTime, from.T, from.mods[1], to.T, to.mods[1],
                             to.durations[1]);
        int next4 = nextTime(curTime, to.T, to.mods[1], from.T, from.mods[1],
                             from.durations[1]);
        return Math.min(Math.min(next1, next2), Math.min(next3, next4));
    }

    static int light(int curTime, Junction junc) {
        int temp = (curTime - junc.mods[0] + junc.T) % junc.T;
        if (temp >= 0 && temp < junc.durations[0]) {
            return 0;
        }
        else {
            return 1;
        }
    }

    static int nextTime(int curTime, int T1, int mod1, int T2, int mod2,
                        int duration2) {
        int result = (int) Math.ceil( (curTime - mod1) / (double) T1) * T1 +
            mod1;
        for (int i = 0; i < T2; i++) {
            if (isBetween(result % T2, mod2, (mod2 + duration2) % T2) == true) {
                return result;
            }
            result += T1;
        }
        return Integer.MAX_VALUE;
    }

    static boolean isBetween(int number, int bottom, int top) {
        if (top > bottom) {
            if (number >= bottom && number < top) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (number >= top && number < bottom) {
                return false;
            }
            else {
                return true;
            }
        }
    }
}

class Junction {
    int mods[];
    int durations[];
    int T;
    ArrayList<Adjacent> adjacents;
    public Junction(char ch, int remain, int tB, int tP) {
        this.mods = new int[2];
        this.durations = new int[2];
        this.durations[0] = tB;
        this.durations[1] = tP;
        this.T = tB + tP;
        if (ch == 'B') {
            mods[0] = (remain + tP) % this.T;
            mods[1] = remain;
        }
        else if (ch == 'P') {
            mods[0] = remain;
            mods[1] = (remain + tB) % this.T;
        }
        this.adjacents = new ArrayList<Adjacent> ();
    }
}

class Adjacent {
    int to;
    int time;
    public Adjacent(int theTo, int theTime) {
        this.to = theTo;
        this.time = theTime;
    }
}

class Edge
    implements Comparable<Edge> {
    int to;
    int time;
    public Edge(int theTo, int theTime) {
        this.to = theTo;
        this.time = theTime;
    }

    public int compareTo(Edge another) {
        return this.time - another.time;
    }
}
