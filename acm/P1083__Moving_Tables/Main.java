package P1083__Moving_Tables;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.Arrays;
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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            Move temp1[] = new Move[n];
            for (int i = 0; i < n; i++) {
                int start = cin.nextInt();
                int end = cin.nextInt();
                if (start <= end) {
                    temp1[i] = new Move( (start - 1) / 2, (end - 1) / 2);
                }
                else {
                    temp1[i] = new Move( (end - 1) / 2, (start - 1) / 2);
                }
            }
            Arrays.sort(temp1);
            LinkedList move = new LinkedList<Move> (Arrays.asList(temp1));
            int time = 0;
            while (move.isEmpty() == false) {
                int previous = -1;
                ListIterator<Move> iterator = move.listIterator(0);
                while (iterator.hasNext() == true) {
                    Move temp = iterator.next();
                    if (temp.start > previous) {
                        previous = temp.end;
                        iterator.remove();
                    }
                }
                time += 10;
            }
            System.out.println(time);
        }
    }
}

class Move
    implements Comparable<Move> {
    int start;
    int end;
    public Move(int theStart, int theEnd) {
        this.start = theStart;
        this.end = theEnd;
    }

    public int compareTo(Move a) {
        if (this.start < a.start) {
            return -1;
        }
        else if (this.start > a.start) {
            return 1;
        }
        else {
            return this.end - a.end;
        }
    }
}
