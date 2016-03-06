package P1166__The_Clocks;

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
        int states[] = new int[9];
        for (int i = 0; i < 9; i++) {
            states[i] = cin.nextInt();
        }
        int number = 30;
        int counts[] = new int[10];
        int types[] = new int[10];
        for (types[1] = 0; types[1] < 4; types[1]++) {
            for (types[2] = 0; types[2] < 4; types[2]++) {
                for (types[3] = 0; types[3] < 4; types[3]++) {
                    for (types[4] = 0; types[4] < 4; types[4]++) {
                        for (types[5] = 0; types[5] < 4; types[5]++) {
                            for (types[6] = 0; types[6] < 4; types[6]++) {
                                for (types[7] = 0; types[7] < 4; types[7]++) {
                                    for (types[8] = 0; types[8] < 4; types[8]++) {
                                        for (types[9] = 0; types[9] < 4;
                                             types[9]++) {
                                            if (types[1] + types[2] + types[3] +
                                                types[4] + types[5] + types[6] +
                                                types[7] + types[8] + types[9] >=
                                                number) {
                                                continue;
                                            }
                                            if ( (states[0] + types[1] +
                                                  types[2] + types[4]) % 4 != 0) {
                                                continue;
                                            }
                                            if ( (states[1] + types[1] +
                                                  types[2] + types[3] + types[5]) %
                                                4 != 0) {
                                                continue;
                                            }
                                            if ( (states[2] + types[2] +
                                                  types[3] + types[6]) % 4 != 0) {
                                                continue;
                                            }
                                            if ( (states[3] + types[1] +
                                                  types[4] + types[5] + types[7]) %
                                                4 != 0) {
                                                continue;
                                            }
                                            if ( (states[4] + types[1] +
                                                  types[3] + types[5] + types[7] +
                                                  types[9]) % 4 != 0) {
                                                continue;
                                            }
                                            if ( (states[5] + types[3] +
                                                  types[5] + types[6] + types[9]) %
                                                4 != 0) {
                                                continue;
                                            }
                                            if ( (states[6] + types[4] +
                                                  types[7] + types[8]) % 4 != 0) {
                                                continue;
                                            }
                                            if ( (states[7] + types[5] +
                                                  types[7] + types[8] + types[9]) %
                                                4 != 0) {
                                                continue;
                                            }
                                            if ( (states[8] + types[6] +
                                                  types[8] + types[9]) % 4 != 0) {
                                                continue;
                                            }
                                            for (int i = 1; i <= 9; i++) {
                                                counts[i] = types[i];
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (counts[i] != 0) {
                for (int j = 0; j < counts[i]; j++) {
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }
}
