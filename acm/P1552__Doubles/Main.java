package P1552__Doubles;

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
        do {
            ArrayList<Integer> array = new ArrayList<Integer> ();
            int integer = cin.nextInt();
            if (integer == -1) {
                break;
            }
            while (integer != 0) {
                array.add(integer);
                integer = cin.nextInt();
            }
            int result = 0;
            for (int i = 0; i < array.size(); i++) {
                if (array.contains(array.get(i) * 2) == true) {
                    result++;
                }
            }
            System.out.println(result);
        }
        while (true);
    }
}
