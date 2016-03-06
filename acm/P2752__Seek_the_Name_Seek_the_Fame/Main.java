package P2752__Seek_the_Name_Seek_the_Fame;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-5-24
 * Time: 16:38:35
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int p[] = new int[str.length()];
            p[0] = -1;
            int pos = -1;
            for (int i = 1; i < str.length(); i++) {
                while (pos >= 0 && str.charAt(pos + 1) != str.charAt(i)) {
                    pos = p[pos];
                }
                if (str.charAt(pos + 1) == str.charAt(i)) {
                    pos++;
                }
                p[i] = pos;
            }
            Stack<Integer> stack = new Stack<Integer>();
            int index = str.length() - 1;
            while (index != -1) {
                stack.push(index + 1);
                index = p[index];
            }
            boolean first = true;
            while (!stack.empty()) {
                if (first) {
                    first = false;
                } else {
                    System.out.print(" ");
                }
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }
}
