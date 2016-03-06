package P1049__Microprocessor_Simulation;

import java.util.Scanner;
import java.io.File;

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
        StringBuffer memory = new StringBuffer(cin.next());
        while (memory.charAt(0) != '8') {
            int pos = 0;
            char A = '0';
            char B = '0';
            do {
                char code = memory.charAt(pos);
                if (code == '0') {
                    A = memory.charAt(address(memory.charAt(pos + 1),
                                              memory.charAt(pos + 2)));
                    pos += 3;
                }
                else if (code == '1') {
                    memory.setCharAt(address(memory.charAt(pos + 1),
                                             memory.charAt(pos + 2)), A);
                    pos += 3;
                }
                else if (code == '2') {
                    char temp = A;
                    A = B;
                    B = temp;
                    pos++;
                }
                else if (code == '3') {
                    int sum = Integer.parseInt(A + "", 16) +
                        Integer.parseInt(B + "", 16);
                    A = Integer.toHexString(sum % 16).toUpperCase().charAt(0);
                    B = Integer.toHexString(sum / 16).toUpperCase().charAt(0);
                    pos++;
                }
                else if (code == '4') {
                    if (A == 'F') {
                        A = '0';
                    }
                    else if (A == '9') {
                        A = 'A';
                    }
                    else {
                        A++;
                    }
                    pos++;
                }
                else if (code == '5') {
                    if (A == '0') {
                        A = 'F';
                    }
                    else if (A == 'A') {
                        A = '9';
                    }
                    else {
                        A--;
                    }
                    pos++;
                }
                else if (code == '6') {
                    if (A == '0') {
                        pos = address(memory.charAt(pos + 1),
                                      memory.charAt(pos + 2));
                    }
                    else {
                        pos += 3;
                    }
                }
                else if (code == '7') {
                    pos = address(memory.charAt(pos + 1), memory.charAt(pos + 2));
                }
                else if (code == '8') {
                    break;
                }
            }
            while (true);
            System.out.println(memory);
            memory = new StringBuffer(cin.next());
        }
    }

    static int address(char high, char low) {
        return Integer.parseInt(high + "" + low, 16);
    }
}
