package P1330__Nearest_Common_Ancestors;

import java.util.Scanner;
import java.io.File;
import java.util.Stack;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = cin.nextInt();
            int parents[] = new int[N + 1];
            for (int i = 0; i < N - 1; i++) {
                int parent = cin.nextInt();
                int child = cin.nextInt();
                parents[child] = parent;
            }
            int node1 = cin.nextInt();
            int node2 = cin.nextInt();
            Stack<Integer> path1 = new Stack<Integer>();
            Stack<Integer> path2 = new Stack<Integer>();
            while (node1 != 0) {
                path1.push(node1);
                node1 = parents[node1];
            } while (node2 != 0) {
                path2.push(node2);
                node2 = parents[node2];
            }
            int result = 0;
            while (path1.empty() == false && path2.empty() == false) {
                int head1 = path1.pop();
                int head2 = path2.pop();
                if (head1 == head2) {
                    result = head1;
                }
            }
            System.out.println(result);
        }
    }
}
