package P2769__Reduced_ID_Numbers;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int G = cin.nextInt();
            int SIN[] = new int[G];
            for (int i = 0; i < G; i++) {
                SIN[i] = cin.nextInt();
            }
            for (int m = G; ; m++) {
                boolean isUnique = true;
                boolean used[] = new boolean[m];
                for (int i = 0; i < G; i++) {
                    int temp = SIN[i] % m;
                    if (used[temp] == true) {
                        isUnique = false;
                        break;
                    } else {
                        used[temp] = true;
                    }
                }
                if (isUnique == true) {
                    System.out.println(m);
                    break;
                }
            }
        }
    }
}
