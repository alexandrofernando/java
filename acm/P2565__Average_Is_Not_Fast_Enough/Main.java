package P2565__Average_Is_Not_Fast_Enough;

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
        int n = cin.nextInt();
        double d = cin.nextDouble();
        while (cin.hasNextInt() == true) {
            int number = cin.nextInt();
            boolean qualify = true;
            int total = 0;
            for (int i = 0; i < n; i++) {
                String str = cin.next();
                if (str.equals("-:--:--") == true) {
                    qualify = false;
                }
                if (qualify == true) {
                    int hour = Integer.parseInt(str.substring(0, 1));
                    int minute = Integer.parseInt(str.substring(2, 4));
                    int second = Integer.parseInt(str.substring(5, 7));
                    total += hour * 3600 + minute * 60 + second;
                }
            }
            System.out.printf("%3d: ", number);
            if (qualify == true) {
                int average = (int) Math.round(total / d);
                int resultM = average / 60;
                int resultS = average % 60;
                System.out.printf("%d:%02d min/km\n", resultM, resultS);
            } else {
                System.out.println("-");
            }
        }
    }
}
