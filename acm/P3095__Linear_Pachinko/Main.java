package P3095__Linear_Pachinko;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-23
 * Time: 20:00:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static String machine;
    static int length;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            machine = in.next();
            if (machine.equals("#") == true) {
                break;
            }
            length = machine.length();
            int total = 0;
            for (int i = 0; i < length; i++) {
                char ch = machine.charAt(i);
                if (ch == '.') {
                    total += 100;
                } else if (ch == '|') {
                    int temp1 = search(i - 1, -1);
                    int temp2 = search(i + 1, 1);
                    total += (temp1 + temp2) / 2;
                } else if (ch == '/') {
                    total += search(i - 1, -1);
                } else if (ch == '\\') {
                    total += search(i + 1, 1);
                }
            }
            System.out.println(total / length);
        }
    }

    static int search(int index, int offset) {
        while (index >= 0 && index < length) {
            char ch = machine.charAt(index);
            if (ch == '.') {
                return 100;
            }
            if (ch == '|' || ch == '/' || ch == '\\') {
                return 0;
            }
            index += offset;
        }
        return 100;
    }
}
