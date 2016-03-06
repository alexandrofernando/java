package P2629__Common_Permutation;

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
        while (cin.hasNextLine() == true) {
            String a = cin.nextLine();
            int counts1[] = statistic(a);
            String b = cin.nextLine();
            int counts2[] = statistic(b);
            for (int i = 0; i < 26; i++) {
                int top = Math.min(counts1[i], counts2[i]);
                for (int j = 0; j < top; j++) {
                    System.out.print((char) ('a' + i));
                }
            }
            System.out.println();
        }
    }

    static int[] statistic(String str) {
        int counts[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }
        return counts;
    }
}
