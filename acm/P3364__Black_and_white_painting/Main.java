package P3364__Black_and_white_painting;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-16
 * Time: 2:32:15
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int m = in.nextInt();
            int c = in.nextInt();
            if (n == 0 && m == 0 && c == 0) {
                break;
            }
            int result;
            if (c == 0) {
                if (n % 2 == 0) {
                    result = (n / 2 - 4) * ((m - 6) / 2) + (n / 2 - 3) * ((m - 7) / 2);
                } else {
                    result = (n / 2 - 3) * (m - 7);
                }
            } else {
                if (n % 2 == 0) {
                    result = (n / 2 - 3) * ((m - 6) / 2) + (n / 2 - 4) * ((m - 7) / 2);
                } else {
                    result = (n / 2 - 3) * (m - 7);
                }
            }
            System.out.println(result);
        }
    }
}
