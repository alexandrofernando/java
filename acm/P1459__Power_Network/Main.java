package P1459__Power_Network;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-23
 * Time: 2:11:01
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int n = in.nextInt();
            int np = in.nextInt();
            int nc = in.nextInt();
            int m = in.nextInt();
            int capacity[][] = new int[n + 2][n + 2];
            for (int i = 0; i < m; i++) {
                String str = in.next();
                int index1 = str.indexOf(',');
                int index2 = str.indexOf(')');
                int from = Integer.parseInt(str.substring(1, index1));
                int to = Integer.parseInt(str.substring(index1 + 1, index2));
                int value = Integer.parseInt(str.substring(index2 + 1));
                capacity[from][to] += value;
            }
            for (int i = 0; i < np; i++) {
                String str = in.next();
                int index = str.indexOf(')');
                int to = Integer.parseInt(str.substring(1, index));
                int value = Integer.parseInt(str.substring(index + 1));
                capacity[n][to] = value;
            }
            for (int i = 0; i < nc; i++) {
                String str = in.next();
                int index = str.indexOf(')');
                int from = Integer.parseInt(str.substring(1, index));
                int value = Integer.parseInt(str.substring(index + 1));
                capacity[from][n + 1] = value;
            }
            int result = 0;
            while (true) {
                int previous[] = new int[n + 2];
                for (int i = 0; i < n + 2; i++) {
                    previous[i] = -1;
                }
                LinkedList<Integer> queue = new LinkedList<Integer>();
                queue.offer(n);
                previous[n] = n;
                boolean find = false;
                while (queue.isEmpty() == false) {
                    int head = queue.poll();
                    if (head == n + 1) {
                        int temp = head;
                        int min = Integer.MAX_VALUE;
                        while (temp != n) {
                            int pre = previous[temp];
                            if (capacity[pre][temp] < min) {
                                min = capacity[pre][temp];
                            }
                            temp = pre;
                        }
                        temp = head;
                        while (temp != n) {
                            int pre = previous[temp];
                            capacity[pre][temp] -= min;
                            capacity[temp][pre] += min;
                            temp = pre;
                        }
                        result += min;
                        find = true;
                        break;
                    } else {
                        for (int i = 0; i < n + 2; i++) {
                            if (i != head && previous[i] == -1 && capacity[head][i] > 0) {
                                previous[i] = head;
                                queue.offer(i);
                            }
                        }
                    }
                }
                if (find == false) {
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
