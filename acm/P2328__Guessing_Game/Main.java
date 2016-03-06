package P2328__Guessing_Game;

import java.util.Scanner;
import java.io.File;

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
        while (true) {
            boolean possibles[] = new boolean[11];
            for (int i = 1; i <= 10; i++) {
                possibles[i] = true;
            }
            int number = cin.nextInt();
            if (number == 0) {
                break;
            } while (true) {
                String str1 = cin.next();
                String str2 = cin.next();
                if (str1.equals("too") == true) {
                    if (str2.equals("high") == true) {
                        for (int i = number; i <= 10; i++) {
                            possibles[i] = false;
                        }
                    } else {
                        for (int i = 1; i <= number; i++) {
                            possibles[i] = false;
                        }
                    }
                } else {
                    if (possibles[number] == true) {
                        System.out.println("Stan may be honest");
                    } else {
                        System.out.println("Stan is dishonest");
                    }
                    break;
                }
                number = cin.nextInt();
            }
        }
    }
}
