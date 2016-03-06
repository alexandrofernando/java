package P1134__Hexagon;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
            int numbers[][] = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    numbers[i][j] = cin.nextInt();
                }
            }
            for (int i = 0; i < 3; i++) {
                Arrays.sort(numbers[i]);
            }
            int factor[][][] = {
                {
                {
                5, 6, 8}, {
                5, 7, 7}, {
                5, 7, 7}
            }, {
                {
                5, 7, 7}, {
                5, 6, 8}, {
                5, 7, 7}
            }, {
                {
                5, 7, 7}, {
                5, 7, 7}, {
                5, 6, 8}
            }
            };
            int maxScore = -1;
            for (int i = 0; i < 3; i++) {
                int score = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        score += numbers[j][k] * factor[i][j][k];
                    }
                }
                if (score > maxScore) {
                    maxScore = score;
                }
            }
            System.out.println("Test #" + t);
            System.out.println(maxScore);
            System.out.println();
        }
    }
}
