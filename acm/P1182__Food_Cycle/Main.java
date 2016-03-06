package P1182__Food_Cycle;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;

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
    static int fathers[];
    static int relations[];
    public static void main(String[] args) throws Exception {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String line = cin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        fathers = new int[N + 1];
        relations = new int[N + 1];
        int K = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < K; i++) {
            line = cin.readLine();
            st = new StringTokenizer(line);
            int D = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if (X > N || Y > N || (D == 2 && X == Y)) {
                result++;
            }
            else {
                if (D == 1 && X == Y) {
                    continue;
                }
                else {
                    int root1 = findRoot(X);
                    int root2 = findRoot(Y);
                    if (root1 == root2) {
                        if ( (D == 1 && relations[X] != relations[Y]) ||
                            (D == 2 && (relations[X] + 1) % 3 != relations[Y])) {
                            result++;
                        }
                    }
                    else {
                        fathers[root2] = root1;
                        if (D == 1) {
                            relations[root2] = (relations[X] - relations[Y] + 3) %
                                3;
                        }
                        else if (D == 2) {
                            relations[root2] = (relations[X] - relations[Y] + 4) %
                                3;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    static int findRoot(int p) {
        if (fathers[p] == 0) {
            return p;
        }
        else {
            int root = findRoot(fathers[p]);
            relations[p] = (relations[p] + relations[fathers[p]]) % 3;
            fathers[p] = root;
            return root;
        }
    }
}
