package P1142__Smith_Numbers;

import java.util.Scanner;

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
        do {
            int number = cin.nextInt();
            if (number == 0) {
                break;
            }
            do {
                number++;
                if (check(number) == true) {
                    System.out.println(number);
                    break;
                }
            }
            while (true);
        }
        while (true);
    }

    static boolean check(int number) {
        int sum1 = digitSum(number);
        int sum2 = 0;
        int divisor = 2;
        boolean isPrime = true;
        for (int i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                isPrime = false;
                sum2 += digitSum(i);
                if (sum2 > sum1) {
                    return false;
                }
                number /= i;
            }
        }
        if (isPrime == true) {
            return false;
        }
        if (number != 1) {
            sum2 += digitSum(number);
        }
        if (sum1 == sum2) {
            return true;
        }
        else {
            return false;
        }
    }

    static int digitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
