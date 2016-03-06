package P1129__Channel_Allocation;

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
    static int min;
    static int number;
    static Repeater repeaters[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            number = cin.nextInt();
            if (number == 0) {
                break;
            }
            repeaters = new Repeater[number];
            for (int i = 0; i < number; i++) {
                repeaters[i] = new Repeater();
                String temp = cin.next().substring(2);
                for (int j = 0; j < temp.length(); j++) {
                    repeaters[i].adjacent.add(temp.charAt(j) - 'A');
                }
            }
            min = 30;
            search(0, 0);
            if (min == 1) {
                System.out.println("1 channel needed.");
            }
            else {
                System.out.println(min + " channels needed.");
            }
        }
        while (true);
    }

    static void search(int depth, int need) {
        if (depth == number) {
            if (need < min) {
                min = need;
            }
        }
        else {
            boolean used[] = new boolean[need + 1];
            for (int i = 0; i < repeaters[depth].adjacent.size(); i++) {
                int index = repeaters[depth].adjacent.get(i);
                if (index < depth) {
                    used[repeaters[index].channel] = true;
                }
            }
            for (int i = 1; i <= need; i++) {
                if (used[i] == false) {
                    repeaters[depth].channel = i;
                    search(depth + 1, need);
                }
            }
            if (need + 1 < min) {
                repeaters[depth].channel = need + 1;
                search(depth + 1, need + 1);
            }
        }
    }
}

class Repeater {
    int channel;
    ArrayList<Integer> adjacent = new ArrayList<Integer> ();
    public Repeater() {
        this.adjacent = new ArrayList<Integer> ();
    }
}
