package P3117__World_Cup;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-1
 * Time: 22:24:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        while (true) {
            int T = in.nextInt();
            int N = in.nextInt();
            if (T == 0) {
                break;
            }
            int draw = N * 3;
            for (int i = 0; i < T; i++) {
                in.next();
                draw -= in.nextInt();
            }
            System.out.println(draw);
        }
    }
}
