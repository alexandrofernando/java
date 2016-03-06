package P1716__Integer_Intervals;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Collections;
import java.util.LinkedList;

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
        int n = cin.nextInt();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        for (int i = 0; i < n; i++) {
            int A = cin.nextInt();
            int B = cin.nextInt();
            intervals.add(new Interval(A, B));
        }
        Collections.sort(intervals);
        int distances[] = new int[10002];
        ArrayList<Edge> edges[] = new ArrayList[10002];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Edge>();
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        int max = 0;
        Interval pre = new Interval( -1, -1);
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start > pre.start) {
                edges[interval.end + 1].add(new Edge(interval.start, -2));
                if (interval.end + 1 > max) {
                    max = interval.end + 1;
                }
                set.add(interval.start);
                set.add(interval.end + 1);
            }
        }
        int previous = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext() == true) {
            int node = iterator.next();
            edges[previous].add(new Edge(node, node - previous));
            edges[node].add(new Edge(previous, 0));
            previous = node;
        }
        for (int i = 0; i < max; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        boolean used[] = new boolean[10002];
        distances[max] = 0;
        used[max] = true;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(max);
        while (queue.isEmpty() == false) {
            Integer head = queue.poll();
            used[head] = false;
            for (int i = 0; i < edges[head].size(); i++) {
                Edge edge = edges[head].get(i);
                if (distances[head] != Integer.MAX_VALUE &&
                    distances[edge.end] > distances[head] + edge.weight) {
                    distances[edge.end] = distances[head] + edge.weight;
                    if (used[edge.end] == false) {
                        queue.offer(edge.end);
                        used[edge.end] = true;
                    }
                }
            }
        }
        System.out.println( -distances[0]);
    }
}


class Interval implements Comparable<Interval> {
    int start;
    int end;
    public Interval(int theStart, int theEnd) {
        this.start = theStart;
        this.end = theEnd;
    }

    public int compareTo(Interval another) {
        if (this.start != another.start) {
            return this.start - another.start;
        } else {
            return this.end - another.end;
        }
    }
}


class Edge {
    int end;
    int weight;
    public Edge(int theEnd, int theWeight) {
        this.end = theEnd;
        this.weight = theWeight;
    }
}
