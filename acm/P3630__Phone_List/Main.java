package P3630__Phone_List;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-9
 * Time: 21:16:17
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            String phones[] = new String[n];
            for (int i = 0; i < n; i++) {
                phones[i] = in.next();
            }
            Arrays.sort(phones);
            boolean consistent = true;
            for (int i = 1; i < n; i++) {
                if (phones[i].startsWith(phones[i - 1])) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
