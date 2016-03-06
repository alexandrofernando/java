package P1015__Jury_Compromise;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
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
        int test = 1;
        int n = cin.nextInt();
        int m = cin.nextInt();
        while (n != 0 || m != 0) {
            Candidate candidates[] = new Candidate[n + 1];
            for (int i = 1; i <= n; i++) {
                candidates[i] = new Candidate(cin.nextInt(), cin.nextInt());
            }
            Element element = new Element(m);
            element.possible[m * 20] = true;
            element.sum[m * 20] = 0;
            element.path[m * 20] = new ArrayList<Integer> ();
            for (int i = 0; i < m; i++) {
                Element temp = new Element(m);
                for (int j = 0; j < m * 40 + 1; j++) {
                    if (element.possible[j] == true) {
                        for (int k = 1; k <= n; k++) {
                            if (element.path[j].contains(k) == false) {
                                int index = j + candidates[k].pValue -
                                    candidates[k].dValue;
                                if (temp.possible[index] == false ||
                                    element.sum[j] + candidates[k].pValue +
                                    candidates[k].dValue > temp.sum[index]) {
                                    temp.possible[index] = true;
                                    temp.sum[index] = element.sum[j] +
                                        candidates[k].pValue +
                                        candidates[k].dValue;
                                    temp.path[index] = new ArrayList<Integer> ();
                                    for (int p = 0; p < element.path[j].size();
                                         p++) {
                                        temp.path[index].add(element.path[j].
                                            get(p));
                                    }
                                    temp.path[index].add(k);
                                }
                            }
                        }
                    }
                }
                element = temp;
            }
            int optimum = -1;
            for (int i = 0; i < m * 40 + 1; i++) {
                if (element.possible[i] == true) {
                    int differ1 = Math.abs(i - m * 20);
                    int differ2 = Math.abs(optimum - m * 20);
                    if (differ1 < differ2 ||
                        (differ1 == differ2 &&
                         element.sum[i] > element.sum[optimum])) {
                        optimum = i;
                    }
                }
            }
            System.out.println("Jury #" + test);
            test++;
            int P = (element.sum[optimum] + optimum - m * 20) / 2;
            int D = (element.sum[optimum] - optimum + m * 20) / 2;
            System.out.println("Best jury has value " + P +
                               " for prosecution and value " + D +
                               " for defence:");
            Collections.sort(element.path[optimum]);
            for (int i = 0; i < m; i++) {
                System.out.print(" " + element.path[optimum].get(i));
            }
            System.out.println();
            n = cin.nextInt();
            m = cin.nextInt();
        }
    }
}

class Candidate {
    int pValue;
    int dValue;
    public Candidate(int thePValue, int theDValue) {
        this.pValue = thePValue;
        this.dValue = theDValue;
    }
}

class Element {
    boolean possible[];
    int sum[];
    ArrayList<Integer> path[];
    public Element(int m) {
        this.possible = new boolean[m * 40 + 1];
        this.sum = new int[m * 40 + 1];
        this.path = new ArrayList[m * 40 + 1];
    }
}
