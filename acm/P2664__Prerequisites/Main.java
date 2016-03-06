package P2664__Prerequisites;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
            int K = cin.nextInt();
            if (K == 0) {
                break;
            }
            int m = cin.nextInt();
            ArrayList<String> courses = new ArrayList<String>();
            for (int i = 0; i < K; i++) {
                courses.add(cin.next());
            }
            boolean power = true;
            for (int i = 0; i < m; i++) {
                int number = cin.nextInt();
                int least = cin.nextInt();
                int count = 0;
                for (int j = 0; j < number; j++) {
                    if (courses.contains(cin.next()) == true) {
                        count++;
                    }
                }
                if (count < least) {
                    power = false;
                }
            }
            if (power == true) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
