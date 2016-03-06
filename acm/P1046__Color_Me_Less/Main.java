package P1046__Color_Me_Less;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        Color target[] = new Color[16];
        for (int i = 0; i < target.length; i++) {
            target[i] = new Color(cin.nextInt(), cin.nextInt(), cin.nextInt());
        }
        int r = cin.nextInt();
        int g = cin.nextInt();
        int b = cin.nextInt();
        while (r != -1 || g != -1 || b != -1) {
            Color temp = new Color(r, g, b);
            int index = -1;
            int min = 0;
            for (int i = 0; i < target.length; i++) {
                if (index == -1) {
                    index = 0;
                    min = temp.distance(target[i]);
                }
                else {
                    int dis = temp.distance(target[i]);
                    if (dis < min) {
                        index = i;
                        min = dis;
                    }
                }
            }
            System.out.println(temp + " maps to " + target[index]);
            r = cin.nextInt();
            g = cin.nextInt();
            b = cin.nextInt();
        }
    }
}

class Color {
    int R, G, B;
    public Color(int theR, int theG, int theB) {
        this.R = theR;
        this.G = theG;
        this.B = theB;
    }

    public int distance(Color a) {
        return (this.R - a.R) * (this.R - a.R) + (this.G - a.G) * (this.G - a.G) +
            (this.B - a.B) * (this.B - a.B);
    }

    public String toString() {
        return "(" + this.R + "," + this.G + "," + this.B + ")";
    }
}
