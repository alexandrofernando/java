package P2229__Sumsets;

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
        if (N == 1) {
            System.out.println(1);
        } else {
            int numbers[] = new int[N + 1];
            numbers[1] = 1;
            numbers[2] = 2;
            for (int i = 3; i <= N; i++) {
                if (i % 2 == 0) {
                    numbers[i] = (numbers[i - 2] + numbers[i / 2]) % 1000000000;
                } else {
                    numbers[i] = numbers[i - 1];
                }
            }
            System.out.println(numbers[N]);
        }
    }
}
