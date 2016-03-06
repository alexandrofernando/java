package P2579__Blurred_Vision;

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
            String str = cin.next();
            if (str.equals("ENDOFINPUT") == true) {
                break;
            }
            int row = cin.nextInt();
            int column = cin.nextInt();
            String pixels[] = new String[row];
            for (int i = 0; i < row; i++) {
                pixels[i] = cin.next();
            }
            cin.next();
            int offsetX[] = {0, 0, 1, 1};
            int offsetY[] = {0, 1, 1, 0};
            for (int i = 0; i < row - 1; i++) {
                for (int j = 0; j < column - 1; j++) {
                    int sum = 0;
                    for (int k = 0; k < 4; k++) {
                        sum += pixels[i + offsetX[k]].charAt(j + offsetY[k]) -
                                '0';
                    }
                    System.out.print(sum / 4);
                }
                System.out.println();
            }
        }
    }
}
