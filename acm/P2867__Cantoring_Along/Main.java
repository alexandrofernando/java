package P2867__Cantoring_Along;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        String str[] = new String[13];
        str[0] = "-";
        for (int i = 1; i < str.length; i++) {
            StringBuffer temp = new StringBuffer("");
            temp.setLength(str[i - 1].length());
            for (int j = 0; j < str[i - 1].length(); j++) {
                temp.setCharAt(j, ' ');
            }
            str[i] = str[i - 1] + temp + str[i - 1];
        } while (cin.hasNextInt() == true) {
            int n = cin.nextInt();
            System.out.println(str[n]);
        }
    }
}
