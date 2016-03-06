package P3664__Election_Time;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-10
 * Time: 20:17:15
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        Vote votes[] = new Vote[N];
        for (int i = 0; i < N; i++) {
            votes[i] = new Vote(i + 1, in.nextInt(), in.nextInt());
        }
        Arrays.sort(votes);
        int president = 0;
        for (int i = 1; i < K; i++) {
            if (votes[i].second > votes[president].second) {
                president = i;
            }
        }
        System.out.println(votes[president].index);
    }
}

class Vote implements Comparable<Vote> {
    int index;
    int first;
    int second;

    Vote(int theIndex, int theFirst, int theSecond) {
        this.index = theIndex;
        this.first = theFirst;
        this.second = theSecond;
    }

    public int compareTo(Vote another) {
        return another.first - this.first;
    }
}