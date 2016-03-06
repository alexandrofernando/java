package P1091__Flea;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.math.BigDecimal;

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
    static int N;
    static ArrayList<Long> primeDivisor;
    static BigDecimal result;
    static long sign;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        N = cin.nextInt();
        long M = cin.nextLong();
        ArrayList<Long> prime = new ArrayList<Long> ();
        primeDivisor = new ArrayList<Long> ();
        long number = 2;
        long temp = M;
        while (number * number <= temp) {
            boolean power = true;
            for (int i = 0; i < prime.size(); i++) {
                if (number % prime.get(i) == 0) {
                    power = false;
                    break;
                }
            }
            if (power == true) {
                prime.add(number);
                if (temp % number == 0) {
                    primeDivisor.add(number);
                    while (temp % number == 0) {
                        temp /= number;
                    }
                }
            }
            if (number != 2) {
                number += 2;
            }
            else {
                number = 3;
            }
        }
        if (temp != 1) {
            primeDivisor.add(temp);
        }
        result = new BigDecimal(M).pow(N);
        sign = -1;
        for (int i = 1; i <= primeDivisor.size(); i++) {
            search(M, 0, 0, i, primeDivisor.size());
            sign = -sign;
        }
        System.out.println(result);
    }

    static void search(long current, int index, int selected, int target,
                       int size) {
        if (selected == target) {
            BigDecimal temp = new BigDecimal(current).pow(N).multiply(new
                BigDecimal(sign));
            result = result.add(temp);
        }
        else if (index + target - selected <= size) {
            search(current, index + 1, selected, target, size);
            search(current / primeDivisor.get(index), index + 1, selected + 1,
                   target, size);
        }
    }
}
