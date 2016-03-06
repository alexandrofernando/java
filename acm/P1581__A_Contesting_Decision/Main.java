package P1581__A_Contesting_Decision;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-8
 * Time: 8:10:57
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        Team teams[] = new Team[number];
        for (int i = 0; i < number; i++) {
            teams[i] = new Team(in.next());
            for (int j = 0; j < 4; j++) {
                teams[i].subs[j] = in.nextInt();
                teams[i].times[j] = in.nextInt();
            }
            teams[i].calculate();
        }
        Arrays.sort(teams);
        System.out.println(teams[0].name + " " + teams[0].solve + " " + teams[0].penalty);
    }
}

class Team implements Comparable<Team> {
    String name;
    int subs[];
    int times[];
    int solve;
    int penalty;

    public Team(String theName) {
        this.name = theName;
        this.subs = new int[4];
        this.times = new int[4];
    }

    void calculate() {
        this.solve = 0;
        this.penalty = 0;
        for (int i = 0; i < 4; i++) {
            if (this.times[i] > 0) {
                this.solve++;
                this.penalty += this.times[i] + (this.subs[i] - 1) * 20;
            }
        }
    }

    public int compareTo(Team another) {
        if (this.solve != another.solve) {
            return another.solve - this.solve;
        } else {
            return this.penalty - another.penalty;
        }
    }
}