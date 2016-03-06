package P3665__iCow;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-9
 * Time: 21:40:43
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        int rates[] = new int[N];
        for (int i = 0; i < rates.length; i++) {
            rates[i] = in.nextInt();
        }
        for (int i = 0; i < T; i++) {
            int maxIndex = 0;
            for (int j = 1; j < N; j++) {
                if (rates[j] > rates[maxIndex]) {
                    maxIndex = j;
                }
            }
            System.out.println(maxIndex + 1);
            if (N > 1) {
                int evenPart = rates[maxIndex] / (N - 1);
                int extraNumber = rates[maxIndex] % (N - 1);
                for (int j = 0; j < N; j++) {
                    if (j != maxIndex) {
                        rates[j] += evenPart;
                        if (extraNumber > 0) {
                            rates[j]++;
                            extraNumber--;
                        }
                    }
                }
                rates[maxIndex] = 0;
            }
        }
    }
}
