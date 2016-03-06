package P2559__Largest_Rectangle_In_A_Histogram;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            long area = 0;
            Stack<Height_Left> stack = new Stack<Height_Left> ();
            for (int i = 0; i < n; i++) {
                int h = cin.nextInt();
                int pos = i;
                while (stack.empty() == false && stack.peek().height >= h) {
                    Height_Left hl = stack.pop();
                    long temp = (long) hl.height * (i - hl.left);
                    if (temp > area) {
                        area = temp;
                    }
                    pos = hl.left;
                }
                stack.push(new Height_Left(h, pos));
            }
            while (stack.empty() == false) {
                Height_Left hl = stack.pop();
                long temp = (long) hl.height * (n - hl.left);
                if (temp > area) {
                    area = temp;
                }
            }
            System.out.println(area);
        }
    }
}

class Height_Left {
    int height;
    int left;
    public Height_Left(int theHeight, int theLeft) {
        this.height = theHeight;
        this.left = theLeft;
    }
}
