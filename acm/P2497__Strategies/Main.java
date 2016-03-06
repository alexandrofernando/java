package P2497__Strategies;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int time = cin.nextInt();
            int n = cin.nextInt();
            int problems[] = new int[n];
            for (int i = 0; i < n; i++) {
                problems[i] = cin.nextInt();
            }
            ArrayList<Person> people = new ArrayList<Person>();
            Person s = new Person("Bill", problems, time);
            people.add(s);
            Arrays.sort(problems);
            s = new Person("Steve", problems, time);
            people.add(s);
            for (int i = 0; i * 2 < n; i++) {
                int temp = problems[i];
                problems[i] = problems[n - i - 1];
                problems[n - i - 1] = temp;
            }
            s = new Person("Linus", problems, time);
            people.add(s);
            Collections.sort(people);
            System.out.println("Scenario #" + t + ":");
            if (people.get(0).compareTo(people.get(1)) == 0) {
                for (int i = 0; i < 3; i++) {
                    Person person = people.get(i);
                    if (person.name.equals("Steve") == true) {
                        System.out.println("Steve wins with " + person.solve +
                                           " solved problems and a score of " +
                                           person.score + ".");
                        break;
                    }
                }
            } else {
                Person person = people.get(0);
                System.out.println(person.name + " wins with " + person.solve +
                                   " solved problems and a score of " +
                                   person.score + ".");
            }
            System.out.println();
        }
    }
}


class Person implements Comparable<Person> {
    String name;
    int solve;
    int score;

    public Person(String theName, int problems[], int time) {
        this.name = theName;
        this.solve = 0;
        this.score = 0;
        int t = 0;
        for (int i = 0; i < problems.length; i++) {
            if (t + problems[i] <= time) {
                this.solve++;
                t += problems[i];
                this.score += t;
            } else {
                break;
            }
        }
    }

    public int compareTo(Person another) {
        if (this.solve != another.solve) {
            return another.solve - this.solve;
        } else {
            return this.score - another.score;
        }
    }
}
