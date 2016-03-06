package P1318__Word_Amalgamation;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
        ArrayList<String> dictionary = new ArrayList<String>();
        while (true) {
            String word = cin.next();
            if (word.equals("XXXXXX") == true) {
                break;
            }
            dictionary.add(word);
        }
        Collections.sort(dictionary);
        while (true) {
            String str = cin.next();
            if (str.equals("XXXXXX") == true) {
                break;
            }
            boolean find = false;
            Iterator<String> iterator = dictionary.iterator();
            while (iterator.hasNext() == true) {
                String word = iterator.next();
                if (check(word, str) == true) {
                    System.out.println(word);
                    find = true;
                }
            }
            if (find == false) {
                System.out.println("NOT A VALID WORD");
            }
            System.out.println("******");
        }
    }

    static boolean check(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int count1[] = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count1[a.charAt(i) - 'a']++;
        }
        int count2[] = new int[26];
        for (int i = 0; i < b.length(); i++) {
            count2[b.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
