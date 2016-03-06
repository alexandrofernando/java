package P2872__Spelling_Be;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-20
 * Time: 6:42:22
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int wordNumber = in.nextInt();
        TreeSet<String> words = new TreeSet<String>();
        for (int i = 0; i < wordNumber; i++) {
            words.add(in.next());
        }
        int emailNumber = in.nextInt();
        for (int i = 1; i <= emailNumber; i++) {
            boolean correct = true;
            while (true) {
                String str = in.next();
                if (str.equals("-1") == true) {
                    break;
                }
                if (words.contains(str) == false) {
                    if (correct == true) {
                        System.out.println("Email " + i + " is not spelled correctly.");
                        correct = false;
                    }
                    System.out.println(str);
                }
            }
            if (correct == true) {
                System.out.println("Email " + i + " is spelled correctly.");
            }
        }
        System.out.println("End of Output");
    }
}
