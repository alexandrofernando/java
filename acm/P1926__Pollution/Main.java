package P1926__Pollution;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
            int M = cin.nextInt();
            double amounts[] = new double[N + 1];
            for (int i = 1; i <= N; i++) {
                amounts[i] = cin.nextDouble();
            }
            int degrees[] = new int[N + 1];
            boolean adjacents[][] = new boolean[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                int A = cin.nextInt();
                int B = cin.nextInt();
                adjacents[A][B] = true;
                adjacents[B][A] = true;
                degrees[A]++;
                degrees[B]++;
            }
            double results[] = new double[N + 1];
            boolean visited[] = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (visited[i] == false) {
                    ArrayList<Integer> queue = new ArrayList<Integer>();
                    visited[i] = true;
                    queue.add(i);
                    int head = 0;
                    int tail = 1;
                    double totalAmount = amounts[i];
                    int totalDegree = degrees[i];
                    while (head < tail) {
                        int index = queue.get(head);
                        for (int j = 1; j <= N; j++) {
                            if (visited[j] == false && adjacents[index][j] == true) {
                                visited[j] = true;
                                queue.add(j);
                                tail++;
                                totalAmount += amounts[j];
                                totalDegree += degrees[j];
                            }
                        }
                        head++;
                    }
                    for (int j = 0; j < queue.size(); j++) {
                        int index = queue.get(j);
                        if (totalDegree != 0) {
                            results[index] = (double) totalAmount / totalDegree *
                                             degrees[index];
                        } else {
                            results[index] = amounts[index];
                        }
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                System.out.printf("%.3f\n", results[i]);
            }
            System.out.println();
        }
    }
}
