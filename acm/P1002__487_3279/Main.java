package P1002__487_3279;

import java.util.Scanner;
import java.util.Arrays;

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
        int n = cin.nextInt();
        String[] telephones = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuffer str = new StringBuffer(cin.next());
            for (int j = 0; j < 7; j++) {
                if (str.charAt(j) == '-') {
                    str.deleteCharAt(j);
                    j--;
                }
                else if (Character.isLetter(str.charAt(j)) == true) {
                    switch (str.charAt(j)) {
                        case 'A':
                        case 'B':
                        case 'C':
                            str.setCharAt(j, '2');
                            break;
                        case 'D':
                        case 'E':
                        case 'F':
                            str.setCharAt(j, '3');
                            break;
                        case 'G':
                        case 'H':
                        case 'I':
                            str.setCharAt(j, '4');
                            break;
                        case 'J':
                        case 'K':
                        case 'L':
                            str.setCharAt(j, '5');
                            break;
                        case 'M':
                        case 'N':
                        case 'O':
                            str.setCharAt(j, '6');
                            break;
                        case 'P':
                        case 'R':
                        case 'S':
                            str.setCharAt(j, '7');
                            break;
                        case 'T':
                        case 'U':
                        case 'V':
                            str.setCharAt(j, '8');
                            break;
                        case 'W':
                        case 'X':
                        case 'Y':
                            str.setCharAt(j, '9');
                            break;
                        default:
                            break;
                    }
                }
            }
            str.setLength(7);
            telephones[i] = new String(str);
        }
        Arrays.sort(telephones);
        boolean power = false;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (telephones[i].equals(telephones[i - 1]) == true) {
                count++;
            }
            else if (count > 1) {
                StringBuffer str = new StringBuffer(telephones[i - 1]);
                str.insert(3, '-');
                System.out.println(str + " " + count);
                count = 1;
                power = true;
            }
        }
        if (count > 1) {
            StringBuffer str = new StringBuffer(telephones[n - 1]);
            str.insert(3, '-');
            System.out.println(str + " " + count);
            power = true;
        }
        if (power == false) {
            System.out.println("No duplicates.");
        }
    }
}
