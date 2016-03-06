package P3372__Candy_Distribution;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-15
 * Time: 23:52:57
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int N = in.nextInt();
            if ((N & (N - 1)) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
