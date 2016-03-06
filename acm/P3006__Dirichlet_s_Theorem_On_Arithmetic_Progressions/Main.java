package P3006__Dirichlet_s_Theorem_On_Arithmetic_Progressions;

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
        while (true) {
            int A = cin.nextInt();
            int D = cin.nextInt();
            int N = cin.nextInt();
            if (A == 0 && D == 0 && N == 0) {
                break;
            }
            int count = 0;
            while (count < N) {
                boolean isPrime = true;
                for (int i = 2; i * i <= A; i++) {
                    if (A % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (A != 1 && isPrime == true) {
                    count++;
                }
                A += D;
            }
            System.out.println(A - D);
        }
    }
}
