package P1042__Gone_Fishing;

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
        int n = cin.nextInt();
        while (n != 0) {
            int h = cin.nextInt();
            Lake lakes[] = new Lake[n];
            for (int i = 0; i < n; i++) {
                lakes[i] = new Lake();
                lakes[i].fish = cin.nextInt();
            }
            for (int i = 0; i < n; i++) {
                lakes[i].decrease = cin.nextInt();
            }
            int time[] = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                time[i] = cin.nextInt();
            }
            Result result = new Result( -1);
            for (int i = 0; i < n; i++) {
                int restTime = h * 60;
                for (int j = 0; j < i; j++) {
                    restTime -= time[j] * 5;
                }
                for (int j = 0; j <= i; j++) {
                    lakes[j].init();
                }
                int tempMinutes[] = new int[n];
                int total = 0;
                while (restTime > 0) {
                    int index = 0;
                    for (int j = 0; j <= i; j++) {
                        if (lakes[j].current > lakes[index].current) {
                            index = j;
                        }
                    }
                    tempMinutes[index] += 5;
                    total += lakes[index].current;
                    lakes[index].change();
                    restTime -= 5;
                }
                if (total > result.max) {
                    result = new Result(tempMinutes, total);
                }
            }
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    System.out.print(result.minutes[i]);
                }
                else {
                    System.out.print(", " + result.minutes[i]);
                }
            }
            System.out.println();
            System.out.println("Number of fish expected: " + result.max);
            System.out.println();
            n = cin.nextInt();
        }
    }
}

class Lake {
    int fish;
    int decrease;
    int current;
    public Lake() {
    }

    public Lake(int theFish, int theDecrease) {
        this.fish = theFish;
        this.decrease = theDecrease;
    }

    public void init() {
        this.current = this.fish;
    }

    public void change() {
        if (this.current >= this.decrease) {
            this.current -= this.decrease;
        }
        else {
            this.current = 0;
        }
    }
}

class Result {
    int minutes[];
    int max;
    public Result(int theMax) {
        this.max = theMax;
    }

    public Result(int theMinutes[], int theMax) {
        this.minutes = new int[theMinutes.length];
        System.arraycopy(theMinutes, 0, this.minutes, 0, theMinutes.length);
        this.max = theMax;
    }
}
