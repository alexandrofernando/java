package P1035__Spell_Checker;

import java.io.File;
import java.util.Scanner;
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
        ArrayList<String> dictionary = new ArrayList<String> ();
        do {
            String temp = cin.next();
            if (temp.equals("#") == true) {
                break;
            }
            dictionary.add(temp);
        }
        while (true);
        do {
            String word = cin.next();
            if (word.equals("#") == true) {
                break;
            }
            if (dictionary.contains(word) == true) {
                System.out.println(word + " is correct");
            }
            else {
                System.out.print(word + ":");
                for (int i = 0; i < dictionary.size(); i++) {
                    String one = dictionary.get(i);
                    if (check(word, one) == true) {
                        System.out.print(" " + one);
                    }
                }
                System.out.println();
            }
        }
        while (true);
    }

    static boolean check(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        if (lengthA == lengthB) {
            boolean power = false;
            for (int i = 0; i < lengthA; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (power == true) {
                        return false;
                    }
                    else {
                        power = true;
                    }
                }
            }
            return true;
        }
        else if (lengthA == lengthB + 1) {
            return check(b, a);
        }
        else if (lengthA + 1 == lengthB) {
            int offset = 0;
            for (int i = 0; i < lengthB; i++) {
                if (i == lengthB - 1 && offset == 0) {
                    return true;
                }
                if (a.charAt(i + offset) != b.charAt(i)) {
                    if (offset == -1) {
                        return false;
                    }
                    else {
                        offset = -1;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
