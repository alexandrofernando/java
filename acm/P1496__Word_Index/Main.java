package P1496__Word_Index;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-20
 * Time: 6:33:30
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int index;

    public static void main(String args[]) {
        int counts[] = {0, 26, 351, 2951, 17901};
        Scanner in = new Scanner(System.in);
        while (in.hasNext() == true) {
            String word = in.next();
            int length = word.length();
            boolean valid = true;
            for (int i = 1; i < length; i++) {
                if (word.charAt(i) <= word.charAt(i - 1)) {
                    valid = false;
                    break;
                }
            }
            if (valid == false) {
                System.out.println(0);
            } else {
                int index = 1;
                index += counts[length - 1];
                int previous = 'a' - 1;
                for (int i = 0; i < length; i++) {
                    char ch = word.charAt(i);
                    for (int j = previous + 1; j < ch; j++) {
                        index += C('z' - j, length - 1 - i);
                    }
                    previous = ch;
                }
                System.out.println(index);
            }
        }
    }

    static int C(int n, int m) {
        int result = 1;
        for (int i = n; i > n - m; i--) {
            result *= i;
        }
        for (int i = 1; i <= m; i++) {
            result /= i;
        }
        return result;
    }
}
