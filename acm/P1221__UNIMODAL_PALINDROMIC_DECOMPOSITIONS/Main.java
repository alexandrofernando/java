package P1221__UNIMODAL_PALINDROMIC_DECOMPOSITIONS;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-8
 * Time: 4:50:47
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static final int size = 500;

    public static void main(String args[]) {
        long previous2[] = new long[size];
        long previous1[] = new long[size];
        for (int i = 0; i < size; i++) {
            previous2[i] = 1;
            if (i % 2 == 0) {
                previous1[i] = 1;
            }
        }
        for (int i = 3; i < size; i++) {
            long current[] = new long[size];
            for (int j = 0; j < size; j++) {
                current[j] = previous2[j];
                if (j >= i) {
                    current[j] += current[j - i];
                }
            }
            previous2 = previous1;
            previous1 = current;
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(n + " " + (previous1[n] + previous2[n]));
        }
    }
}
