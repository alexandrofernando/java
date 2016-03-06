package P1243__One_Person;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-29
 * Time: 22:30:03
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        int results[][] = new int[31][31];
        for (int i = 0; i < 31; i++) {
            results[1][i] = 1;
        }
        for (int i = 2; i < 31; i++) {
            results[i][0] = i;
            for (int j = 1; j < 31; j++) {
                results[i][j] = results[i - 1][j] + results[i - 1][j - 1] + 1;
            }
        }
        Scanner in = new Scanner(System.in);
        int test = 1;
        while (true) {
            int G = in.nextInt();
            int L = in.nextInt();
            if (G == 0 && L == 0) {
                break;
            }
            System.out.println("Case " + test + ": " + results[G][L]);
            test++;
        }
    }
}
