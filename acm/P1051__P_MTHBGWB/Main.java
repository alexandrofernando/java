package P1051__P_MTHBGWB;

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
    public static void main(String args[]) throws Exception {
        String Morse[] = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            String message = cin.next();
            String code = "";
            ArrayList length = new ArrayList<Integer> ();
            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
                    code = code.concat(Morse[message.charAt(i) - 'A']);
                    length.add(Morse[message.charAt(i) - 'A'].length());
                }
                else {
                    if (message.charAt(i) == '_') {
                        code = code.concat("..--");
                    }
                    else if (message.charAt(i) == ',') {
                        code = code.concat(".-.-");
                    }
                    else if (message.charAt(i) == '.') {
                        code = code.concat("---.");
                    }
                    else if (message.charAt(i) == '?') {
                        code = code.concat("----");
                    }
                    length.add(4);
                }
            }
            System.out.print(t + ": ");
            int pos = 0;
            for (int i = length.size() - 1; i >= 0; i--) {
                String temp = code.substring(pos,
                                             pos +
                                             ( (Integer) (length.get(i))).
                                             intValue());
                pos += ( (Integer) (length.get(i))).intValue();
                if (temp.equals("..--") == true) {
                    System.out.print("_");
                }
                else if (temp.equals(".-.-") == true) {
                    System.out.print(",");
                }
                else if (temp.equals("---.") == true) {
                    System.out.print(".");
                }
                else if (temp.equals("----") == true) {
                    System.out.print("?");
                }
                else {
                    for (int j = 0; j < Morse.length; j++) {
                        if (temp.equals(Morse[j]) == true) {
                            System.out.print( (char) ('A' + j));
                            break;
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
