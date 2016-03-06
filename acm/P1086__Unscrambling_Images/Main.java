package P1086__Unscrambling_Images;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            int depth = 0;
            for (int i = 1; i < n; i *= 2) {
                depth++;
            }
            int m = cin.nextInt();
            Path paths[] = new Path[m];
            for (int i = 0; i < m; i++) {
                paths[i] = new Path();
                int node = cin.nextInt();
                while (node > 0) {
                    paths[i].current.add(0, (node - 1) % 4);
                    node = (node - 1) / 4;
                }
                int intensity = cin.nextInt();
                int row = intensity / n;
                int column = intensity % n;
                int size = n;
                while (size > 1) {
                    size /= 2;
                    if (row >= size && column >= size) {
                        paths[i].origin.add(3);
                        row -= size;
                        column -= size;
                    }
                    else if (row >= size) {
                        paths[i].origin.add(2);
                        row -= size;
                    }
                    else if (column >= size) {
                        paths[i].origin.add(1);
                        column -= size;
                    }
                    else {
                        paths[i].origin.add(0);
                    }
                }
            }
            m = cin.nextInt();
            int image[][] = new int[n][n];
            for (int i = 0; i < m; i++) {
                int node = cin.nextInt();
                ArrayList tempPath = new ArrayList<Integer> ();
                while (node > 0) {
                    tempPath.add(0, (node - 1) % 4);
                    node = (node - 1) / 4;
                }
                for (int j = 0; j < paths.length; j++) {
                    boolean equal = true;
                    for (int k = 0; k < tempPath.size(); k++) {
                        if (tempPath.get(k).equals(paths[j].current.get(k)) == false) {
                            equal = false;
                            break;
                        }
                    }
                    if (equal == true) {
                        int intensity = cin.nextInt();
                        fill(image, paths[j].origin, tempPath.size(), n,
                             intensity);
                        break;
                    }
                }
            }
            if (t != 1) {
                System.out.println();
            }
            System.out.println("Case " + t);
            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%4d", image[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void fill(int image[][], ArrayList path, int length, int size,
                            int intensity) {
        int row = 0, column = 0;
        for (int i = 0; i < length; i++) {
            size /= 2;
            int temp = ( (Integer) (path.get(i))).intValue();
            if (temp == 1) {
                column += size;
            }
            else if (temp == 2) {
                row += size;
            }
            else if (temp == 3) {
                row += size;
                column += size;
            }
        }
        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                image[i][j] = intensity;
            }
        }
    }
}

class Path {
    ArrayList current;
    ArrayList origin;
    public Path() {
        current = new ArrayList<Integer> ();
        origin = new ArrayList<Integer> ();
    }
}
