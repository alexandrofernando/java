package P2661__Factstone_Benchmark;

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
            int year = cin.nextInt();
            if (year == 0) {
                break;
            }
            int digitNum = (int) Math.round(Math.pow(2, year / 10 - 194));
            int rating = 0;
            double number = 0;
            while (Math.ceil(number) <= digitNum) {
                rating++;
                number += Math.log(rating) / Math.log(2);
            }
            rating--;
            System.out.println(rating);
        }
    }
}
