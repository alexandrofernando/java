package P1250__Tanning_Salon;

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
            int bed = cin.nextInt();
            if (bed == 0) {
                break;
            }
            int leave = 0;
            boolean used[] = new boolean[26];
            String str = cin.next();
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'A';
                if (used[index] == true) {
                    used[index] = false;
                    bed++;
                } else if (bed > 0) {
                    used[index] = true;
                    bed--;
                } else {
                    leave++;
                }
            }
            leave /= 2;
            if (leave == 0) {
                System.out.println("All customers tanned successfully.");
            } else {
                System.out.println(leave + " customer(s) walked away.");
            }
        }
    }
}
