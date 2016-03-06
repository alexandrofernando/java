package P2895__Best_SMS_To_Type;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int press = cin.nextInt();
            int wait = cin.nextInt();
            cin.nextLine();
            String str = cin.nextLine();
            int button = 0;
            int time = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ' ') {
                    time += press;
                    button = 1;
                } else {
                    int curButton = 0;
                    if (ch >= 'A' && ch <= 'C') {
                        time += press * (ch - 'A' + 1);
                        curButton = 2;
                    } else if (ch >= 'D' && ch <= 'F') {
                        time += press * (ch - 'D' + 1);
                        curButton = 3;
                    } else if (ch >= 'G' && ch <= 'I') {
                        time += press * (ch - 'G' + 1);
                        curButton = 4;
                    } else if (ch >= 'J' && ch <= 'L') {
                        time += press * (ch - 'J' + 1);
                        curButton = 5;
                    } else if (ch >= 'M' && ch <= 'O') {
                        time += press * (ch - 'M' + 1);
                        curButton = 6;
                    } else if (ch >= 'P' && ch <= 'S') {
                        time += press * (ch - 'P' + 1);
                        curButton = 7;
                    } else if (ch >= 'T' && ch <= 'V') {
                        time += press * (ch - 'T' + 1);
                        curButton = 8;
                    } else if (ch >= 'W' && ch <= 'Z') {
                        time += press * (ch - 'W' + 1);
                        curButton = 9;
                    }
                    if (curButton == button) {
                        time += wait;
                    }
                    button = curButton;
                }
            }
            System.out.println(time);
        }
    }
}
