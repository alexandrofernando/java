package P1775__Sum_Of_Factorials;

import java.util.Scanner;
import java.io.File;
import java.util.TreeSet;

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
        TreeSet<Integer> numbers = new TreeSet<Integer>();
        int factorials[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        int number = 0;
        for (int a0 = 0; a0 < 2; a0++) {
            number += a0 * factorials[0];
            for (int a1 = 0; a1 < 2; a1++) {
                number += a1 * factorials[1];
                for (int a2 = 0; a2 < 2; a2++) {
                    number += a2 * factorials[2];
                    for (int a3 = 0; a3 < 2; a3++) {
                        number += a3 * factorials[3];
                        for (int a4 = 0; a4 < 2; a4++) {
                            number += a4 * factorials[4];
                            for (int a5 = 0; a5 < 2; a5++) {
                                number += a5 * factorials[5];
                                for (int a6 = 0; a6 < 2; a6++) {
                                    number += a6 * factorials[6];
                                    for (int a7 = 0; a7 < 2; a7++) {
                                        number += a7 * factorials[7];
                                        for (int a8 = 0; a8 < 2; a8++) {
                                            number += a8 * factorials[8];
                                            for (int a9 = 0; a9 < 2; a9++) {
                                                number += a9 * factorials[9];
                                                numbers.add(number);
                                                number -= a9 * factorials[9];
                                            }
                                            number -= a8 * factorials[8];
                                        }
                                        number -= a7 * factorials[7];
                                    }
                                    number -= a6 * factorials[6];
                                }
                                number -= a5 * factorials[5];
                            }
                            number -= a4 * factorials[4];
                        }
                        number -= a3 * factorials[3];
                    }
                    number -= a2 * factorials[2];
                }
                number -= a1 * factorials[1];
            }
            number -= a0 * factorials[0];
        } while (true) {
            int n = cin.nextInt();
            if (n < 0) {
                break;
            }
            if (n != 0 && numbers.contains(n) == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
