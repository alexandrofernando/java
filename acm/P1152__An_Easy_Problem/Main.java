package P1152__An_Easy_Problem;

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
        while (cin.hasNext() == true) {
            String line = cin.next();
            if (line == null) {
                break;
            }
            int sum = 0;
            int max = 1;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                int temp = 0;
                if (ch >= '0' && ch <= '9') {
                    temp = ch - '0';
                }
                else if (ch >= 'A' && ch <= 'Z') {
                    temp = ch - 'A' + 10;
                }
                else if (ch >= 'a' && ch <= 'z') {
                    temp = ch - 'a' + 36;
                }
                if (temp > max) {
                    max = temp;
                }
                sum += temp;
            }
            int base = -1;
            for (int i = max + 1; i <= 62; i++) {
                if (sum % (i - 1) == 0) {
                    base = i;
                    break;
                }
            }
            if (base == -1) {
                System.out.println("such number is impossible!");
            }
            else {
                System.out.println(base);
            }
        }
    }
}
