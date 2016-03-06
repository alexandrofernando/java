package P1082__Calendar_Game;

import java.util.Scanner;
import java.util.Calendar;
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
    public static void main(String args[]) throws Exception {
        boolean win[][][] = new boolean[102][13][32];
        Calendar current = Calendar.getInstance();
        current.set(2001, 10, 4);
        Calendar top = Calendar.getInstance();
        top.set(2001, 10, 4);
        Calendar bottom = Calendar.getInstance();
        bottom.set(1900, 0, 1);
        while (current.before(bottom) == false) {
            int year = current.get(Calendar.YEAR);
            int month = current.get(Calendar.MONTH) + 1;
            int date = current.get(Calendar.DATE);
            win[year - 1900][month][date] = false;
            Calendar temp = (Calendar) current.clone();
            temp.add(Calendar.DATE, 1);
            if (temp.after(top) == false) {
                int tempYear = temp.get(Calendar.YEAR);
                int tempMonth = temp.get(Calendar.MONTH) + 1;
                int tempDate = temp.get(Calendar.DATE);
                if (win[tempYear - 1900][tempMonth][tempDate] == false) {
                    win[year - 1900][month][date] = true;
                }
            }
            temp = (Calendar) current.clone();
            temp.add(Calendar.MONTH, 1);
            if (temp.get(Calendar.DATE) == date && temp.after(top) == false) {
                int tempYear = temp.get(Calendar.YEAR);
                int tempMonth = temp.get(Calendar.MONTH) + 1;
                int tempDate = temp.get(Calendar.DATE);
                if (win[tempYear - 1900][tempMonth][tempDate] == false) {
                    win[year - 1900][month][date] = true;
                }
            }
            current.add(Calendar.DATE, -1);
        }
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int year = cin.nextInt();
            int month = cin.nextInt();
            int date = cin.nextInt();
            if (win[year - 1900][month][date] == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
