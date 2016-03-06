package P2013__Symmetric_Order;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
        int test = 1;
        do {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            ArrayList<String> output = new ArrayList<String> ();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    output.add(i / 2, cin.next());
                }
                else {
                    output.add( (i + 1) / 2, cin.next());
                }
            }
            System.out.println("SET " + test);
            test++;
            for (int i = 0; i < output.size(); i++) {
                System.out.println(output.get(i));
            }
        }
        while (true);
    }
}
