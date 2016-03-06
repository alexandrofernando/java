package P2041__Unreliable_Message;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-23
 * Time: 7:19:33
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            String order = in.next();
            String message = in.next();
            int length = message.length();
            for (int i = order.length() - 1; i >= 0; i--) {
                char ch = order.charAt(i);
                if (ch == 'J') {
                    message = message.charAt(length - 1) + message.substring(0, length - 1);
                } else if (ch == 'C') {
                    message = message.substring(1, length) + message.charAt(0);
                } else if (ch == 'E') {
                    if (length % 2 == 0) {
                        message = message.substring(length / 2, length) + message.substring(0, length / 2);
                    } else {
                        message = message.substring(length / 2 + 1, length) + message.charAt(length / 2) + message.substring(0, length / 2);
                    }
                } else if (ch == 'A') {
                    message = new StringBuffer(message).reverse().toString();
                } else if (ch == 'P') {
                    StringBuffer str = new StringBuffer(message);
                    for (int j = 0; j < length; j++) {
                        char temp = str.charAt(j);
                        if (temp >= '1' && temp <= '9') {
                            temp--;
                        } else if (temp == '0') {
                            temp = '9';
                        }
                        str.setCharAt(j, temp);
                    }
                    message = str.toString();
                } else if (ch == 'M') {
                    StringBuffer str = new StringBuffer(message);
                    for (int j = 0; j < length; j++) {
                        char temp = str.charAt(j);
                        if (temp >= '0' && temp <= '8') {
                            temp++;
                        } else if (temp == '9') {
                            temp = '0';
                        }
                        str.setCharAt(j, temp);
                    }
                    message = str.toString();
                }
            }
            System.out.println(message);
        }
    }
}
