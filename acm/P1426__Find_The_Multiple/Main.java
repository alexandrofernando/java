package P1426__Find_The_Multiple;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-15
 * Time: 14:35:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            if (n == 1) {
                System.out.println("1");
                continue;
            }
            boolean used[] = new boolean[n];
            LinkedList<Number> queue = new LinkedList<Number>();
            used[1] = true;
            queue.offer(new Number("1", 1));
            while (true) {
                Number head = queue.poll();
                int nextRemainder0 = (head.remainder * 10) % n;
                if (nextRemainder0 == 0) {
                    System.out.println(head.represent + "0");
                    break;
                }
                if (!used[nextRemainder0]) {
                    used[nextRemainder0] = true;
                    queue.offer(new Number(head.represent + "0", nextRemainder0));
                }
                int nextRemainder1 = (head.remainder * 10 + 1) % n;
                if (nextRemainder1 == 0) {
                    System.out.println(head.represent + "1");
                    break;
                }
                if (!used[nextRemainder1]) {
                    used[nextRemainder1] = true;
                    queue.offer(new Number(head.represent + "1", nextRemainder1));
                }
            }
        }
    }
}

class Number {
    String represent;
    int remainder;

    Number(String theRepresent, int theRemainder) {
        this.represent = theRepresent;
        this.remainder = theRemainder;
    }
}