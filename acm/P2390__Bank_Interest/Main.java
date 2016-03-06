package P2390__Bank_Interest;

import java.util.Scanner;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int R = cin.nextInt();
        int M = cin.nextInt();
        int Y = cin.nextInt();
        int result = (int) Math.floor(M * Math.pow(1 + R / 100.0, Y));
        System.out.println(result);
    }
}
