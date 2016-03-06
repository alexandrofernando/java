package P3438__Look_and_Say;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-1-5
 * Time: 20:39:31
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            String string = in.next();
            int count = 0;
            char previous = 0;
            for (int i = 0; i < string.length(); i++) {
                char current = string.charAt(i);
                if (current == previous) {
                    count++;
                } else {
                    if (count != 0) {
                        System.out.print(count + "" + previous);
                    }
                    previous = current;
                    count = 1;
                }
            }
            System.out.println(count + "" + previous);
        }
    }
}
