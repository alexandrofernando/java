package P3310__Caterpillar;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-2
 * Time: 0:52:01
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = 1;
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int e = in.nextInt();
            boolean caterpillar = true;
            if (n - 1 != e) {
                caterpillar = false;
            }
            ArrayList<Integer> nodes[] = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < e; i++) {
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                if (caterpillar == true) {
                    nodes[n1].add(n2);
                    nodes[n2].add(n1);
                }
            }
            if (caterpillar == true) {
                for (int i = 1; i <= n; i++) {
                    if (nodes[i].size() == 0) {
                        caterpillar = false;
                        break;
                    }
                }
                if (caterpillar == true) {
                    boolean used[] = new boolean[n + 1];
                    for (int i = 1; i <= n; i++) {
                        if (used[i] == false && nodes[i].size() == 1) {
                            int node = nodes[i].get(0);
                            nodes[i].remove(0);
                            nodes[node].remove(new Integer(i));
                            used[i] = true;
                            used[node] = true;
                        }
                    }
                    for (int i = 1; i <= n; i++) {
                        if (nodes[i].size() > 2) {
                            caterpillar = false;
                            break;
                        }
                    }
                }
            }
            if (caterpillar == true) {
                System.out.println("Graph " + test + " is a caterpillar.");
            } else {
                System.out.println("Graph " + test + " is not a caterpillar.");
            }
            test++;
        }
    }
}
