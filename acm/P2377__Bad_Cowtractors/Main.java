package P2377__Bad_Cowtractors;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-1-19
 * Time: 22:30:50
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Barn barns[] = new Barn[N + 1];
        for (int i = 1; i <= N; i++) {
            barns[i] = new Barn();
        }
        for (int i = 0; i < M; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            barns[A].connections.add(new Connection(B, C));
            barns[B].connections.add(new Connection(A, C));
        }
        boolean connect = true;
        int total = 0;
        PriorityQueue<Connection> order = new PriorityQueue<Connection>();
        barns[1].visited = true;
        for (int i = 0; i < barns[1].connections.size(); i++) {
            order.offer(barns[1].connections.get(i));
        }
        for (int i = 0; i < N - 1; i++) {
            Connection first = null;
            while (order.isEmpty() == false) {
                first = order.poll();
                if (barns[first.end].visited == false) {
                    break;
                }
                first = null;
            }
            if (first == null) {
                connect = false;
                break;
            }
            total += first.cost;
            barns[first.end].visited = true;
            for (int j = 0; j < barns[first.end].connections.size(); j++) {
                order.offer(barns[first.end].connections.get(j));
            }
        }
        if (connect == true) {
            System.out.println(total);
        } else {
            System.out.println("-1");
        }
    }
}

class Barn {
    boolean visited;
    ArrayList<Connection> connections;

    public Barn() {
        this.connections = new ArrayList<Connection>();
        this.visited = false;
    }
}

class Connection implements Comparable<Connection> {
    int end;
    int cost;

    public Connection(int theEnd, int theCost) {
        this.end = theEnd;
        this.cost = theCost;
    }

    public int compareTo(Connection another) {
        return another.cost - this.cost;
    }
}