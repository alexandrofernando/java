package P2552__Assistance_Required;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int lucky[] = new int[3001];
        ArrayList<Integer> queue = new ArrayList<Integer>();
        for (int i = 2; i < 35000; i++) {
            queue.add(i);
        }
        for (int i = 1; i <= 3000; i++) {
            lucky[i] = queue.get(0);
            int top = (queue.size() - 1) / lucky[i] * lucky[i];
            for (int j = top; j >= 0; j -= lucky[i]) {
                queue.remove(j);
            }
        } while (true) {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(lucky[n]);
        }
    }
}
