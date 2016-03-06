package P2273__An_Excel_lent_Problem;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-21
 * Time: 22:45:25
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String str = in.next();
            if (str.equals("R0C0") == true) {
                break;
            }
            int index = str.indexOf('C');
            int row = Integer.parseInt(str.substring(1, index));
            int column = Integer.parseInt(str.substring(index + 1));
            String designation = row + "";
            do {
                column--;
                char ch = (char) ('A' + column % 26);
                column /= 26;
                designation = ch + designation;
            } while (column != 0);
            System.out.println(designation);
        }
    }
}
