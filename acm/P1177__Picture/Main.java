package P1177__Picture;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
        int number = cin.nextInt();
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle> ();
        for (int i = 0; i < number; i++) {
            Rectangle rec = new Rectangle(cin.nextInt(), cin.nextInt(),
                                          cin.nextInt(), cin.nextInt(), 1);
            ArrayList<Rectangle> addition = new ArrayList<Rectangle> ();
            addition.add(rec);
            boolean power = true;
            for (int j = 0; j < rectangles.size(); j++) {
                Rectangle one = rectangles.get(j);
                Rectangle intersection = Rectangle.intersect(rec, one);
                if (intersection != null) {
                    if (intersection.isEqual(rec) == true) {
                        power = false;
                        break;
                    }
                    else {
                        addition.add(intersection);
                    }
                }
            }
            if (power == true) {
                rectangles.addAll(addition);
            }
        }
        int perimeter = 0;
        for (int i = 0; i < rectangles.size(); i++) {
            perimeter += rectangles.get(i).getPerimeter();
        }
        System.out.println(perimeter);
    }
}

class Rectangle {
    int minX;
    int minY;
    int maxX;
    int maxY;
    int sign;
    public Rectangle(int theMinX, int theMinY, int theMaxX, int theMaxY,
                     int theSign) {
        this.minX = theMinX;
        this.minY = theMinY;
        this.maxX = theMaxX;
        this.maxY = theMaxY;
        this.sign = theSign;
    }

    static Rectangle intersect(Rectangle a, Rectangle b) {
        int newMinX = Math.max(a.minX, b.minX);
        int newMinY = Math.max(a.minY, b.minY);
        int newMaxX = Math.min(a.maxX, b.maxX);
        int newMaxY = Math.min(a.maxY, b.maxY);
        if (newMinX > newMaxX || newMinY > newMaxY ||
            (newMinX == newMaxX && newMinY == newMaxY)) {
            return null;
        }
        else {
            return new Rectangle(newMinX, newMinY, newMaxX, newMaxY,
                                 -a.sign * b.sign);
        }
    }

    boolean isEqual(Rectangle another) {
        if (this.minX != another.minX || this.minY != another.minY ||
            this.maxX != another.maxX || this.maxY != another.maxY) {
            return false;
        }
        else {
            return true;
        }
    }

    int getPerimeter() {
        return 2 * this.sign * (this.maxX - this.minX + this.maxY - this.minY);
    }
}
