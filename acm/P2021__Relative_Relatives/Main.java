package P2021__Relative_Relatives;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-8
 * Time: 6:30:00
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Person persons[];
    static int pos;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int X = in.nextInt();
            persons = new Person[X + 1];
            persons[0] = new Person("Ted");
            persons[0].parent = 0;
            persons[0].age = 100;
            pos = 1;
            for (int i = 0; i < X; i++) {
                String father = in.next();
                int fatherIndex = search(father);
                if (fatherIndex == -1) {
                    persons[pos] = new Person(father);
                    fatherIndex = pos;
                    pos++;
                }
                String child = in.next();
                int childIndex = search(child);
                if (childIndex == -1) {
                    persons[pos] = new Person(child);
                    childIndex = pos;
                    pos++;
                }
                persons[childIndex].parent = fatherIndex;
                persons[childIndex].difference = in.nextInt();
            }
            for (int i = 0; i <= X; i++) {
                calculateAge(i);
            }
            Arrays.sort(persons);
            System.out.println("DATASET " + t);
            for (int i = 1; i <= X; i++) {
                System.out.println(persons[i].name + " " + persons[i].age);
            }
        }
    }

    static int search(String name) {
        for (int i = 0; i < pos; i++) {
            if (persons[i].name.compareTo(name) == 0) {
                return i;
            }
        }
        return -1;
    }

    static int calculateAge(int index) {
        if (persons[index].age == -1) {
            persons[index].age = calculateAge(persons[index].parent) - persons[index].difference;
        }
        return persons[index].age;
    }
}

class Person implements Comparable<Person> {
    String name;
    int parent;
    int difference;
    int age;

    public Person(String theName) {
        this.name = theName;
        this.age = -1;
    }

    public int compareTo(Person another) {
        if (this.age != another.age) {
            return another.age - this.age;
        } else {
            return this.name.compareTo(another.name);
        }
    }
}