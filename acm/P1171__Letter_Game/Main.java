package P1171__Letter_Game;

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
    static int counts[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        String collected = cin.next();
        int length = collected.length();
        counts = new int[26];
        for (int i = 0; i < length; i++) {
            counts[collected.charAt(i) - 'a']++;
        }
        int maxValue = 0;
        int values[] = {
            2, 5, 4, 4, 1, 6, 5, 5, 1, 7, 6, 3, 5, 2, 3, 5, 7, 2, 1, 2, 4, 6, 6,
            7, 5, 7};
        ArrayList<String> array = new ArrayList<String> ();
        boolean exactMatch = false;
        do {
            String word = cin.next();
            if (word.equals(".") == true) {
                break;
            }
            if (exactMatch == true) {
                continue;
            }
            int length1 = word.length();
            if (length1 > length) {
                continue;
            }
            if (check(word) == true) {
                int value = 0;
                for (int i = 0; i < length1; i++) {
                    value += values[word.charAt(i) - 'a'];
                }
                if (value > maxValue) {
                    maxValue = value;
                    if (length1 == length) {
                        exactMatch = true;
                        continue;
                    }
                }
                if ( (length == 6 && length1 == 3) ||
                    (length == 7 && (length1 == 3 || length1 == 4))) {
                    array.add(word);
                }
            }
        }
        while (true);
        if (exactMatch == false) {
            for (int i = 0; i < array.size(); i++) {
                for (int j = i + 1; j < array.size(); j++) {
                    String str = array.get(i) + array.get(j);
                    if (check(str) == true) {
                        int value = 0;
                        int length1 = str.length();
                        for (int k = 0; k < length1; k++) {
                            value += values[str.charAt(k) - 'a'];
                        }
                        if (value > maxValue) {
                            maxValue = value;
                            if (length1 == length) {
                                exactMatch = true;
                                break;
                            }
                        }
                    }
                }
                if (exactMatch == true) {
                    break;
                }
            }
        }
        System.out.println(maxValue);
    }

    static boolean check(String str) {
        int c[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            c[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (c[i] > counts[i]) {
                return false;
            }
        }
        return true;
    }
}
