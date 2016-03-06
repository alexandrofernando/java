package P1256__Anagram;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            String word = cin.next();
            int length = word.length();
            Character temp[] = new Character[length];
            for (int i = 0; i < length; i++) {
                temp[i] = word.charAt(i);
            }
            Arrays.sort(temp, new MyComparator());
            String str = "";
            for (int i = 0; i < length; i++) {
                str += temp[i];
            }
            search("", str);
        }
    }

    static void search(String current, String str) {
        if (str.equals("") == true) {
            System.out.println(current);
        }
        else {
            boolean used[] = new boolean[58];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (used[ch - 'A'] == false) {
                    used[ch - 'A'] = true;
                    String head = str.substring(0, i);
                    String tail = "";
                    if (i != str.length() - 1) {
                        tail = str.substring(i + 1);
                    }
                    search(current + ch, head + tail);
                }
            }
        }
    }
}

class MyComparator
    implements Comparator<Character> {
    public int compare(Character a, Character b) {
        char aL = Character.toLowerCase(a);
        char bL = Character.toLowerCase(b);
        if (aL != bL) {
            return aL - bL;
        }
        else {
            return a - b;
        }
    }
}
