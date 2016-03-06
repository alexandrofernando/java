package P2681__Anagrammatic_Distance;

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
        cin.nextLine();
        for (int t = 1; t <= test; t++) {
            String a = cin.nextLine();
            String b = cin.nextLine();
            int counts1[] = statistic(a);
            int counts2[] = statistic(b);
            int result = 0;
            for (int i = 0; i < 26; i++) {
                result += Math.abs(counts1[i] - counts2[i]);
            }
            System.out.println("Case #" + t + ":  " + result);
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
