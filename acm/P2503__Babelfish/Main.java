package P2503__Babelfish;

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
        TreeMap<String, String> dictionary = new TreeMap<String, String>();
        while (true) {
            String line = cin.nextLine();
            if (line.equals("") == true) {
                break;
            }
            String str[] = line.split(" ");
            dictionary.put(str[1], str[0]);
        } while (cin.hasNext() == true) {
            String word = cin.next();
            if (dictionary.containsKey(word) == true) {
                System.out.println(dictionary.get(word));
            } else {
                System.out.println("eh");
            }
        }
    }
}
