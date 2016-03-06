package P1121__Algernon_s_Noxious_Emissions;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

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
        int N = cin.nextInt();
        Table tables[] = new Table[N + 1];
        for (int i = 1; i <= N; i++) {
            tables[i] = new Table(cin.next(), cin.next());
        }
        do {
            int start = cin.nextInt();
            int end = cin.nextInt();
            if (start == 0 || end == 0) {
                break;
            }
            tables[start].pipes.add(end);
        }
        while (true);
        LinkedList<Element> queue = new LinkedList<Element> ();
        for (int i = 1; i <= N; i++) {
            ArrayList<Character> temp = copy(tables[i].output);
            for (int j = 0; j < tables[i].pipes.size(); j++) {
                queue.offer(new Element(temp, tables[i].pipes.get(j)));
            }
        }
        while (queue.isEmpty() == false) {
            Element head = queue.poll();
            Table table = tables[head.index];
            ArrayList<Character> rest = copy(head.input);
            subtract(rest, table.decrement);
            subtract(rest, table.output);
            if (rest.isEmpty() == false) {
                for (int i = 0; i < rest.size(); i++) {
                    table.output.add(rest.get(i));
                }
                for (int i = 0; i < table.pipes.size(); i++) {
                    queue.offer(new Element(rest, table.pipes.get(i)));
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(tables[i].output);
            System.out.print(":");
            for (int j = 0; j < tables[i].output.size(); j++) {
                System.out.print(tables[i].output.get(j));
            }
            System.out.println(":");
        }
    }

    static ArrayList<Character> copy(ArrayList<Character> a) {
        ArrayList<Character> result = new ArrayList<Character> ();
        for (int i = 0; i < a.size(); i++) {
            result.add(new Character(a.get(i)));
        }
        return result;
    }

    static void subtract(ArrayList<Character> a, ArrayList<Character> b) {
        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.get(i)) == true) {
                a.remove(i);
                i--;
            }
        }
    }
}

class Table {
    ArrayList<Character> increment;
    ArrayList<Character> decrement;
    ArrayList<Integer> pipes;
    ArrayList<Character> output;
    public Table(String inc, String dec) {
        this.increment = new ArrayList<Character> ();
        this.output = new ArrayList<Character> ();
        if (inc.equals(".") == false) {
            for (int i = 0; i < inc.length(); i++) {
                this.increment.add(inc.charAt(i));
                this.output.add(inc.charAt(i));
            }
        }
        this.decrement = new ArrayList<Character> ();
        if (dec.equals(".") == false) {
            for (int i = 0; i < dec.length(); i++) {
                this.decrement.add(dec.charAt(i));
            }
        }
        this.pipes = new ArrayList<Integer> ();
    }
}

class Element {
    ArrayList<Character> input;
    int index;
    public Element(ArrayList<Character> theInput, int theIndex) {
        this.input = theInput;
        this.index = theIndex;
    }
}
