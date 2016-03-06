package P1575__Easier_Done_Than_Said;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-1
 * Time: 8:10:13
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String password = in.next();
            if (password.equals("end") == true) {
                break;
            }
            int length = password.length();
            boolean accept = true;
            boolean exist = false;
            for (int i = 0; i < length; i++) {
                if (isVowel(password.charAt(i)) == true) {
                    exist = true;
                    break;
                }
            }
            if (exist == false) {
                accept = false;
            } else {
                for (int i = 0; i < length - 2; i++) {
                    boolean temp1 = isVowel(password.charAt(i));
                    boolean temp2 = isVowel(password.charAt(i + 1));
                    boolean temp3 = isVowel(password.charAt(i + 2));
                    if (temp1 == temp2 && temp2 == temp3) {
                        accept = false;
                        break;
                    }
                }
                if (accept == true) {
                    for (int i = 0; i < length - 1; i++) {
                        char ch1 = password.charAt(i);
                        char ch2 = password.charAt(i + 1);
                        if (ch1 != 'e' && ch2 != 'o' && ch1 == ch2) {
                            accept = false;
                            break;
                        }
                    }
                }
            }
            if (accept == true) {
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }
    }

    static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        } else {
            return false;
        }
    }
}
