package P1989__The_Cow_Lineup;

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
        int N = cin.nextInt();
        int K = cin.nextInt();
        boolean appears[] = new boolean[K + 1];
        int result = 1;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int number = cin.nextInt();
            if (appears[number] == false) {
                appears[number] = true;
                count++;
                if (count == K) {
                    count = 0;
                    appears = new boolean[K + 1];
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
