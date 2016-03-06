package P1028__Web_Navigation;

import java.util.Scanner;
import java.io.File;
import java.util.Stack;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        Stack<String> forward = new Stack<String> ();
        Stack<String> backward = new Stack<String> ();
        String current = "http://www.acm.org/";
        String command = cin.next();
        while (command.equals("QUIT") == false) {
            if (command.equals("BACK") == true) {
                if (backward.empty() == true) {
                    System.out.println("Ignored");
                }
                else {
                    forward.push(current);
                    current = backward.pop();
                    System.out.println(current);
                }
            }
            else if (command.equals("FORWARD") == true) {
                if (forward.empty() == true) {
                    System.out.println("Ignored");
                }
                else {
                    backward.push(current);
                    current = forward.pop();
                    System.out.println(current);
                }
            }
            else if (command.equals("VISIT") == true) {
                backward.push(current);
                current = cin.next();
                forward = new Stack<String> ();
                System.out.println(current);
            }
            command = cin.next();
        }
    }
}
