package P1117__Pairs_Of_Integers;

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
        int N = cin.nextInt();
        int length = (int) Math.floor(Math.log10(N)) + 1;
        ArrayList<Pair> pairs = new ArrayList<Pair> ();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                for (int j = 0; j < 10; j++) {
                    if ( (N - j) % 11 == 0) {
                        int A = (N - j) / 11;
                        Pair s = new Pair(A * 10 + j, A);
                        if (pairs.contains(s) == false) {
                            pairs.add(s);
                        }
                    }
                }
            }
            else {
                int base = (int) Math.pow(10, i);
                int head = N / base;
                int tail = N % base;
                if (tail % 2 == 0) {
                    for (int j = 0; j < 2; j++) {
                        int B = tail / 2;
                        for (int k = 0; k < 10; k++) {
                            if ( (head - k) % 11 == 0) {
                                int A = (head - k) / 11;
                                if (k != 0 || A != 0) {
                                    Pair s = new Pair( (A * 10 + k) * base + B,
                                        A * base + B);
                                    if (pairs.contains(s) == false) {
                                        pairs.add(s);
                                    }
                                }
                            }
                        }
                        head -= 1;
                        tail += base;
                    }
                }
            }
        }
        Collections.sort(pairs);
        int number = pairs.size();
        System.out.println(number);
        for (int i = 0; i < number; i++) {
            Pair pair = pairs.get(i);
            String strX = pair.x + "";
            String strY = pair.y + "";
            int lenX = strX.length();
            int lenY = strY.length();
            for (int j = 0; j < lenX - lenY - 1; j++) {
                strY = "0" + strY;
            }
            System.out.println(strX + " + " + strY + " = " + N);
        }
    }
}

class Pair
    implements Comparable<Pair> {
    int x;
    int y;
    public Pair(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public int compareTo(Pair another) {
        return this.x - another.x;
    }

    public boolean equals(Object a) {
        Pair another = (Pair) a;
        if (this.x == another.x && this.y == another.y) {
            return true;
        }
        else {
            return false;
        }
    }
}
