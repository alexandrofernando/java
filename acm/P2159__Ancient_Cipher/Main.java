package P2159__Ancient_Cipher;

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
        String str1 = cin.next();
        int counts1[] = statistic(str1);
        String str2 = cin.next();
        int counts2[] = statistic(str2);
        boolean possible = true;
        for (int i = 1; i < counts1.length; i++) {
            if (counts1[i] != counts2[i]) {
                possible = false;
                break;
            }
        }
        if (possible == true) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    static int[] statistic(String str) {
        int letters[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            letters[str.charAt(i) - 'A']++;
        }
        int counts[] = new int[105];
        for (int i = 0; i < 26; i++) {
            if (letters[i] > 0) {
                counts[letters[i]]++;
            }
        }
        return counts;
    }
}
