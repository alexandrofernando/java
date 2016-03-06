package P1917__Automatic_Poetry;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-1
 * Time: 6:29:44
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= test; t++) {
            String line1 = in.nextLine();
            String s[] = line1.split("<|>", -1);
            String line2 = in.nextLine();
            for (int i = 0; i < 5; i++) {
                System.out.print(s[i]);
            }
            System.out.println();
            System.out.println(line2.substring(0, line2.length() - 3) + s[3] + s[2] + s[1] + s[4]);
        }
    }
}
