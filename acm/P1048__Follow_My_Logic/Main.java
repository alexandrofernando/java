package P1048__Follow_My_Logic;

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
    static char picture[][];
    static String input;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext() == true) {
            picture = new char[100][100];
            Point outputLoc = new Point();
            int row = 0;
            do {
                String temp = cin.nextLine();
                if (temp.equals("*") == true) {
                    break;
                }
                for (int i = 0; i < temp.length(); i++) {
                    picture[row][i] = temp.charAt(i);
                    if (picture[row][i] == '?') {
                        outputLoc = new Point(row, i);
                    }
                }
                row++;
            }
            while (true);
            Node output = build(outputLoc);
            do {
                input = cin.next();
                if (input.equals("*") == true) {
                    break;
                }
                System.out.println(value(output));
            }
            while (true);
            System.out.println();
        }
    }

    static int value(Node node) {
        if (node.isLeaf == true) {
            return input.charAt( ( (Leaf) node).input - 'A') - '0';
        }
        else {
            Branch branch = (Branch) node;
            int leftValue = value(branch.left);
            if (branch.leftInverted == true) {
                leftValue = (leftValue + 1) % 2;
            }
            int result;
            if (leftValue == 0 && branch.isANDGate == true) {
                result = 0;
            }
            else if (leftValue == 1 && branch.isANDGate == false) {
                result = 1;
            }
            else {
                int rightValue = value(branch.right);
                if (branch.rightInverted == true) {
                    rightValue = (rightValue + 1) % 2;
                }
                result = rightValue;
            }
            if (branch.outputInverted == true) {
                result = (result + 1) % 2;
            }
            return result;
        }
    }

    static Node build(Point point) {
        search(point);
        if (picture[point.x][point.y] >= 'A' &&
            picture[point.x][point.y] <= 'Z') {
            return new Leaf(picture[point.x][point.y]);
        }
        else {
            Branch temp = new Branch();
            if (picture[point.x][point.y] == 'o') {
                temp.outputInverted = true;
                point.y--;
            }
            if (picture[point.x][point.y] == ')') {
                temp.isANDGate = true;
            }
            else {
                temp.isANDGate = false;
            }
            if (picture[point.x - 1][point.y - 3] == 'o') {
                temp.leftInverted = true;
            }
            if (picture[point.x + 1][point.y - 3] == 'o') {
                temp.rightInverted = true;
            }
            temp.left = build(new Point(point.x - 1, point.y - 4));
            temp.right = build(new Point(point.x + 1, point.y - 4));
            return temp;
        }
    }

    static void search(Point p) {
        int direction = 3; //direction: 0-up,1-right,2-down,3-left
        if (picture[p.x][p.y] == '?') {
            if (picture[p.x - 1][p.y] == '|') {
                p.x--;
                direction = 0;
            }
            else if (picture[p.x + 1][p.y] == '|') {
                p.x++;
                direction = 2;
            }
            else if (picture[p.x][p.y - 1] == '-') {
                p.y--;
                direction = 3;
            }
        }
        while (true) {
            if (picture[p.x][p.y] == '-') {
                if (direction == 3) {
                    p.y--;
                }
                else {
                    p.y++;
                }
            }
            else if (picture[p.x][p.y] == '|') {
                if (direction == 0) {
                    p.x--;
                }
                else {
                    p.x++;
                }
            }
            else if (picture[p.x][p.y] == '+') {
                if (direction == 1 || direction == 3) {
                    if (p.x > 0 && picture[p.x - 1][p.y] == '|') {
                        p.x--;
                        direction = 0;
                    }
                    else {
                        p.x++;
                        direction = 2;
                    }
                }
                else {
                    if (p.y > 0 && picture[p.x][p.y - 1] == '-') {
                        p.y--;
                        direction = 3;
                    }
                    else {
                        p.y++;
                        direction = 1;
                    }
                }
            }
            else {
                break;
            }
        }
    }
}

class Point {
    int x;
    int y;
    public Point() {
    }

    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }
}

class Node {
    boolean isLeaf;
}

class Leaf
    extends Node {
    char input;
    public Leaf(char theInput) {
        super.isLeaf = true;
        this.input = theInput;
    }
}

class Branch
    extends Node {
    Node left;
    boolean leftInverted;
    Node right;
    boolean rightInverted;
    boolean outputInverted;
    boolean isANDGate;
    public Branch() {
        super.isLeaf = false;
        this.leftInverted = false;
        this.rightInverted = false;
        this.outputInverted = false;
    }
}
