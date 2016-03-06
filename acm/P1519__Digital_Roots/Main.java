package P1519__Digital_Roots;

import java.util.Scanner;
import java.io.File;

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
        do {
            String str = cin.next();
            if (str.equals("0") == true) {
                break;
            }
            int root = 0;
            for (int i = 0; i < str.length(); i++) {
                root += str.charAt(i) - '0';
            }
            while (root >= 10) {
                int sum = 0;
                while (root != 0) {
                    sum += root % 10;
                    root /= 10;
                }
                root = sum;
            }
            System.out.println(root);
        }
        while (true);
    }
}
