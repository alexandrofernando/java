package P2014__Flow_Layout;

import java.util.Scanner;
import java.io.File;

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
        while (true) {
            int m = cin.nextInt();
            if (m == 0) {
                break;
            }
            int maxWidth = 0;
            int maxHeight = 0;
            int floorWidth = 0;
            int floorHeight = 0;
            while (true) {
                int width = cin.nextInt();
                int height = cin.nextInt();
                if (width == -1 && height == -1) {
                    break;
                }
                if (floorWidth + width <= m) {
                    floorWidth += width;
                    if (height > floorHeight) {
                        floorHeight = height;
                    }
                } else {
                    if (floorWidth > maxWidth) {
                        maxWidth = floorWidth;
                    }
                    maxHeight += floorHeight;
                    floorWidth = width;
                    floorHeight = height;
                }
            }
            if (floorWidth > maxWidth) {
                maxWidth = floorWidth;
            }
            maxHeight += floorHeight;
            System.out.println(maxWidth + " x " + maxHeight);
        }
    }
}
