package P2453__An_Easy_Problem;

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
            int I = cin.nextInt();
            if (I == 0) {
                break;
            }
            int binary[] = new int[21];
            for (int i = 0; i < 21; i++) {
                binary[i] = I % 2;
                I /= 2;
            }
            boolean power = false;
            int count = 0;
            int pos = 0;
            for (int i = 0; i < 21; i++) {
                if (binary[i] == 0 && power == true) {
                    binary[i] = 1;
                    pos = i;
                    break;
                }
                if (binary[i] == 1) {
                    if (power == false) {
                        power = true;
                    }
                    count++;
                }
            }
            for (int i = 0; i < count - 1; i++) {
                binary[i] = 1;
            }
            for (int i = count - 1; i < pos; i++) {
                binary[i] = 0;
            }
            int J = 0;
            for (int i = 20; i >= 0; i--) {
                J = J * 2 + binary[i];
            }
            System.out.println(J);
        }
    }
}
