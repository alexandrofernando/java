package P1458__Common_Subsequence;

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
        while (cin.hasNext() == true) {
            String str1 = cin.next();
            String str2 = cin.next();
            int length1 = str1.length();
            int length2 = str2.length();
            int max[][] = new int[length1 + 1][length2 + 1];
            for (int i = 1; i <= length1; i++) {
                for (int j = 1; j < length2 + 1; j++) {
                    char ch1 = str1.charAt(i - 1);
                    char ch2 = str2.charAt(j - 1);
                    if (ch1 == ch2) {
                        max[i][j] = max[i - 1][j - 1] + 1;
                    } else if (max[i - 1][j] > max[i][j - 1]) {
                        max[i][j] = max[i - 1][j];
                    } else {
                        max[i][j] = max[i][j - 1];
                    }
                }
            }
            System.out.println(max[length1][length2]);
        }
    }
}
