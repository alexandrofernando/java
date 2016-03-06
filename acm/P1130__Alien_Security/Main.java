package P1130__Alien_Security;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
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
    static int number;
    static int ET;
    static Room rooms[];
    static int tempGuard;
    static boolean find[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        number = cin.nextInt();
        ET = cin.nextInt();
        rooms = new Room[number];
        for (int i = 0; i < number; i++) {
            rooms[i] = new Room();
        }
        while (cin.hasNextInt() == true) {
            int source = cin.nextInt();
            int destination = cin.nextInt();
            rooms[source].to.add(destination);
            rooms[destination].from.add(source);
        }
        int guard = BFS();
        System.out.println("Put guards in room " + guard + ".");
    }

    static int BFS() {
        boolean visited[] = new boolean[number];
        LinkedList<Integer> queue = new LinkedList<Integer> ();
        queue.offer(ET);
        visited[ET] = true;
        while (queue.isEmpty() == false) {
            int vertex = queue.poll();
            if (vertex != ET) {
                find = new boolean[number];
                tempGuard = vertex;
                if (DFS(0) == false) {
                    return vertex;
                }
            }
            for (int i = 0; i < rooms[vertex].from.size(); i++) {
                int one = rooms[vertex].from.get(i);
                if (visited[one] == false) {
                    visited[one] = true;
                    queue.add(one);
                }
            }
        }
        return 0;
    }

    static boolean DFS(int v) {
        if (v == ET) {
            return true;
        }
        if (v == tempGuard) {
            return false;
        }
        find[v] = true;
        for (int i = 0; i < rooms[v].to.size(); i++) {
            int one = rooms[v].to.get(i);
            if (find[one] == false && DFS(one) == true) {
                return true;
            }
        }
        return false;
    }
}

class Room {
    ArrayList<Integer> from;
    ArrayList<Integer> to;
    public Room() {
        this.from = new ArrayList<Integer> ();
        this.to = new ArrayList<Integer> ();
    }
}
