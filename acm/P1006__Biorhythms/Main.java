package P1006__Biorhythms;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        int P = cin.nextInt();
        int E = cin.nextInt();
        int I = cin.nextInt();
        int D = cin.nextInt();
        while (P != -1 || E != -1 || I != -1 || D != -1) {
            int peak = 33 - (D - I) % 33;
            if (peak >= 33) {
                peak -= 33;
            }
            while ( (peak + D - P) % 23 != 0 || (peak + D - E) % 28 != 0) {
                peak += 33;
            }
            if (peak == 0) {
                peak = 21252;
            }
            System.out.println("Case " + test +
                               ": the next triple peak occurs in " + peak +
                               " days.");
            P = cin.nextInt();
            E = cin.nextInt();
            I = cin.nextInt();
            D = cin.nextInt();
            test++;
        }
    }
}
