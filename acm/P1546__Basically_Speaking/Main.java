package P1546__Basically_Speaking;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-17
 * Time: 22:45:20
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext() == true) {
            String origin = in.next();
            int base1 = in.nextInt();
            int base2 = in.nextInt();
            int number = Integer.parseInt(origin, base1);
            String str = Integer.toString(number, base2).toUpperCase();
            if (str.length() > 7) {
                System.out.println("  ERROR");
            } else {
                System.out.printf("%7s\n", str);
            }
        }
    }
}
