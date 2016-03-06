package P3094__Quicksum;

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
        while (true) {
            String packet = cin.nextLine();
            if (packet.equals("#") == true) {
                break;
            }
            int quickSum = 0;
            for (int i = 0; i < packet.length(); i++) {
                char ch = packet.charAt(i);
                if (ch != ' ') {
                    quickSum += (ch - 'A' + 1) * (i + 1);
                }
            }
            System.out.println(quickSum);
        }
    }
}
