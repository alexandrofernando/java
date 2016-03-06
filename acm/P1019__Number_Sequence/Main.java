package P1019__Number_Sequence;

import java.util.Scanner;
import java.io.File;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            int rest = 0;
            if (n <= 45) {
                int s = (int) Math.floor( ( -1 + Math.sqrt(1 + 8 * n)) / 2);
                if (s * s + s - 2 * n == 0) {
                    s--;
                }
                rest = n - (s + s * (s - 1) / 2);
            }
            else {
                n -= 45;
                if (n <= 9000) {
                    int s = (int) Math.floor( -5 + Math.sqrt(25 + n));
                    if (s * s + 10 * s - n == 0) {
                        s--;
                    }
                    rest = n - (s * s + 10 * s);
                }
                else {
                    n -= 9000;
                    if (n <= 1386450) {
                        int s = (int) Math.floor( ( -381 +
                            Math.sqrt(145161 + 24 * n)) / 6);
                        if (3 * s * s + 381 * s - 2 * n == 0) {
                            s--;
                        }
                        rest = n - (192 * s + s * (s - 1) / 2 * 3);
                    }
                    else {
                        n -= 1386450;
                        if (n <= 188019000) {
                            int s = (int) Math.floor( ( -2891 +
                                Math.sqrt(8357881 + 8 * n)) / 4);
                            if (2 * s * s + 2891 * s - n == 0) {
                                s--;
                            }
                            rest = n - (2 * s * s + 2891 * s);
                        }
                        else {
                            n -= 188019000;
                            int s = (int) Math.floor( ( -77783 +
                                Math.sqrt(Math.pow(77783, 2) + 40.0 * n)) / 10);
                            if (5 * s * s + 77783 * s - 2 * n == 0) {
                                s--;
                            }
                            rest = n - (38894 * s + s * (s - 1) / 2 * 5);
                        }
                    }
                }
            }
            System.out.println(count(rest));
        }
    }

    static int count(int number) {
        if (number <= 9) {
            return number;
        }
        number -= 9;
        if (number <= 180) {
            int temp = 10 + (number - 1) / 2;
            return select(temp, (number - 1) % 2, 2);
        }
        number -= 180;
        if (number <= 2700) {
            int temp = 100 + (number - 1) / 3;
            return select(temp, (number - 1) % 3, 3);
        }
        number -= 2700;
        if (number <= 36000) {
            int temp = 1000 + (number - 1) / 4;
            return select(temp, (number - 1) % 4, 4);
        }
        number -= 36000;
        int temp = 10000 + (number - 1) / 5;
        return select(temp, (number - 1) % 5, 5);
    }

    static int select(int a, int pos, int size) {
        return a / (int) Math.pow(10, size - pos - 1) % 10;
    }
}
