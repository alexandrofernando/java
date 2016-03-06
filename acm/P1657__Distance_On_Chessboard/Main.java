package P1657__Distance_On_Chessboard;

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
            Position start = new Position(cin.next());
            Position end = new Position(cin.next());
            int disX = Math.abs(start.x - end.x);
            int disY = Math.abs(start.y - end.y);
            if (disX >= disY) {
                System.out.print(disX);
            }
            else {
                System.out.print(disY);
            }
            if (disX == 0 && disY == 0) {
                System.out.print(" 0");
            }
            else if (disX == 0 || disY == 0 || disX == disY) {
                System.out.print(" 1");
            }
            else {
                System.out.print(" 2");
            }
            if (disX == 0 && disY == 0) {
                System.out.print(" 0");
            }
            else if (disX == 0 || disY == 0) {
                System.out.print(" 1");
            }
            else {
                System.out.print(" 2");
            }
            if ( (start.x + start.y) % 2 != (end.x + end.y) % 2) {
                System.out.print(" Inf");
            }
            else if (disX == 0 && disY == 0) {
                System.out.print(" 0");
            }
            else if (disX == disY) {
                System.out.print(" 1");
            }
            else {
                System.out.print(" 2");
            }
            System.out.println();
        }
    }
}

class Position {
    int x;
    int y;
    public Position(String str) {
        this.x = str.charAt(0) - 'a';
        this.y = str.charAt(1) - '1';
    }
}
