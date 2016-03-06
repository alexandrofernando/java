package P2643__Election;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-25
 * Time: 21:04:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Candidate candidates[] = new Candidate[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = new Candidate(in.nextLine(), in.nextLine());
        }
        int m = in.nextInt();
        in.nextLine();
        for (int i = 0; i < m; i++) {
            String name = in.nextLine();
            for (int j = 0; j < n; j++) {
                if (candidates[j].name.compareTo(name) == 0) {
                    candidates[j].vote++;
                    break;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (candidates[i].vote > max) {
                max = candidates[i].vote;
            }
        }
        int index = -1;
        boolean tie = false;
        for (int i = 0; i < n; i++) {
            if (candidates[i].vote == max) {
                if (index == -1) {
                    index = i;
                } else {
                    tie = true;
                    break;
                }
            }
        }
        if (tie == true) {
            System.out.println("tie");
        } else {
            System.out.println(candidates[index].party);
        }
    }
}

class Candidate {
    String name;
    String party;
    int vote;

    public Candidate(String theName, String theParty) {
        this.name = theName;
        this.party = theParty;
        this.vote = 0;
    }
}