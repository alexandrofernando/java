package P1044__Date_Bugs;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
    static Computer computers[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        int n = cin.nextInt();
        while (n != 0) {
            System.out.println("Case #" + test + ":");
            test++;
            computers = new Computer[n];
            for (int i = 0; i < n; i++) {
                computers[i] = new Computer(cin.nextInt(), cin.nextInt(),
                                            cin.nextInt());
            }
            Arrays.sort(computers);
            boolean power = false;
            for (int year = computers[0].y; year < 10000;
                 year += computers[0].b - computers[0].a) {
                power = true;
                for (int i = 1; i < n; i++) {
                    if (check(year, i) == false) {
                        power = false;
                        break;
                    }
                }
                if (power == true) {
                    System.out.println("The actual year is " + year + ".");
                    break;
                }
            }
            if (power == false) {
                System.out.println("Unknown bugs detected.");
            }
            System.out.println();
            n = cin.nextInt();
        }
    }

    static boolean check(int year, int index) {
        if (year < computers[index].a) {
            return false;
        }
        int display = (year - computers[index].a) %
            (computers[index].b - computers[index].a) + computers[index].a;
        return display == computers[index].y;
    }
}

class Computer
    implements Comparable<Computer> {
    int y;
    int a;
    int b;
    public Computer(int Y, int A, int B) {
        this.y = Y;
        this.a = A;
        this.b = B;
    }

    public int compareTo(Computer another) {
        return (another.b - another.a) - (this.b - this.a);
    }
}
