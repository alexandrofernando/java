package P3356__AGTC;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-23
 * Time: 22:57:16
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int lengthX = in.nextInt();
            String x = in.next();
            int lengthY = in.nextInt();
            String y = in.next();
            int common[][] = new int[lengthX + 1][lengthY + 1];
            for (int i = 1; i <= lengthX; i++) {
                char ch1 = x.charAt(i - 1);
                for (int j = 1; j <= lengthY; j++) {
                    char ch2 = y.charAt(j - 1);
                    if (ch1 == ch2) {
                        common[i][j] = common[i - 1][j - 1] + 1;
                    } else {
                        common[i][j] = Math.max(common[i - 1][j], common[i][j - 1]);
                    }
                }
            }
            System.out.println(lengthY - common[lengthX][lengthY]);
        }
    }
}
