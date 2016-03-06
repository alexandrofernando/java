package P3518__Prime_Gap;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-4-20
 * Time: 16:28:49
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int number = in.nextInt();
            if (number == 0) {
                break;
            }
            int top = number;
            while (isPrime(top) == false) {
                top++;
            }
            int bottom = number;
            while (isPrime(bottom) == false) {
                bottom--;
            }
            System.out.println(top - bottom);
        }
    }

    static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
