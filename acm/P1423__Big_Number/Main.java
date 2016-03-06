package P1423__Big_Number;

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
        int numbers[] = new int[10000001];
        int digitNum = 1;
        double d = 1;
        for (int i = 1; i <= 10000000; i++) {
            int num;
            double d1;
            if (i < 10) {
                num = 0;
                d1 = i;
            } else if (i < 100) {
                num = 1;
                d1 = i / 10.0;
            } else if (i < 1000) {
                num = 2;
                d1 = i / 100.0;
            } else if (i < 10000) {
                num = 3;
                d1 = i / 1000.0;
            } else if (i < 100000) {
                num = 4;
                d1 = i / 10000.0;
            } else if (i < 1000000) {
                num = 5;
                d1 = i / 100000.0;
            } else if (i < 10000000) {
                num = 6;
                d1 = i / 1000000.0;
            } else {
                num = 7;
                d1 = i / 10000000.0;
            }
            digitNum += num;
            d *= d1;
            if (d > 10) {
                d /= 10;
                digitNum++;
            }
            numbers[i] = digitNum;
        }
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int m = cin.nextInt();
            System.out.println(numbers[m]);
        }
    }
}
