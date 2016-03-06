package P2000__Gold_Coins;

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
        int total[] = new int[10005];
        int each = 1;
        int count = 0;
        for (int i = 1; i < total.length; i++) {
            if (count == each) {
                each++;
                count = 0;
            }
            total[i] = total[i - 1] + each;
            count++;
        }
        do {
            int day = cin.nextInt();
            if (day == 0) {
                break;
            }
            System.out.println(day + " " + total[day]);
        }
        while (true);
    }
}
