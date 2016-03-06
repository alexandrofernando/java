package P1056__Immediate_Decodability;

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
        Scanner cin = new Scanner(System.in);
        int test = 1;
        while (cin.hasNext() == true) {
            ArrayList code = new ArrayList<String> ();
            String temp;
            while ( (temp = cin.next()).equals("9") == false) {
                code.add(temp);
            }
            boolean decodable = true;
            for (int i = 0; i < code.size(); i++) {
                for (int j = i + 1; j < code.size(); j++) {
                    if ( ( (String) code.get(i)).startsWith( (String) code.get(
                        j)) == true ||
                        ( (String) code.get(j)).startsWith( (String) code.get(
                            i)) == true) {
                        decodable = false;
                        break;
                    }
                }
                if (decodable == false) {
                    break;
                }
            }
            if (decodable == true) {
                System.out.println("Set " + test + " is immediately decodable");
            }
            else {
                System.out.println("Set " + test +
                                   " is not immediately decodable");
            }
            test++;
        }
    }
}
