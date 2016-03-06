package P1547__Clay_Bully;

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
        while (true) {
            int n = cin.nextInt();
            if (n == -1) {
                break;
            }
            Student students[] = new Student[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int length = cin.nextInt();
                int width = cin.nextInt();
                int height = cin.nextInt();
                int volume = length * width * height;
                String name = cin.next();
                students[i] = new Student(name, volume);
                sum += volume;
            }
            int average = sum / n;
            String bully = "";
            String victim = "";
            for (int i = 0; i < n; i++) {
                if (students[i].units > average) {
                    bully = students[i].name;
                }
                else if (students[i].units < average) {
                    victim = students[i].name;
                }
            }
            System.out.println(bully + " took clay from " + victim + ".");
        }
    }
}

class Student {
    String name;
    int units;
    public Student(String theName, int theUnits) {
        this.name = theName;
        this.units = theUnits;
    }
}
