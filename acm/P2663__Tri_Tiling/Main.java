package P2663__Tri_Tiling;

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
        int numbers[][][][] = new int[31][2][2][2];
        numbers[0][0][0][0] = 1;
        for (int i = 1; i <= 30; i++) {
            if (i >= 2) {
                numbers[i][0][0][0] = numbers[i - 2][0][0][0] + numbers[i -
                                      1][0][0][1] + numbers[i - 1][1][0][0];
            }
            numbers[i][0][0][1] = numbers[i - 1][0][0][0];
            if (i >= 3) {
                numbers[i][0][0][1] += numbers[i - 2][0][0][1];
            }
            numbers[i][1][0][0] = numbers[i - 1][0][0][0];
            if (i >= 3) {
                numbers[i][1][0][0] += numbers[i - 2][1][0][0];
            }
        } while (true) {
            int n = cin.nextInt();
            if (n == -1) {
                break;
            }
            System.out.println(numbers[n][0][0][0]);
        }
    }
}
