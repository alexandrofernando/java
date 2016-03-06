package P3445__Elementary_Additions;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-8
 * Time: 22:20:01
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static String notations[];

    public static void main(String args[]) {
        notations = new String[16];
        notations[0] = "{}";
        for (int i = 1; i <= 15; i++) {
            notations[i] = "{{}";
            for (int j = 1; j < i; j++) {
                notations[i] += "," + notations[j];
            }
            notations[i] += "}";
        }
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            String str1 = in.next();
            String str2 = in.next();
            int value1 = convert(str1);
            int value2 = convert(str2);
            System.out.println(notations[value1 + value2]);
        }
    }

    static int convert(String str) {
        for (int i = 0; i < notations.length; i++) {
            if (str.compareTo(notations[i]) == 0) {
                return i;
            }
        }
        return -1;
    }
}
