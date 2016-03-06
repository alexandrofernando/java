package P2101__Honey_and_Milk_Land;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-23
 * Time: 7:12:45
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        int length1 = 0;
        for (int i = 0; i < n - 1; i++) {
            length1 += in.nextInt();
        }
        int length2 = 0;
        for (int i = 0; i < e - 1; i++) {
            length2 += in.nextInt();
        }
        System.out.println((int) Math.ceil(Math.sqrt(length1 * length1 + length2 * length2)));
    }
}
