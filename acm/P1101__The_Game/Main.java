package P1101__The_Game;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

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
    static int w;
    static int h;
    static boolean board[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        do {
            w = cin.nextInt();
            h = cin.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            board = new boolean[w + 2][h + 2];
            cin.nextLine();
            for (int i = 1; i <= h; i++) {
                String str = cin.nextLine();
                for (int j = 1; j <= w; j++) {
                    if (str.charAt(j - 1) == 'X') {
                        board[j][i] = true;
                    }
                }
            }
            System.out.println("Board #" + test + ":");
            test++;
            int pair = 1;
            do {
                int x1 = cin.nextInt();
                int y1 = cin.nextInt();
                int x2 = cin.nextInt();
                int y2 = cin.nextInt();
                if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0) {
                    break;
                }
                int result = bfs(x1, y1, x2, y2);
                if (result != -1) {
                    System.out.println("Pair " + pair + ": " + result +
                                       " segments.");
                }
                else {
                    System.out.println("Pair " + pair + ": impossible.");
                }
                pair++;
            }
            while (true);
            System.out.println();
        }
        while (true);
    }

    static int bfs(int x1, int y1, int x2, int y2) {
        int offsetX[] = {
            0, 1, 0, -1};
        int offsetY[] = {
            -1, 0, 1, 0};
        boolean visited[][] = new boolean[w + 2][h + 2];
        LinkedList<Element> queue = new LinkedList<Element> ();
        queue.offer(new Element(x1, y1, 0));
        while (queue.isEmpty() == false) {
            Element head = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = head.x + offsetX[i];
                int tempY = head.y + offsetY[i];
                while (tempX >= 0 && tempX <= w + 1 && tempY >= 0 &&
                       tempY <= h + 1 &&
                       ( (tempX == x2 && tempY == y2) ||
                        (board[tempX][tempY] == false && visited[tempX][tempY] == false))) {
                    if (tempX == x2 && tempY == y2) {
                        return head.segment + 1;
                    }
                    queue.offer(new Element(tempX, tempY, head.segment + 1));
                    visited[tempX][tempY] = true;
                    tempX += offsetX[i];
                    tempY += offsetY[i];
                }
            }
        }
        return -1;
    }
}

class Element {
    int x;
    int y;
    int segment;
    public Element(int X, int Y, int theSegment) {
        this.x = X;
        this.y = Y;
        this.segment = theSegment;
    }
}
