package P1247__Magnificent_Meatballs;

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
        while (true) {
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            int meatballs[] = new int[N + 1];
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                meatballs[i] = cin.nextInt();
                sum += meatballs[i];
            }
            boolean possible = false;
            int temp = 0;
            for (int i = 1; i <= N; i++) {
                temp += meatballs[i];
                if (temp * 2 == sum) {
                    System.out.println("Sam stops at position " + i +
                                       " and Ella stops at position " + (i + 1) +
                                       ".");
                    possible = true;
                    break;
                } else if (temp * 2 > sum) {
                    break;
                }
            }
            if (possible == false) {
                System.out.println("No equal partitioning.");
            }
        }
    }
}
