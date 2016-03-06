package P1161__Walls;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

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
        int M = cin.nextInt();
        int N = cin.nextInt();
        boolean isStart[] = new boolean[N + 1];
        int L = cin.nextInt();
        for (int i = 0; i < L; i++) {
            isStart[cin.nextInt()] = true;
        }
        Region regions[] = new Region[M + 1];
        for (int i = 1; i <= M; i++) {
            regions[i] = new Region(N + 1);
        }
        LinkedList<Element> queue = new LinkedList<Element> ();
        TreeMap<Wall, Integer> walls = new TreeMap<Wall, Integer> ();
        for (int i = 1; i <= M; i++) {
            int number = cin.nextInt();
            int temp[] = new int[number];
            for (int j = 0; j < number; j++) {
                temp[j] = cin.nextInt();
                if (isStart[temp[j]] == true) {
                    queue.offer(new Element(temp[j], i, 0));
                }
            }
            for (int j = 0; j < number; j++) {
                int t0 = temp[j];
                int t1 = temp[ (j + 1) % number];
                Wall w = new Wall(t1, t0);
                if (walls.containsKey(w) == true) {
                    int index = walls.get(w);
                    regions[i].adjacent.add(index);
                    regions[index].adjacent.add(i);
                    walls.remove(w);
                }
                else {
                    walls.put(new Wall(t0, t1), i);
                }
            }
        }
        while (queue.isEmpty() == false) {
            Element head = queue.poll();
            Region reg = regions[head.region];
            if (reg.reach[head.start] == false) {
                reg.reach[head.start] = true;
                reg.totalDistance += head.distance;
                for (int i = 0; i < reg.adjacent.size(); i++) {
                    queue.offer(new Element(head.start, reg.adjacent.get(i),
                                            head.distance + 1));
                }
            }
        }
        int min = regions[1].totalDistance;
        for (int i = 2; i <= M; i++) {
            if (regions[i].totalDistance < min) {
                min = regions[i].totalDistance;
            }
        }
        System.out.println(min);
    }
}

class Region {
    ArrayList<Integer> adjacent;
    int totalDistance;
    boolean reach[];
    public Region(int size) {
        this.adjacent = new ArrayList<Integer> ();
        this.totalDistance = 0;
        this.reach = new boolean[size];
    }
}

class Wall
    implements Comparable<Wall> {
    int town0;
    int town1;
    public Wall(int t0, int t1) {
        this.town0 = t0;
        this.town1 = t1;
    }

    public int compareTo(Wall another) {
        if (this.town0 != another.town0) {
            return this.town0 - another.town0;
        }
        else {
            return this.town1 - another.town1;
        }
    }

    public boolean equals(Object another) {
        Wall a = (Wall) another;
        if (this.town0 == a.town0 && this.town1 == a.town1) {
            return true;
        }
        else {
            return false;
        }
    }
}

class Element {
    int start;
    int region;
    int distance;
    public Element(int theStart, int theRegion, int theDistance) {
        this.start = theStart;
        this.region = theRegion;
        this.distance = theDistance;
    }
}
