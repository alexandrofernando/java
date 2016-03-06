package P1108__Split_Windows;

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
    static char grids[][];
    static String preorder;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            preorder = cin.next();
            Node root = build();
            stretch(root, root.curW, root.curH);
            grids = new char[root.curH + 1][root.curW + 1];
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[0].length; j++) {
                    grids[i][j] = ' ';
                }
            }
            System.out.println(t);
            fill(root, 0, 0);
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[0].length; j++) {
                    System.out.print(grids[i][j]);
                }
                System.out.println();
            }
        }
    }

    static void fill(Node node, int x, int y) {
        if (node.isLeaf == true) {
            int width = node.curW;
            int height = node.curH;
            grids[x][y] = node.label;
            if (grids[x][y + width] == ' ') {
                grids[x][y + width] = '*';
            }
            if (grids[x + height][y + width] == ' ') {
                grids[x + height][y + width] = '*';
            }
            if (grids[x + height][y] == ' ') {
                grids[x + height][y] = '*';
            }
            for (int i = y + 1; i <= y + width - 1; i++) {
                if (grids[x][i] == ' ') {
                    grids[x][i] = '-';
                }
            }
            for (int i = x + 1; i <= x + height - 1; i++) {
                if (grids[i][y + width] == ' ') {
                    grids[i][y + width] = '|';
                }
            }
            for (int i = y + 1; i <= y + width - 1; i++) {
                if (grids[x + height][i] == ' ') {
                    grids[x + height][i] = '-';
                }
            }
            for (int i = x + 1; i <= x + height - 1; i++) {
                if (grids[i][y] == ' ') {
                    grids[i][y] = '|';
                }
            }
        }
        else {
            fill(node.top_left, x, y);
            if (node.pattern == '-') {
                fill(node.bottom_right, x + node.top_left.curH, y);
            }
            else if (node.pattern == '|') {
                fill(node.bottom_right, x, y + node.top_left.curW);
            }
        }
    }

    static void stretch(Node node, int width, int height) {
        node.curW = width;
        node.curH = height;
        if (node.isLeaf == false) {
            if (node.pattern == '-') {
                int sum = node.top_left.minH + node.bottom_right.minH;
                int h1 = (int) Math.ceil( (double) height / sum *
                                         node.top_left.minH);
                int h2 = height - h1;
                stretch(node.top_left, width, h1);
                stretch(node.bottom_right, width, h2);
            }
            else if (node.pattern == '|') {
                int sum = node.top_left.minW + node.bottom_right.minW;
                int w1 = (int) Math.ceil( (double) width / sum *
                                         node.top_left.minW);
                int w2 = width - w1;
                stretch(node.top_left, w1, height);
                stretch(node.bottom_right, w2, height);
            }
        }
    }

    static Node build() {
        Node node = new Node();
        char ch = preorder.charAt(0);
        preorder = preorder.substring(1);
        if (ch == '-' || ch == '|') {
            node.isLeaf = false;
            node.pattern = ch;
            node.top_left = build();
            node.bottom_right = build();
            int width;
            if (node.pattern == '-') {
                if (node.top_left.minW > node.bottom_right.minW) {
                    width = node.top_left.minW;
                }
                else {
                    width = node.bottom_right.minW;
                }
            }
            else {
                width = node.top_left.minW + node.bottom_right.minW;
            }
            int height;
            if (node.pattern == '|') {
                if (node.top_left.minH > node.bottom_right.minH) {
                    height = node.top_left.minH;
                }
                else {
                    height = node.bottom_right.minH;
                }
            }
            else {
                height = node.top_left.minH + node.bottom_right.minH;
            }
            node.minW = width;
            node.minH = height;
            node.curW = width;
            node.curH = height;
        }
        else {
            node.isLeaf = true;
            node.label = ch;
            node.minW = 2;
            node.minH = 2;
            node.curW = 2;
            node.curH = 2;
        }
        return node;
    }
}

class Node {
    boolean isLeaf;
    char label;
    char pattern;
    Node top_left, bottom_right;
    int minW, minH;
    int curW, curH;
}
