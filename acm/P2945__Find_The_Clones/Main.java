package P2945__Find_The_Clones;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
        while (true) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            String sequences[] = new String[n];
            for (int i = 0; i < n; i++) {
                sequences[i] = cin.next();
            }
            Arrays.sort(sequences);
            int counts[] = new int[n];
            int counter = 0;
            for (int i = 1; i < n; i++) {
                if (sequences[i].compareTo(sequences[i - 1]) == 0) {
                    counter++;
                } else {
                    counts[counter]++;
                    counter = 0;
                }
            }
            counts[counter]++;
            for (int i = 0; i < n; i++) {
                System.out.println(counts[i]);
            }
        }
    }
}
