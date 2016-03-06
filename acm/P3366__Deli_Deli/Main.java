package P3366__Deli_Deli;

import java.util.Scanner;
import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-9
 * Time: 6:54:54
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int N = in.nextInt();
        Hashtable<String, String> irregular = new Hashtable<String, String>();
        for (int i = 0; i < L; i++) {
            irregular.put(in.next(), in.next());
        }
        for (int i = 0; i < N; i++) {
            String word = in.next();
            String str = irregular.get(word);
            if (str != null) {
                System.out.println(str);
            } else {
                int length = word.length();
                char last1 = word.charAt(length - 1);
                if (length >= 2) {
                    char last2 = word.charAt(length - 2);
                    if (last1 == 'y' && last2 != 'a' && last2 != 'e' && last2 != 'i' && last2 != 'o' && last2 != 'u') {
                        System.out.println(word.substring(0, length - 1) + "ies");
                    } else if (last1 == 'h' && (last2 == 'c' || last2 == 's')) {
                        System.out.println(word + "es");
                    } else if (last1 == 'o' || last1 == 's' || last1 == 'x') {
                        System.out.println(word + "es");
                    } else {
                        System.out.println(word + "s");
                    }
                } else if (last1 == 'o' || last1 == 's' || last1 == 'x') {
                    System.out.println(word + "es");
                } else {
                    System.out.println(word + "s");
                }
            }
        }
    }
}
