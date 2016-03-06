package P1731__Orders;

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
    static int length;
    static int counts[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        String str = cin.next();
        length = str.length();
        counts = new int[26];
        for (int i = 0; i < length; i++) {
            counts[str.charAt(i) - 'a']++;
        }
        search(0, "");
    }

    static void search(int depth, String current) {
        if (depth == length) {
            System.out.println(current);
        } else {
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    counts[i]--;
                    search(depth + 1, current + (char) ('a' + i));
                    counts[i]++;
                }
            }
        }
    }
}
