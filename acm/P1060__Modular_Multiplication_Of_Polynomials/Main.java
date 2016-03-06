package P1060__Modular_Multiplication_Of_Polynomials;

import java.util.Scanner;
import java.io.File;
import java.util.TreeSet;
import java.util.Iterator;

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
    static Scanner cin;
    public static void main(String args[]) throws Exception {
        cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            TreeSet<Integer> f = new TreeSet<Integer> ();
            input(f);
            TreeSet<Integer> g = new TreeSet<Integer> ();
            input(g);
            TreeSet<Integer> h = new TreeSet<Integer> ();
            input(h);
            TreeSet<Integer> product = multiply(f, g);
            TreeSet<Integer> remainder = modulo(product, h);
            Integer previous = remainder.last();
            remainder.remove(previous);
            System.out.print(previous + 1);
            System.out.print(" 1");
            while (remainder.isEmpty() == false) {
                Integer current = remainder.last();
                for (int i = 1; i < previous.intValue() - current.intValue(); i++) {
                    System.out.print(" 0");
                }
                System.out.print(" 1");
                previous = current;
                remainder.remove(current);
            }
            for (int i = 0; i < previous.intValue(); i++) {
                System.out.print(" 0");
            }
            System.out.println();
        }
    }

    public static void input(TreeSet<Integer> a) {
        int n = cin.nextInt();
        for (int i = n - 1; i >= 0; i--) {
            if (cin.nextInt() == 1) {
                a.add(i);
            }
        }
    }

    public static TreeSet<Integer> multiply(TreeSet<Integer> a,
                                            TreeSet<Integer> b) {
        TreeSet<Integer> c = new TreeSet<Integer> ();
        Iterator<Integer> iterator = a.iterator();
        while (iterator.hasNext() == true) {
            TreeSet<Integer> temp = multiply(b, iterator.next().intValue());
            c = add(c, temp);
        }
        return c;
    }

    public static TreeSet<Integer> multiply(TreeSet<Integer> a, int b) {
        TreeSet<Integer> c = new TreeSet<Integer> ();
        Iterator<Integer> iterator = a.iterator();
        while (iterator.hasNext() == true) {
            Integer temp = iterator.next();
            c.add(temp.intValue() + b);
        }
        return c;
    }

    public static TreeSet<Integer> add(TreeSet<Integer> a, TreeSet<Integer> b) {
        TreeSet<Integer> c = new TreeSet<Integer> ();
        Iterator<Integer> iterator = a.iterator();
        while (iterator.hasNext() == true) {
            Integer temp = iterator.next();
            if (b.contains(temp) == false) {
                c.add(temp);
            }
        }
        iterator = b.iterator();
        while (iterator.hasNext() == true) {
            Integer temp = iterator.next();
            if (a.contains(temp) == false) {
                c.add(temp);
            }
        }
        return c;
    }

    public static TreeSet<Integer> modulo(TreeSet<Integer> a,
                                          TreeSet<Integer> b) {
        int term = a.last().intValue() - b.last().intValue();
        while (term >= 0) {
            TreeSet<Integer> temp = multiply(b, term);
            a = add(a, temp);
            term = a.last().intValue() - b.last().intValue();
        }
        return a;
    }
}
