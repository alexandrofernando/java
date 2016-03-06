package P2080__Calendar;

import java.util.Scanner;
import java.io.File;
import java.util.Calendar;

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
            int offset = cin.nextInt();
            if (offset == -1) {
                break;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2000, 0, 1);
            calendar.add(Calendar.DATE, offset);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int date = calendar.get(Calendar.DATE);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            String str[] = {"", "Sunday", "Monday", "Tuesday", "Wednesday",
                           "Thursday", "Friday", "Saturday"};
            System.out.printf("%d-%02d-%02d %s\n", year, month, date,
                              str[dayOfWeek]);
        }
    }
}
