package P2470__Ambiguous_Permutations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.
                in));
        while (true) {
            String line = stdin.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            int permutation[] = new int[n + 1];
            line = stdin.readLine();
            st = new StringTokenizer(line);
            for (int i = 1; i <= n; i++) {
                permutation[i] = Integer.parseInt(st.nextToken());
            }
            boolean ambiguous = true;
            for (int i = 1; i <= n; i++) {
                if (permutation[permutation[i]] != i) {
                    ambiguous = false;
                    break;
                }
            }
            if (ambiguous == true) {
                System.out.println("ambiguous");
            } else {
                System.out.println("not ambiguous");
            }
        }
    }
}
