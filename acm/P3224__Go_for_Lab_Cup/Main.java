package P3224__Go_for_Lab_Cup;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-1
 * Time: 5:11:01
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int winner = 0;
        int max = -1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (in.nextInt() == 3) {
                    count++;
                }
            }
            if (count > max) {
                winner = i;
                max = count;
            }
        }
        System.out.println(winner);
    }
}
