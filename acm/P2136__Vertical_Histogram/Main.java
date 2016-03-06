package P2136__Vertical_Histogram;

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
        int counts[] = new int[26];
        while (cin.hasNext() == true) {
            String str = cin.next();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    counts[str.charAt(i) - 'A']++;
                }
            }
        }
        int height = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > height) {
                height = counts[i];
            }
        }
        for (int i = height; i >= 1; i--) {
            double previous = -0.5;
            for (int j = 0; j < 26; j++) {
                if (counts[j] >= i) {
                    for (int k = 0; k < (j - previous) * 2 - 1; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    previous = j;
                }
            }
            System.out.println();
        }
        for (int i = 0; i < 26; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print( (char) ('A' + i));
        }
        System.out.println();
    }
}
