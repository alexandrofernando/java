package P1106__Transmitters;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            int x = cin.nextInt();
            int y = cin.nextInt();
            double r = cin.nextDouble();
            if (r < 0) {
                break;
            }
            ArrayList<Double> angles = new ArrayList<Double> ();
            int N = cin.nextInt();
            for (int i = 0; i < N; i++) {
                int tempX = cin.nextInt();
                int tempY = cin.nextInt();
                if ( (tempX - x) * (tempX - x) + (tempY - y) * (tempY - y) <=
                    r * r) {
                    int deltaX = tempX - x;
                    int deltaY = tempY - y;
                    angles.add(Math.atan2(deltaY, deltaX));
                }
            }
            Collections.sort(angles);
            int end = 0;
            int max = 0;
            int size = angles.size();
            for (int i = 0; i < size; i++) {
                do {
                    int count = end - i;
                    double diff = angles.get(end) - angles.get(i);
                    if (diff < 0) {
                        diff += 2 * Math.PI;
                        count += size;
                    }
                    if (diff > Math.PI) {
                        if (count > max) {
                            max = count;
                        }
                        end = (end - 1 + size) % size;
                        break;
                    }
                    else if (count + 1 == size) {
                        max = size;
                        break;
                    }
                    end = (end + 1) % size;
                }
                while (true);
                if (max == size) {
                    break;
                }
            }
            System.out.println(max);
        }
        while (true);
    }
}
