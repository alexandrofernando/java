package P3650__The_Seven_Percent_Solution;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-10
 * Time: 15:00:55
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if (line.equals("#")) {
                break;
            }
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == ' ') {
                    System.out.print("%20");
                } else if (ch == '!') {
                    System.out.print("%21");
                } else if (ch == '$') {
                    System.out.print("%24");
                } else if (ch == '%') {
                    System.out.print("%25");
                } else if (ch == '(') {
                    System.out.print("%28");
                } else if (ch == ')') {
                    System.out.print("%29");
                } else if (ch == '*') {
                    System.out.print("%2a");
                } else {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
}
