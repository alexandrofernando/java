package P1041__John_s_Trip;

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
    static PriorityQueue<Integer> junctions[];
    static Street streets[];
    static ArrayList<Integer> trip;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            int x = cin.nextInt();
            int y = cin.nextInt();
            if (x == 0 && y == 0) {
                break;
            }
            junctions = new PriorityQueue[45];
            streets = new Street[2000];
            int junctionNumber = 0;
            while (x != 0 || y != 0) {
                if (x > junctionNumber) {
                    junctionNumber = x;
                }
                if (y > junctionNumber) {
                    junctionNumber = y;
                }
                if (junctions[x] == null) {
                    junctions[x] = new PriorityQueue<Integer> ();
                }
                if (junctions[y] == null) {
                    junctions[y] = new PriorityQueue<Integer> ();
                }
                int z = cin.nextInt();
                junctions[x].offer(z);
                junctions[y].offer(z);
                streets[z] = new Street(x, y);
                x = cin.nextInt();
                y = cin.nextInt();
            }
            boolean power = true;
            for (int i = 1; i <= junctionNumber; i++) {
                if (junctions[i].size() % 2 == 1) {
                    power = false;
                    break;
                }
            }
            if (power == false) {
                System.out.println("Round trip does not exist.");
            }
            else {
                trip = new ArrayList<Integer> ();
                search(1);
                for (int i = trip.size() - 1; i >= 0; i--) {
                    if (i != 0) {
                        System.out.print(trip.get(i) + " ");
                    }
                    else {
                        System.out.println(trip.get(i));
                    }
                }
            }
        }
        while (true);
    }

    static void search(int pointIndex) {
        while (junctions[pointIndex].isEmpty() == false) {
            int one = junctions[pointIndex].poll();
            junctions[streets[one].p1].remove(one);
            junctions[streets[one].p2].remove(one);
            if (streets[one].p1 == pointIndex) {
                search(streets[one].p2);
            }
            else {
                search(streets[one].p1);
            }
            trip.add(one);
        }
    }
}

class Street {
    int p1;
    int p2;
    public Street(int P1, int P2) {
        this.p1 = P1;
        this.p2 = P2;
    }
}
