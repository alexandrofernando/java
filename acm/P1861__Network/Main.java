package P1861__Network;

import java.util.Scanner;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-10
 * Time: 19:04:20
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Hub hubs[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        hubs = new Hub[N + 1];
        for (int i = 1; i <= N; i++) {
            hubs[i] = new Hub(i);
        }
        PriorityQueue<Connection> order = new PriorityQueue<Connection>();
        for (int i = 0; i < M; i++) {
            order.offer(new Connection(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        int max = -1;
        int count = 0;
        StringBuffer buffer = new StringBuffer();
        while (true) {
            Connection connection = order.poll();
            int root1 = searchRoot(connection.start);
            int root2 = searchRoot(connection.end);
            if (root1 != root2) {
                hubs[root1].parent = root2;
                buffer.append(connection.start + " " + connection.end + "\n");
                if (connection.length > max) {
                    max = connection.length;
                }
                count++;
                if (count == N - 1) {
                    break;
                }
            }
        }
        System.out.println(max);
        System.out.println(count);
        System.out.println(buffer);
    }

    static int searchRoot(int node) {
        int root = node;
        while (hubs[root].parent != -1) {
            root = hubs[root].parent;
        }
        while (node != root) {
            int temp = hubs[node].parent;
            hubs[node].parent = root;
            node = temp;
        }
        return root;
    }
}

class Connection implements Comparable<Connection> {
    int start;
    int end;
    int length;

    public Connection(int theStart, int theEnd, int theLength) {
        this.start = theStart;
        this.end = theEnd;
        this.length = theLength;
    }

    public int compareTo(Connection another) {
        return this.length - another.length;
    }
}

class Hub {
    int index;
    int parent;

    public Hub(int theIndex) {
        this.index = theIndex;
        this.parent = -1;
    }
}