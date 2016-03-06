package P1055__Bulk_Mailing;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
        int zipCodeCounts[] = new int[100000];
        ArrayList<String> invalid = new ArrayList<String> ();
        while (cin.hasNext() == true) {
            String temp = cin.next();
            if (check(temp) == true) {
                zipCodeCounts[Integer.parseInt(temp)]++;
            }
            else if (invalid.contains(temp) == false) {
                invalid.add(temp);
            }
        }
        int totalLetter = 0;
        int totalBundle = 0;
        System.out.println("ZIP         LETTERS     BUNDLES");
        System.out.println();
        for (int i = 0; i < zipCodeCounts.length; i++) {
            if (zipCodeCounts[i] >= 10) {
                int bundles;
                if (zipCodeCounts[i] % 15 == 0) {
                    bundles = zipCodeCounts[i] / 15;
                }
                else {
                    bundles = zipCodeCounts[i] / 15 + 1;
                }
                System.out.printf("%05d%12d%12d\n", i, zipCodeCounts[i],
                                  bundles);
                totalLetter += zipCodeCounts[i];
                totalBundle += bundles;
                zipCodeCounts[i] = 0;
            }
        }
        System.out.println();
        for (int i = 0; i < 1000; i++) {
            int count = 0;
            for (int j = 0; j < 100; j++) {
                count += zipCodeCounts[i * 100 + j];
            }
            if (count >= 10) {
                int bundles;
                if (count % 15 == 0) {
                    bundles = count / 15;
                }
                else {
                    bundles = count / 15 + 1;
                }
                System.out.printf("%03dxx%12d%12d\n", i, count, bundles);
                for (int j = 0; j < 100; j++) {
                    zipCodeCounts[i * 100 + j] = 0;
                }
                totalLetter += count;
                totalBundle += bundles;
            }
        }
        System.out.println();
        for (int i = 0; i < zipCodeCounts.length; i++) {
            if (zipCodeCounts[i] > 0) {
                System.out.printf("%05d%12d%12d\n", i, zipCodeCounts[i], 0);
                totalLetter += zipCodeCounts[i];
            }
        }
        System.out.println();
        System.out.printf("TOTALS%11d%12d\n", totalLetter, totalBundle);
        System.out.println();
        System.out.println("INVALID ZIP CODES");
        System.out.println();
        for (int i = 0; i < invalid.size(); i++) {
            System.out.println(invalid.get(i));
        }
    }

    static boolean check(String code) {
        if (code.length() != 5) {
            return false;
        }
        boolean power = false;
        for (int i = 0; i < 5; i++) {
            char ch = code.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
            if (ch != '0') {
                power = true;
            }
        }
        return power;
    }
}
