package P1188__Gleaming_The_Cubes;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            Cuboid intersection = null;
            for (int i = 0; i < n; i++) {
                Cuboid cube = new Cuboid(cin.nextInt(), cin.nextInt(),
                                         cin.nextInt(), cin.nextInt());
                if (i == 0) {
                    intersection = cube;
                }
                else if (intersection != null) {
                    intersection = Cuboid.intersect(intersection, cube);
                }
            }
            if (intersection == null) {
                System.out.println(0);
            }
            else {
                System.out.println(intersection.getVolume());
            }
        }
        while (true);
    }
}

class Cuboid {
    int minX, minY, minZ;
    int maxX, maxY, maxZ;
    public Cuboid() {
    }

    public Cuboid(int theMinX, int theMinY, int theMinZ, int extension) {
        this.minX = theMinX;
        this.minY = theMinY;
        this.minZ = theMinZ;
        this.maxX = theMinX + extension;
        this.maxY = theMinY + extension;
        this.maxZ = theMinZ + extension;
    }

    static Cuboid intersect(Cuboid a, Cuboid b) {
        Cuboid c = new Cuboid();
        c.minX = Math.max(a.minX, b.minX);
        c.minY = Math.max(a.minY, b.minY);
        c.minZ = Math.max(a.minZ, b.minZ);
        c.maxX = Math.min(a.maxX, b.maxX);
        c.maxY = Math.min(a.maxY, b.maxY);
        c.maxZ = Math.min(a.maxZ, b.maxZ);
        if (c.minX >= c.maxX || c.minY >= c.maxY || c.minZ >= c.maxZ) {
            return null;
        }
        else {
            return c;
        }
    }

    int getVolume() {
        return (this.maxX - this.minX) * (this.maxY - this.minY) *
            (this.maxZ - this.minZ);
    }
}
