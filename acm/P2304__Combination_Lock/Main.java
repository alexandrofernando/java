package P2304__Combination_Lock;

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
            int initial = cin.nextInt();
            int number1 = cin.nextInt();
            int number2 = cin.nextInt();
            int number3 = cin.nextInt();
            if (initial == 0 && number1 == 0 && number2 == 0 && number3 == 0) {
                break;
            }
            int total = 0;
            int temp = initial - number1;
            if (temp < 0) {
                temp += 40;
            }
            total += temp;
            temp = number2 - number1;
            if (temp < 0) {
                temp += 40;
            }
            total += temp;
            temp = number2 - number3;
            if (temp < 0) {
                temp += 40;
            }
            total += temp;
            total += 120;
            total *= 9;
            System.out.println(total);
        }
    }
}
