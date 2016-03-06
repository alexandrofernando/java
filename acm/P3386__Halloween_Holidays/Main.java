package P3386__Halloween_Holidays;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-5
 * Time: 7:04:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int a = in.nextInt();
        int B = in.nextInt();
        int b = in.nextInt();
        int P = in.nextInt();
        if ((A + B <= P || a >= B || b >= A) && A <= P && B <= P) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
