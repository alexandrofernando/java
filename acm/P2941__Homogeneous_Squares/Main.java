package P2941__Homogeneous_Squares;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-5
 * Time: 8:23:55
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
            int square[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                line = stdin.readLine();
                st = new StringTokenizer(line);
                for (int j = 0; j < n; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean homogeneous = true;
            for (int i = 0; i < n - 1; i++) {
                int temp = square[i][0] - square[i + 1][0];
                for (int j = 1; j < n; j++) {
                    if (square[i][j] - square[i + 1][j] != temp) {
                        homogeneous = false;
                        break;
                    }
                }
                if (homogeneous == false) {
                    break;
                }
            }
            if (homogeneous == true) {
                for (int j = 0; j < n - 1; j++) {
                    int temp = square[0][j] - square[0][j + 1];
                    for (int i = 1; i < n; i++) {
                        if (square[i][j] - square[i][j + 1] != temp) {
                            homogeneous = false;
                            break;
                        }
                    }
                    if (homogeneous == false) {
                        break;
                    }
                }
            }
            if (homogeneous == true) {
                System.out.println("homogeneous");
            } else {
                System.out.println("not homogeneous");
            }
        }
    }
}
