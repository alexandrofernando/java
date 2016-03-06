package P1098__Robots;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

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
    static int board[][];
    static int tempBoard[][];
    static LinkedList<Cell> robots;
    static LinkedList<Cell> tempRobots;
    static Cell person;
    static int remain;
    static int tempRemain;
    static int minDistance;
    static int tempMinDistance;
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        int R = cin.nextInt();
        int T = cin.nextInt();
        while (R != 0 || T != 0) {
            if (test != 1) {
                System.out.println();
            }
            System.out.println("Case " + test + ":");
            test++;
            board = new int[32][32];
            person = new Cell(15, 15);
            robots = new LinkedList<Cell> ();
            for (int i = 0; i < R; i++) {
                int tempR = cin.nextInt();
                int tempC = cin.nextInt();
                robots.add(new Cell(tempR, tempC));
                board[tempR][tempC] = -1;
            }
            LinkedList<Cell> teleports = new LinkedList<Cell> ();
            for (int i = 0; i < T; i++) {
                teleports.add(new Cell(cin.nextInt(), cin.nextInt()));
            }
            for (int move = 1; ; move++) {
                int bestBoard[][] = new int[32][32];
                LinkedList<Cell> bestRobots = new LinkedList<Cell> ();
                Cell bestPerson = new Cell();
                boolean loss = true;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (evaluate(i, j, false) == true) {
                            if (loss == true || tempRemain < remain ||
                                (tempRemain == remain &&
                                 tempMinDistance > minDistance)) {
                                remain = tempRemain;
                                minDistance = tempMinDistance;
                                bestBoard = tempBoard;
                                bestRobots = tempRobots;
                                bestPerson = new Cell(person.x + i,
                                    person.y + j);
                            }
                            loss = false;
                        }
                    }
                }
                if (loss == false) {
                    board = bestBoard;
                    robots = bestRobots;
                    person = bestPerson;
                    if (robots.isEmpty() == true) {
                        System.out.println("Won game after making " + move +
                                           " moves.");
                        System.out.println("Final position: " + person);
                        System.out.println("Number of cells with debris: " +
                                           numberOfDebris());
                        break;
                    }
                }
                else {
                    Iterator<Cell> iterator = teleports.listIterator();
                    while (iterator.hasNext() == true) {
                        Cell teleport = iterator.next();
                        if (board[teleport.x][teleport.y] == 0) {
                            if (evaluate(teleport.x - person.x,
                                         teleport.y - person.y, false) == true) {
                                loss = false;
                                board = tempBoard;
                                robots = tempRobots;
                                person = new Cell(teleport.x, teleport.y);
                                System.out.println("Move " + move +
                                    ": teleport to " + teleport);
                                iterator.remove();
                                break;
                            }
                        }
                    }
                }
                if (loss == true) {
                    evaluate(0, 0, true);
                    board = tempBoard;
                    System.out.println("Lost game after making " + move +
                                       " moves.");
                    System.out.println("Final position: " + person);
                    System.out.println("Number of cells with debris: " +
                                       numberOfDebris());
                    System.out.println("Number of robots remaining: " +
                                       tempRemain);
                    break;
                }
            }
            R = cin.nextInt();
            T = cin.nextInt();
        }
    }

    static int numberOfDebris() {
        int count = 0;
        for (int i = 1; i <= 31; i++) {
            for (int j = 1; j <= 31; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    static void copyBoard(int dest[][], int src[][]) {
        for (int i = 1; i <= 31; i++) {
            for (int j = 1; j <= 31; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }

    static boolean evaluate(int offsetX, int offsetY, boolean simulate) {
        int newX = person.x + offsetX;
        int newY = person.y + offsetY;
        if (newX < 1 || newX > 31 || newY < 1 || newY > 31) {
            return false;
        }
        int tempX = newX + offsetX;
        int tempY = newY + offsetY;
        if (board[newX][newY] == 1) {
            if (tempX < 1 || tempX > 31 || tempY < 1 || tempY > 31) {
                return false;
            }
            if (board[tempX][tempY] == 1) {
                return false;
            }
        }
        if (simulate == false) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int adjX = newX + i;
                    int adjY = newY + j;
                    if (adjX >= 1 && adjX <= 31 && adjY >= 1 && adjY <= 31 &&
                        board[adjX][adjY] == -1) {
                        if (adjX != tempX || adjY != tempY ||
                            board[newX][newY] != 1) {
                            return false;
                        }
                    }
                }
            }
        }
        tempBoard = new int[32][32];
        copyBoard(tempBoard, board);
        tempRobots = new LinkedList<Cell> ();
        Iterator<Cell> iterator = robots.listIterator();
        while (iterator.hasNext() == true) {
            tempRobots.add(new Cell(iterator.next()));
        }
        if (tempBoard[newX][newY] == 1) {
            tempBoard[newX][newY] = 0;
            if (tempBoard[tempX][tempY] == -1) {
                tempRobots.remove(new Cell(tempX, tempY));
            }
            tempBoard[tempX][tempY] = 1;
        }
        iterator = tempRobots.listIterator();
        while (iterator.hasNext() == true) {
            Cell robot = iterator.next();
            tempBoard[robot.x][robot.y] = 0;
            if (robot.x < newX) {
                robot.x++;
            }
            else if (robot.x > newX) {
                robot.x--;
            }
            if (robot.y < newY) {
                robot.y++;
            }
            else if (robot.y > newY) {
                robot.y--;
            }
        }
        tempMinDistance = 65;
        LinkedList<Cell> tempRobots1 = new LinkedList<Cell> ();
        while (tempRobots.isEmpty() == false) {
            Cell robot = tempRobots.remove();
            boolean power = true;
            int index = tempRobots.indexOf(robot);
            while (index != -1) {
                power = false;
                tempRobots.remove(index);
                index = tempRobots.indexOf(robot);
            }
            if (power == true && tempBoard[robot.x][robot.y] == 1) {
                power = false;
            }
            if (power == true) {
                tempRobots1.add(robot);
                tempBoard[robot.x][robot.y] = -1;
                int distance = Math.abs(robot.x - newX) +
                    Math.abs(robot.y - newY);
                if (distance < tempMinDistance) {
                    tempMinDistance = distance;
                }
            }
            else {
                tempBoard[robot.x][robot.y] = 1;
            }
        }
        tempRobots = tempRobots1;
        tempRemain = tempRobots.size();
        return true;
    }
}

class Cell {
    int x, y;
    public Cell() {
    }

    public Cell(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public Cell(Cell another) {
        this.x = another.x;
        this.y = another.y;
    }

    public boolean equals(Object another) {
        if ( ( (Cell) another).x == this.x && ( (Cell) another).y == this.y) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
