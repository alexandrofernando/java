package P2654__Rock_Paper_Scissors_Tournament;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-22
 * Time: 22:21:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = stdin.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            int K = Integer.parseInt(st.nextToken());
            int matches[] = new int[n + 1];
            int wins[] = new int[n + 1];
            for (int i = 0; i < K * n * (n - 1) / 2; i++) {
                line = stdin.readLine();
                st = new StringTokenizer(line);
                int p1 = Integer.parseInt(st.nextToken());
                String m1 = st.nextToken();
                int p2 = Integer.parseInt(st.nextToken());
                String m2 = st.nextToken();
                if (m1.equals("rock") == true && m2.equals("scissors") == true) {
                    matches[p1]++;
                    matches[p2]++;
                    wins[p1]++;
                } else if (m1.equals("rock") == true && m2.equals("paper") == true) {
                    matches[p1]++;
                    matches[p2]++;
                    wins[p2]++;
                } else if (m1.equals("scissors") == true && m2.equals("rock") == true) {
                    matches[p1]++;
                    matches[p2]++;
                    wins[p2]++;
                } else if (m1.equals("scissors") == true && m2.equals("paper") == true) {
                    matches[p1]++;
                    matches[p2]++;
                    wins[p1]++;
                } else if (m1.equals("paper") == true && m2.equals("rock") == true) {
                    matches[p1]++;
                    matches[p2]++;
                    wins[p1]++;
                } else if (m1.equals("paper") == true && m2.equals("scissors") == true) {
                    matches[p1]++;
                    matches[p2]++;
                    wins[p2]++;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (matches[i] == 0) {
                    System.out.println("-");
                } else {
                    System.out.printf("%.3f\n", (double) wins[i] / matches[i]);
                }
            }
            System.out.println();
        }
    }
}
