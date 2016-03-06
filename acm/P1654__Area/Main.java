package P1654__Area;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-5
 * Time: 6:33:49
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            long area = 0;
            String str = in.next();
            int x = 0;
            int y = 0;
            int offsetX[] = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
            int offsetY[] = {0, -1, -1, -1, 0, 0, 0, 1, 1, 1};
            for (int i = 0; i < str.length() - 1; i++) {
                char ch = str.charAt(i);
                int currentX = x + offsetX[ch - '0'];
                int currentY = y + offsetY[ch - '0'];
                area += (y * currentX - x * currentY);
                x = currentX;
                y = currentY;
            }
            if (area < 0) {
                area = -area;
            }
            if (area % 2 == 0) {
                System.out.println(area / 2);
            } else {
                System.out.println(area / 2.0);
            }
        }
    }
}
