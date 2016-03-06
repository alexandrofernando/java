package P1650__Integer_Approximation;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-16
 * Time: 0:00:20
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        int L = in.nextInt();
        int N = L;
        int D = 1;
        double error = Math.abs(L - A);
        for (int i = 1; i <= L; i++) {
            int temp = (int) Math.floor(i * A);
            if (temp > L) {
                break;
            }
            if (Math.abs((double) temp / i - A) < error) {
                N = temp;
                D = i;
                error = Math.abs((double) temp / i - A);
            }
            if (temp + 1 <= L && Math.abs((double) (temp + 1) / i - A) < error) {
                N = temp + 1;
                D = i;
                error = Math.abs((double) (temp + 1) / i - A);
            }
        }
        System.out.println(N + " " + D);
    }
}
