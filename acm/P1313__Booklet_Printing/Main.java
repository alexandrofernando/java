package P1313__Booklet_Printing;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-25
 * Time: 2:02:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int faces[][] = new int[(n - 1) / 4 * 2 + 2][2];
            int pos = 1;
            int index = 0;
            boolean power = true;
            for (int i = 1; i <= n; i++) {
                faces[index][pos] = i;
                if (power == true && index == faces.length - 1) {
                    index++;
                    power = false;
                }
                if (power == true) {
                    index++;
                } else {
                    index--;
                }
                pos = (pos + 1) % 2;
            }
            System.out.println("Printing order for " + n + " pages:");
            for (int i = 0; i < faces.length; i++) {
                if (faces[i][0] == 0 && faces[i][1] == 0) {
                    continue;
                }
                System.out.print("Sheet " + (i / 2 + 1) + ", ");
                if (i % 2 == 0) {
                    System.out.print("front:");
                } else {
                    System.out.print("back :");
                }
                for (int j = 0; j < 2; j++) {
                    if (j == 1) {
                        System.out.print(",");
                    }
                    System.out.print(" ");
                    if (faces[i][j] == 0) {
                        System.out.print("Blank");
                    } else {
                        System.out.print(faces[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
}
