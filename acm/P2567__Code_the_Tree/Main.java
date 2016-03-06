package P2567__Code_the_Tree;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-4-11
 * Time: 23:59:05
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str[] = in.nextLine().split(" ");
            int n = str.length;
            ArrayList<Integer> adjacents[] = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adjacents[i] = new ArrayList<Integer>();
            }
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < n; i++) {
                int pos = str[i].length() - 1;
                int count = 0;
                while (str[i].charAt(pos) == ')') {
                    pos--;
                    count++;
                }
                int node1 = Integer.parseInt(str[i].substring(1, pos + 1));
                if (stack.empty() == false) {
                    int node2 = stack.peek();
                    adjacents[node1].add(node2);
                    adjacents[node2].add(node1);
                }
                stack.push(node1);
                for (int j = 0; j < count; j++) {
                    stack.pop();
                }
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = 1; j <= n; j++) {
                    if (adjacents[j].size() == 1) {
                        if (i != 0) {
                            System.out.print(" ");
                        }
                        int node = adjacents[j].remove(0);
                        System.out.print(node);
                        adjacents[node].remove(new Integer(j));
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}
