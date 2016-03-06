package P1027__The_Same_Game;

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
    static char board[][] = new char[10][15];
    static int cluster[][];
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            for (int i = 9; i >= 0; i--) {
                board[i] = cin.next().toCharArray();
            }
            if (t != 1) {
                System.out.println();
            }
            System.out.println("Game " + t + ":");
            System.out.println();
            int score = 0;
            int move = 1;
            while (true) {
                int number = 0;
                int max = 0;
                cluster = new int[10][15];
                ClusterInfo standard = new ClusterInfo();
                for (int i = 9; i >= 0; i--) {
                    for (int j = 0; j < 15; j++) {
                        if (board[i][j] != ' ' && cluster[i][j] == 0) {
                            number++;
                            cluster[i][j] = number;
                            ClusterInfo info = search(i, j, number);
                            if (info.ball > standard.ball ||
                                (info.ball == standard.ball &&
                                 info.left_bottom.
                                 isLeft_bottom(standard.left_bottom) == true)) {
                                standard = info;
                                max = standard.ball;
                            }
                        }
                    }
                }
                if (max <= 1) {
                    break;
                }
                int point = (standard.ball - 2) * (standard.ball - 2);
                System.out.println("Move " + move + " at " +
                                   standard.left_bottom + ": removed " +
                                   standard.ball + " balls of color " +
                                   board[standard.left_bottom.row][standard.
                                   left_bottom.column] + ", got " + point +
                                   " points.");
                move++;
                score += point;
                remove(standard.number);
            }
            int remain = 0;
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < 15; j++) {
                    if (board[i][j] != ' ') {
                        remain++;
                    }
                }
            }
            if (remain == 0) {
                score += 1000;
            }
            System.out.println("Final score: " + score + ", with " + remain +
                               " balls remaining.");
        }
    }

    public static ClusterInfo search(int x, int y, int number) {
        ClusterInfo info = new ClusterInfo(number, new Coordinate(x, y));
        LinkedList<Coordinate> queue = new LinkedList<Coordinate> ();
        queue.offer(new Coordinate(x, y));
        while (queue.isEmpty() == false) {
            Coordinate temp = queue.poll();
            int tempX = temp.row;
            int tempY = temp.column;
            if (tempX > 0 && board[tempX - 1][tempY] == board[tempX][tempY] &&
                cluster[tempX - 1][tempY] == 0) {
                cluster[tempX - 1][tempY] = number;
                info.ball++;
                if (new Coordinate(tempX - 1,
                                   tempY).isLeft_bottom(info.left_bottom) == true) {
                    info.left_bottom.row = tempX - 1;
                    info.left_bottom.column = tempY;
                }
                queue.offer(new Coordinate(tempX - 1, tempY));
            }
            if (tempX < 9 && board[tempX + 1][tempY] == board[tempX][tempY] &&
                cluster[tempX + 1][tempY] == 0) {
                cluster[tempX + 1][tempY] = number;
                info.ball++;
                queue.offer(new Coordinate(tempX + 1, tempY));
            }
            if (tempY > 0 && board[tempX][tempY - 1] == board[tempX][tempY] &&
                cluster[tempX][tempY - 1] == 0) {
                cluster[tempX][tempY - 1] = number;
                info.ball++;
                if (new Coordinate(tempX,
                                   tempY - 1).isLeft_bottom(info.left_bottom) == true) {
                    info.left_bottom.row = tempX;
                    info.left_bottom.column = tempY - 1;
                }
                queue.offer(new Coordinate(tempX, tempY - 1));
            }
            if (tempY < 14 && board[tempX][tempY + 1] == board[tempX][tempY] &&
                cluster[tempX][tempY + 1] == 0) {
                cluster[tempX][tempY + 1] = number;
                info.ball++;
                queue.offer(new Coordinate(tempX, tempY + 1));
            }
        }
        return info;
    }

    public static void remove(int number) {
        for (int j = 0; j < 15; j++) {
            char temp[] = new char[10];
            int pos = 0;
            for (int i = 0; i < 10; i++) {
                if (cluster[i][j] != number) {
                    temp[pos] = board[i][j];
                    pos++;
                }
            }
            for (int i = pos; i < 10; i++) {
                temp[i] = ' ';
            }
            for (int i = 0; i < 10; i++) {
                board[i][j] = temp[i];
            }
        }
        char temp[][] = new char[10][15];
        int pos = 0;
        for (int j = 0; j < 15; j++) {
            if (board[0][j] != ' ') {
                for (int i = 0; i < 10; i++) {
                    temp[i][pos] = board[i][j];
                }
                pos++;
            }
        }
        for (int j = pos; j < 15; j++) {
            for (int i = 0; i < 10; i++) {
                temp[i][j] = ' ';
            }
        }
        board = temp;
    }
}

class Coordinate {
    int row, column;
    public Coordinate(int theRow, int theColumn) {
        this.row = theRow;
        this.column = theColumn;
    }

    public boolean isLeft_bottom(Coordinate a) {
        if (this.column < a.column) {
            return true;
        }
        else if (this.column == a.column && this.row < a.row) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return "(" + (this.row + 1) + "," + (this.column + 1) + ")";
    }
}

class ClusterInfo {
    int number;
    int ball;
    Coordinate left_bottom;
    public ClusterInfo() {
        this.ball = 0;
    }

    public ClusterInfo(int theNumber, Coordinate one) {
        this.number = theNumber;
        this.ball = 1;
        this.left_bottom = one;
    }
}
