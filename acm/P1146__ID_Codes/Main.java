package P1146__ID_Codes;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
        do {
            String code = cin.next();
            if (code.equals("#") == true) {
                break;
            }
            boolean hasNext = false;
            int pos = 0;
            int length = code.length();
            for (int i = length - 1; i >= 1; i--) {
                if (code.charAt(i - 1) < code.charAt(i)) {
                    pos = i - 1;
                    hasNext = true;
                    break;
                }
            }
            if (hasNext == false) {
                System.out.println("No Successor");
            }
            else {
                System.out.print(code.substring(0, pos));
                char ch = code.charAt(pos);
                ArrayList<Character> array = new ArrayList<Character> ();
                for (int i = pos; i < length; i++) {
                    array.add(code.charAt(i));
                }
                Collections.sort(array);
                for (int i = 0; i < array.size(); i++) {
                    char temp = array.get(i);
                    if (temp > ch) {
                        System.out.print(temp);
                        array.remove(i);
                        break;
                    }
                }
                for (int i = 0; i < array.size(); i++) {
                    System.out.print(array.get(i));
                }
                System.out.println();
            }
        }
        while (true);
    }
}
