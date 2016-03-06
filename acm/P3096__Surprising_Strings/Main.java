package P3096__Surprising_Strings;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-30
 * Time: 8:06:34
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String str = in.next();
            if (str.equals("*") == true) {
                break;
            }
            int length = str.length();
            boolean surprising = true;
            for (int offset = 1; offset <= length - 1; offset++) {
                for (int i = 0; i + offset < length; i++) {
                    for (int j = i + 1; j + offset < length; j++) {
                        if (str.charAt(i) == str.charAt(j) && str.charAt(i + offset) == str.charAt(j + offset)) {
                            surprising = false;
                            break;
                        }
                    }
                    if (surprising == false) {
                        break;
                    }
                }
                if (surprising == false) {
                    break;
                }
            }
            if (surprising == true) {
                System.out.println(str + " is surprising.");
            } else {
                System.out.println(str + " is NOT surprising.");
            }
        }
    }
}
