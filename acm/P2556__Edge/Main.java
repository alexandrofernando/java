package P2556__Edge;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-2
 * Time: 6:03:46
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext() == true) {
            String str = in.next();
            System.out.println("300 420 moveto");
            int x = 300;
            int y = 420;
            int offsetX[] = {10, 0, -10, 0};
            int offsetY[] = {0, -10, 0, 10};
            int direction = 0;
            for (int i = 0; i < str.length(); i++) {
                x += offsetX[direction];
                y += offsetY[direction];
                System.out.println(x + " " + y + " lineto");
                char ch = str.charAt(i);
                if (ch == 'A') {
                    direction = (direction + 1) % 4;
                } else if (ch == 'V') {
                    direction = (direction + 3) % 4;
                }
            }
            x += offsetX[direction];
            y += offsetY[direction];
            System.out.println(x + " " + y + " lineto");
            System.out.println("stroke");
            System.out.println("showpage");
        }
    }
}
