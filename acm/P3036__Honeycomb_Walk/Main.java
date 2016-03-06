package P3036__Honeycomb_Walk;

import java.util.Scanner;
import java.util.Hashtable;
import java.util.Map;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-25
 * Time: 5:49:33
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Hashtable<Coordinate, Integer> table = new Hashtable<Coordinate, Integer>();
        table.put(new Coordinate(0, 0), 1);
        int results[] = new int[15];
        for (int i = 1; i <= 14; i++) {
            Hashtable<Coordinate, Integer> temp = new Hashtable<Coordinate, Integer>();
            Iterator<Map.Entry<Coordinate, Integer>> iterator = table.entrySet().iterator();
            while (iterator.hasNext() == true) {
                Map.Entry<Coordinate, Integer> entry = iterator.next();
                int x = entry.getKey().x;
                int y = entry.getKey().y;
                int offsetX[] = {1, 0, -1, -1, 0, 1};
                int offsetY[] = {0, -1, -1, 0, 1, 1};
                for (int j = 0; j < 6; j++) {
                    int tempX = x + offsetX[j];
                    int tempY = y + offsetY[j];
                    Coordinate coord = new Coordinate(tempX, tempY);
                    if (temp.containsKey(coord) == true) {
                        temp.put(coord, temp.get(coord) + entry.getValue());
                    } else {
                        temp.put(coord, entry.getValue());
                    }
                }
            }
            table = temp;
            Coordinate coord = new Coordinate(0, 0);
            if (table.containsKey(coord) == true) {
                results[i] = table.get(coord);
            } else {
                results[i] = 0;
            }
        }
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            System.out.println(results[n]);
        }
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public int hashCode() {
        return this.x * this.y;
    }

    public boolean equals(Object object) {
        Coordinate another = (Coordinate) object;
        if (this.x == another.x && this.y == another.y) {
            return true;
        } else {
            return false;
        }
    }
}