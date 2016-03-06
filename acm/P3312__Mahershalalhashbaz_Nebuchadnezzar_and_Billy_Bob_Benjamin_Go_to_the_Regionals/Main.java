package P3312__Mahershalalhashbaz_Nebuchadnezzar_and_Billy_Bob_Benjamin_Go_to_the_Regionals;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-17
 * Time: 1:02:12
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = 1;
        while (true) {
            if (test != 1) {
                System.out.println();
            }
            int n = in.nextInt();
            int K = in.nextInt();
            if (n == 0 && K == 0) {
                break;
            }
            int lengths[] = new int[n];
            for (int i = 0; i < n; i++) {
                lengths[i] = in.next().length();
            }
            Arrays.sort(lengths);
            boolean possible = true;
            for (int i = 0; i < n; i += K) {
                int sum = 0;
                for (int j = i; j < i + K; j++) {
                    sum += lengths[j];
                }
                if ((lengths[i] + 2) * K < sum || (lengths[i + K - 1] - 2) * K > sum) {
                    possible = false;
                    break;
                }
            }
            if (possible == true) {
                System.out.println("Case " + test + ": yes");
            } else {
                System.out.println("Case " + test + ": no");
            }
            test++;
        }
    }
}
