package P2403__Hay_Points;

import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;

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
        int m = cin.nextInt();
        int n = cin.nextInt();
        TreeMap<String, Integer> dictionary = new TreeMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            String word = cin.next();
            int dollar = cin.nextInt();
            dictionary.put(word, dollar);
        }
        for (int i = 0; i < n; i++) {
            int salary = 0;
            while (true) {
                String str = cin.next();
                if (str.equals(".") == true) {
                    break;
                }
                if (dictionary.containsKey(str) == true) {
                    salary += dictionary.get(str);
                }
            }
            System.out.println(salary);
        }
    }
}
