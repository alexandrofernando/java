package P2501__Average_Speed;

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
        double distance = 0;
        int speed = 0;
        Time previous = new Time(0, 0, 0);
        while (cin.hasNext() == true) {
            String str = cin.next();
            int hour = Integer.parseInt(str.substring(0, 2));
            int minute = Integer.parseInt(str.substring(3, 5));
            int second = Integer.parseInt(str.substring(6, 8));
            Time time = new Time(hour, minute, second);
            distance += speed * Time.getInterval(previous, time);
            if (cin.hasNextInt() == true) {
                speed = cin.nextInt();
            } else {
                System.out.printf("%s %.2f km\n", str, distance);
            }
            previous = time;
        }
    }
}


class Time {
    int hour;
    int minute;
    int second;

    public Time(int theHour, int theMinute, int theSecond) {
        this.hour = theHour;
        this.minute = theMinute;
        this.second = theSecond;
    }

    static double getInterval(Time a, Time b) {
        int secondA = a.hour * 3600 + a.minute * 60 + a.second;
        int secondB = b.hour * 3600 + b.minute * 60 + b.second;
        return (secondB - secondA) / 3600.0;
    }
}
