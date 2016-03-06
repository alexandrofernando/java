package P1169__Packing_Rectangles;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
    static Rectangle rectangles[];
    static int area;
    static ArrayList<Rectangle> result;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        rectangles = new Rectangle[4];
        for (int i = 0; i < 4; i++) {
            rectangles[i] = new Rectangle(cin.nextInt(), cin.nextInt());
        }
        area = 10005;
        result = new ArrayList<Rectangle> ();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int p = 0; p < 2; p++) {
                        search(0, 1, 2, 3);
                        search(0, 1, 3, 2);
                        search(0, 2, 1, 3);
                        search(0, 2, 3, 1);
                        search(0, 3, 1, 2);
                        search(0, 3, 2, 1);
                        search(1, 0, 2, 3);
                        search(1, 0, 3, 2);
                        search(1, 2, 0, 3);
                        search(1, 2, 3, 0);
                        search(1, 3, 0, 2);
                        search(1, 3, 2, 0);
                        search(2, 0, 1, 3);
                        search(2, 0, 3, 1);
                        search(2, 1, 0, 3);
                        search(2, 1, 3, 0);
                        search(2, 3, 0, 1);
                        search(2, 3, 1, 0);
                        search(3, 0, 1, 2);
                        search(3, 0, 2, 1);
                        search(3, 1, 0, 2);
                        search(3, 1, 2, 0);
                        search(3, 2, 0, 1);
                        search(3, 2, 1, 0);
                        rectangles[0].rotate();
                    }
                    rectangles[1].rotate();
                }
                rectangles[2].rotate();
            }
            rectangles[3].rotate();
        }
        Collections.sort(result);
        System.out.println(area);
        for (int i = 0; i < result.size(); i++) {
            Rectangle rec = result.get(i);
            System.out.println(rec.length[0] + " " + rec.length[1]);
        }
    }

    static void search(int a0, int a1, int a2, int a3) {
        int length0 = 0;
        int length1 = 0;
        int a[] = {
            a0, a1, a2, a3};
        for (int i = 0; i < 4; i++) {
            length0 += rectangles[a[i]].length[0];
            if (rectangles[a[i]].length[1] > length1) {
                length1 = rectangles[a[i]].length[1];
            }
        }
        update(length0, length1);

        length0 = 0;
        length1 = 0;
        for (int i = 0; i < 3; i++) {
            length0 += rectangles[a[i]].length[0];
            if (rectangles[a[i]].length[1] > length1) {
                length1 = rectangles[a[i]].length[1];
            }
        }
        if (rectangles[a3].length[0] > length0) {
            length0 = rectangles[a3].length[0];
        }
        length1 += rectangles[a3].length[1];
        update(length0, length1);

        length0 = rectangles[a0].length[0] + rectangles[a1].length[0];
        if (rectangles[a0].length[1] > rectangles[a1].length[1]) {
            length1 = rectangles[a0].length[1];
        }
        else {
            length1 = rectangles[a1].length[1];
        }
        if (rectangles[a2].length[0] > length0) {
            length0 = rectangles[a2].length[0];
        }
        length1 += rectangles[a2].length[1];
        length0 += rectangles[a3].length[0];
        if (rectangles[a3].length[1] > length1) {
            length1 = rectangles[a3].length[1];
        }
        update(length0, length1);

        length0 = rectangles[a0].length[0] + rectangles[a1].length[0];
        if (rectangles[a0].length[1] > rectangles[a1].length[1]) {
            length1 = rectangles[a0].length[1];
        }
        else {
            length1 = rectangles[a1].length[1];
        }
        if (rectangles[a2].length[0] > length0) {
            length0 = rectangles[a2].length[0];
        }
        length1 += rectangles[a2].length[1];
        if (rectangles[a3].length[0] > length0) {
            length0 = rectangles[a3].length[0];
        }
        length1 += rectangles[a3].length[1];
        update(length0, length1);

        if (rectangles[a1].length[0] >= rectangles[a0].length[0] &&
            rectangles[a1].length[1] <= rectangles[a2].length[1]) {
            if (rectangles[a0].length[0] + rectangles[a3].length[0] >
                rectangles[a1].length[0] + rectangles[a2].length[0]) {
                length0 = rectangles[a0].length[0] + rectangles[a3].length[0];
            }
            else {
                length0 = rectangles[a1].length[0] + rectangles[a2].length[0];
            }
            if (rectangles[a0].length[1] + rectangles[a1].length[1] >
                rectangles[a2].length[1] + rectangles[a3].length[1]) {
                length1 = rectangles[a0].length[1] + rectangles[a1].length[1];
            }
            else {
                length1 = rectangles[a2].length[1] + rectangles[a3].length[1];
            }
            update(length0, length1);
        }
    }

    static void update(int a, int b) {
        if (a > b) {
            update(b, a);
        }
        else {
            if (a * b < area) {
                area = a * b;
                result = new ArrayList<Rectangle> ();
                result.add(new Rectangle(a, b));
            }
            else if (a * b == area) {
                Rectangle temp = new Rectangle(a, b);
                if (result.contains(temp) == false) {
                    result.add(temp);
                }
            }
        }
    }
}

class Rectangle
    implements Comparable<Rectangle> {
    int length[];
    public Rectangle(int a, int b) {
        this.length = new int[2];
        this.length[0] = a;
        this.length[1] = b;
    }

    public void rotate() {
        int temp = this.length[0];
        this.length[0] = this.length[1];
        this.length[1] = temp;
    }

    public int compareTo(Rectangle another) {
        return this.length[0] - another.length[0];
    }

    public boolean equals(Object another) {
        Rectangle a = (Rectangle) another;
        if (this.length[0] == a.length[0] && this.length[1] == a.length[1]) {
            return true;
        }
        else {
            return false;
        }
    }
}
