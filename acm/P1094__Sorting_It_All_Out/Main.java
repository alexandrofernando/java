package P1094__Sorting_It_All_Out;

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
    static int n;
    static boolean matrix[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        int m = cin.nextInt();
        while (n != 0 || m != 0) {
            matrix = new boolean[n][n];
            boolean consistent = true;
            boolean determined = false;
            for (int i = 1; i <= m; i++) {
                String relation = cin.next();
                if (consistent == true && determined == false) {
                    int less = relation.charAt(0) - 'A';
                    int more = relation.charAt(2) - 'A';
                    matrix[less][more] = true;
                    transmit();
                    for (int j = 0; j < n; j++) {
                        if (matrix[j][j] == true) {
                            consistent = false;
                            break;
                        }
                    }
                    if (consistent == false) {
                        System.out.println("Inconsistency found after " + i +
                                           " relations.");
                    }
                    else {
                        determined = true;
                        for (int j = 0; j < n; j++) {
                            for (int k = j + 1; k < n; k++) {
                                if (matrix[j][k] == false && matrix[k][j] == false) {
                                    determined = false;
                                    break;
                                }
                            }
                            if (determined == false) {
                                break;
                            }
                        }
                        if (determined == true) {
                            int result[] = new int[n];
                            for (int j = 0; j < n; j++) {
                                int order = n - 1;
                                for (int k = 0; k < n; k++) {
                                    if (matrix[j][k] == true) {
                                        order--;
                                    }
                                }
                                result[order] = j;
                            }
                            System.out.print(
                                "Sorted sequence determined after " +
                                i + " relations: ");
                            for (int j = 0; j < n; j++) {
                                System.out.print( (char) ('A' + result[j]));
                            }
                            System.out.println(".");
                        }
                    }
                }
            }
            if (consistent == true && determined == false) {
                System.out.println("Sorted sequence cannot be determined.");
            }
            n = cin.nextInt();
            m = cin.nextInt();
        }
    }

    static void transmit() {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == true) {
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = matrix[i][k] || matrix[j][k];
                    }
                }
            }
        }
    }
}
