package P1008__Maya_Calendar;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

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
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String temp[] = {
            "pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen",
            "yax", "zac", "ceh", "mac", "kankin", "muan", "pax", "koyab",
            "cumhu", "uayet"};
        String answerNames[] = {
            "imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat",
            "muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban",
            "eznab", "canac", "ahau"};
        ArrayList monthNames = new ArrayList<String> (Arrays.asList(temp));
        int n = cin.nextInt();
        System.out.println(n);
        for (int t = 0; t < n; t++) {
            String str = cin.next();
            str = str.substring(0, str.length() - 1);
            int day = Integer.parseInt(str);
            int month = monthNames.indexOf(cin.next()) + 1;
            int year = cin.nextInt();
            int numberOfDays = year * 365 + (month - 1) * 20 + day + 1;
            int answerYear = (numberOfDays - 1) / 260;
            int answerNumber = numberOfDays % 13;
            if (answerNumber == 0) {
                answerNumber = 13;
            }
            String answerName = answerNames[ (numberOfDays + 19) % 20];
            System.out.println(answerNumber + " " + answerName + " " +
                               answerYear);
        }
    }
}
