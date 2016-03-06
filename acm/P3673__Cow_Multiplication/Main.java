package P3673__Cow_Multiplication;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-10
 * Time: 14:28:16
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            int digitA = a.charAt(i) - '0';
            for (int j = 0; j < b.length(); j++) {
                int digitB = b.charAt(j) - '0';
                result += digitA * digitB;
            }
        }
        System.out.println(result);
    }
}
