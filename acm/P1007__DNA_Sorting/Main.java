package P1007__DNA_Sorting;

import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        DNA_Sortedness list[] = new DNA_Sortedness[m];
        for (int i = 0; i < m; i++) {
            String DNA = cin.next();
            int sortedness = 0;
            for (int j = 0; j < DNA.length(); j++) {
                for (int k = j + 1; k < DNA.length(); k++) {
                    if (DNA.charAt(j) > DNA.charAt(k)) {
                        sortedness++;
                    }
                }
            }
            list[i] = new DNA_Sortedness(DNA, sortedness);
        }
        Arrays.sort(list, new MyComparator());
        for (int i = 0; i < m; i++) {
            System.out.println(list[i].DNA);
        }
    }
}

class DNA_Sortedness {
    String DNA;
    int sortedness;
    public DNA_Sortedness(String theDNA, int theSortedness) {
        DNA = theDNA;
        this.sortedness = theSortedness;
    }
}

class MyComparator
    implements Comparator<DNA_Sortedness> {
    public int compare(DNA_Sortedness o1, DNA_Sortedness o2) {
        if (o1.sortedness < o2.sortedness) {
            return -1;
        }
        else if (o1.sortedness > o2.sortedness) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
