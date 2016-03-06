package P1029__False_Coin;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        boolean coin[] = new boolean[n + 1];
        Weighting weighting = new Weighting();
        LinkedList<Integer> lightUnion = new LinkedList<Integer> ();
        LinkedList<Integer> heavyUnion = new LinkedList<Integer> ();
        boolean power = false;
        ListIterator<Integer> iterator;
        for (int i = 0; i < k; i++) {
            weighting.left = new LinkedList<Integer> ();
            weighting.right = new LinkedList<Integer> ();
            int p = cin.nextInt();
            for (int j = 0; j < p; j++) {
                weighting.left.add(cin.nextInt());
            }
            for (int j = 0; j < p; j++) {
                weighting.right.add(cin.nextInt());
            }
            weighting.relation = cin.next();
            if (weighting.relation.equals("=") == true) {
                iterator = weighting.left.listIterator();
                while (iterator.hasNext() == true) {
                    coin[iterator.next().intValue()] = true;
                }
                iterator = weighting.right.listIterator();
                while (iterator.hasNext() == true) {
                    coin[iterator.next().intValue()] = true;
                }
            }
            else {
                if (weighting.relation.equals(">") == true) {
                    LinkedList<Integer> temp = weighting.left;
                    weighting.left = weighting.right;
                    weighting.right = temp;
                }
                if (power == false) {
                    iterator = weighting.left.listIterator();
                    while (iterator.hasNext() == true) {
                        lightUnion.add(iterator.next().intValue());
                    }
                    iterator = weighting.right.listIterator();
                    while (iterator.hasNext() == true) {
                        heavyUnion.add(iterator.next().intValue());
                    }
                    power = true;
                }
                else {
                    iterator = lightUnion.listIterator();
                    while (iterator.hasNext() == true) {
                        if (weighting.left.contains(iterator.next()) == false) {
                            iterator.remove();
                        }
                    }
                    iterator = heavyUnion.listIterator();
                    while (iterator.hasNext() == true) {
                        if (weighting.right.contains(iterator.next()) == false) {
                            iterator.remove();
                        }
                    }
                }
            }
        }
        iterator = lightUnion.listIterator();
        while (iterator.hasNext() == true) {
            if (coin[iterator.next().intValue()] == true) {
                iterator.remove();
            }
        }
        iterator = heavyUnion.listIterator();
        while (iterator.hasNext() == true) {
            if (coin[iterator.next().intValue()] == true) {
                iterator.remove();
            }
        }
        if (lightUnion.size() == 0 && heavyUnion.size() == 1) {
            System.out.println(heavyUnion.get(0));
        }
        else if (lightUnion.size() == 1 && heavyUnion.size() == 0) {
            System.out.println(lightUnion.get(0));
        }
        else if (power == false) {
            boolean determine = true;
            int result = -1;
            for (int i = 1; i <= n; i++) {
                if (coin[i] == false) {
                    if (result == -1) {
                        result = i;
                    }
                    else {
                        determine = false;
                        break;
                    }
                }
            }
            if (determine == true) {
                System.out.println(result);
            }
            else {
                System.out.println("0");
            }
        }
        else {
            System.out.println("0");
        }
    }
}

class Weighting {
    LinkedList<Integer> left, right;
    String relation;
}
