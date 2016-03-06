package P2243__Knight_Moves;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

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
        while (cin.hasNext() == true) {
            String str1 = cin.next();
            String str2 = cin.next();
            Square start = new Square(str1);
            Square end = new Square(str2);
            LinkedList<Square> queue = new LinkedList<Square>();
            boolean visited[][] = new boolean[8][8];
            visited[start.x][start.y] = true;
            queue.offer(start);
            int offsetX[] = { -2, -1, 1, 2, 2, 1, -1, -2};
            int offsetY[] = {1, 2, 2, 1, -1, -2, -2, -1};
            while (queue.isEmpty() == false) {
                Square head = queue.poll();
                if (head.x == end.x && head.y == end.y) {
                    System.out.println("To get from " + str1 + " to " + str2 +
                                       " takes " + head.step + " knight moves.");
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int newX = head.x + offsetX[i];
                    int newY = head.y + offsetY[i];
                    if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                        queue.offer(new Square(newX, newY, head.step + 1));
                    }
                }
            }
        }
    }
}


class Square {
    int x;
    int y;
    int step;
    public Square(String str) {
        this.x = str.charAt(0) - 'a';
        this.y = str.charAt(1) - '1';
        this.step = 0;
    }

    public Square(int X, int Y, int theStep) {
        this.x = X;
        this.y = Y;
        this.step = theStep;
    }
}
