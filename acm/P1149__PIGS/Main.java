package P1149__PIGS;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-24
 * Time: 8:31:41
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int infite = 1000000000;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int pigs[] = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            pigs[i] = in.nextInt();
        }
        int houses[] = new int[M + 1];
        int capacity[][] = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            int A = in.nextInt();
            for (int j = 0; j < A; j++) {
                int K = in.nextInt();
                if (houses[K] == 0) {
                    capacity[0][i] += pigs[K];
                } else {
                    capacity[houses[K]][i] = infite;
                }
                houses[K] = i;
            }
            int B = in.nextInt();
            capacity[i][N + 1] += B;
        }
        int result = 0;
        while (true) {
            int previous[] = new int[N + 2];
            for (int i = 0; i < N + 2; i++) {
                previous[i] = -1;
            }
            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.offer(0);
            previous[0] = 0;
            boolean find = false;
            while (queue.isEmpty() == false) {
                int head = queue.poll();
                if (head == N + 1) {
                    int temp = head;
                    int min = Integer.MAX_VALUE;
                    while (temp != 0) {
                        int pre = previous[temp];
                        if (capacity[pre][temp] < min) {
                            min = capacity[pre][temp];
                        }
                        temp = pre;
                    }
                    temp = head;
                    while (temp != 0) {
                        int pre = previous[temp];
                        capacity[pre][temp] -= min;
                        capacity[temp][pre] += min;
                        temp = pre;
                    }
                    result += min;
                    find = true;
                    break;
                } else {
                    for (int i = 0; i < N + 2; i++) {
                        if (previous[i] == -1 && capacity[head][i] > 0) {
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
