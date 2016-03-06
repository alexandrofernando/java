package P2419__Forests;

import java.util.Scanner;
import java.io.File;

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
        int P = cin.nextInt();
        int T = cin.nextInt();
        boolean hear[][] = new boolean[P][T];
        while (cin.hasNextInt() == true) {
            hear[cin.nextInt() - 1][cin.nextInt() - 1] = true;
        }
        boolean same[] = new boolean[P];
        int opinion = 0;
        for (int i = 0; i < P; i++) {
            if (same[i] == false) {
                opinion++;
                for (int j = i + 1; j < P; j++) {
                    if (same[j] == false) {
                        boolean power = true;
                        for (int k = 0; k < T; k++) {
                            if (hear[i][k] != hear[j][k]) {
                                power = false;
                                break;
                            }
                        }
                        if (power == true) {
                            same[j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(opinion);
    }
}
