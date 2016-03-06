package P1080__Human_Gene_Functions;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int score[][] = {
            {
            5, -1, -2, -1, -3}, {
            -1, 5, -3, -2, -4}, {
            -2, -3, 5, -2, -2}, {
            -1, -2, -2, 5, -1}, {
            -3, -4, -2, -1, 0}
        };
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            cin.nextInt();
            String gene1 = cin.next();
            cin.nextInt();
            String gene2 = cin.next();
            int max[][] = new int[gene1.length() + 1][gene2.length() + 1];
            for (int i = 0; i < max.length; i++) {
                for (int j = 0; j < max[0].length; j++) {
                    int temp1 = -500, temp2 = -500, temp3 = -500;
                    if (i > 0) {
                        temp1 = max[i - 1][j] +
                            score[index(gene1.charAt(i - 1))][4];
                    }
                    if (j > 0) {
                        temp2 = max[i][j - 1] +
                            score[4][index(gene2.charAt(j - 1))];
                    }
                    if (i > 0 && j > 0) {
                        temp3 = max[i - 1][j - 1] +
                            score[index(gene1.charAt(i - 1))][index(gene2.
                            charAt(j - 1))];
                    }
                    if (i == 0 && j == 0) {
                        max[0][0] = 0;
                    }
                    else {
                        max[i][j] = Math.max(Math.max(temp1, temp2), temp3);
                    }
                }
            }
            System.out.println(max[gene1.length()][gene2.length()]);
        }
    }

    public static int index(char ch) {
        if (ch == 'A') {
            return 0;
        }
        else if (ch == 'C') {
            return 1;
        }
        else if (ch == 'G') {
            return 2;
        }
        else {
            return 3;
        }
    }
}
