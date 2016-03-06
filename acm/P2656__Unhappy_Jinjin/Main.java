package P2656__Unhappy_Jinjin;

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
        do {
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            int result = 0;
            int max = 0;
            for (int i = 1; i <= N; i++) {
                int school = cin.nextInt();
                int supply = cin.nextInt();
                int temp = school + supply - 8;
                if (temp > 0 && temp > max) {
                    max = temp;
                    result = i;
                }
            }
            System.out.println(result);
        }
        while (true);
    }
}
