package P1125__Stockbroker_Grapevine;

import java.util.Scanner;
import java.io.File;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            int distance[][] = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        distance[i][j] = 0;
                    }
                    else {
                        distance[i][j] = -1;
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                int number = cin.nextInt();
                for (int j = 0; j < number; j++) {
                    int end = cin.nextInt();
                    int time = cin.nextInt();
                    distance[i][end] = time;
                }
            }
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if ( (distance[i][k] >= 0 && distance[k][j] >= 0) &&
                            (distance[i][j] < 0 ||
                             distance[i][k] + distance[k][j] < distance[i][j])) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }
                    }
                }
            }
            int start = -1;
            int minTime = 0;
            for (int i = 1; i <= n; i++) {
                boolean power = true;
                int max = 0;
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] < 0) {
                        power = false;
                        break;
                    }
                    if (distance[i][j] > max) {
                        max = distance[i][j];
                    }
                }
                if (power == true && (start == -1 || max < minTime)) {
                    start = i;
                    minTime = max;
                }
            }
            if (start == -1) {
                System.out.println("disjoint");
            }
            else {
                System.out.println(start + " " + minTime);
            }
        }
        while (true);
    }
}
