package P1132__Border;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            boolean bitmap[][] = new boolean[32][32];
            int x = cin.nextInt();
            int y = cin.nextInt();
            String moves = cin.next();
            for (int i = 0; i < moves.length() - 1; i++) {
                if (moves.charAt(i) == 'N') {
                    bitmap[x][y] = true;
                    y++;
                }
                else if (moves.charAt(i) == 'E') {
                    bitmap[x][y - 1] = true;
                    x++;
                }
                else if (moves.charAt(i) == 'S') {
                    bitmap[x - 1][y - 1] = true;
                    y--;
                }
                else if (moves.charAt(i) == 'W') {
                    bitmap[x - 1][y] = true;
                    x--;
                }
            }
            System.out.println("Bitmap #" + t);
            for (int i = 31; i >= 0; i--) {
                for (int j = 0; j <= 31; j++) {
                    if (bitmap[j][i] == true) {
                        System.out.print("X");
                    }
                    else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
