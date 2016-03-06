package P2236__Wireless_Network;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-15
 * Time: 21:36:49
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Computer computers[];

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int D = in.nextInt();
        computers = new Computer[N + 1];
        boolean adjacents[][] = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            computers[i] = new Computer(in.nextInt(), in.nextInt());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int x1 = computers[i].x;
                int y1 = computers[i].y;
                int x2 = computers[j].x;
                int y2 = computers[j].y;
                if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= D * D) {
                    adjacents[i][j] = true;
                    adjacents[j][i] = true;
                }
            }
        }
        int repairNumber = 0;
        int repairs[] = new int[N];
        while (in.hasNext() == true) {
            String str = in.next();
            if (str.equals("O") == true) {
                int index = in.nextInt();
                if (computers[index].status == false) {
                    computers[index].status = true;
                    repairs[repairNumber] = index;
                    for (int i = 0; i < repairNumber; i++) {
                        if (adjacents[index][repairs[i]] == true) {
                            int root = searchRoot(repairs[i]);
                            if (root != index) {
                                computers[root].parent = index;
                            }
                        }
                    }
                    repairNumber++;
                }
            } else if (str.equals("S") == true) {
                int index1 = in.nextInt();
                int index2 = in.nextInt();
                if (computers[index1].status == false || computers[index2].status == false) {
                    System.out.println("FAIL");
                } else {
                    int root1 = searchRoot(index1);
                    int root2 = searchRoot(index2);
                    if (root1 == root2) {
                        System.out.println("SUCCESS");
                    } else {
                        System.out.println("FAIL");
                    }
                }
            }
        }
    }

    static int searchRoot(int node) {
        int root = node;
        while (computers[root].parent != -1) {
            root = computers[root].parent;
        }
        int temp = node;
        while (computers[temp].parent != -1) {
            int temp1 = computers[temp].parent;
            computers[temp].parent = root;
            temp = temp1;
        }
        return root;
    }
}

class Computer {
    boolean status;
    int x;
    int y;
    int parent;

    public Computer(int X, int Y) {
        this.status = false;
        this.x = X;
        this.y = Y;
        this.parent = -1;
    }
}