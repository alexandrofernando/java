package P2492__A_Bug_s_Life;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    static int bugs[];
    static int rels[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            bugs = new int[n + 1];
            rels = new int[n + 1];
            boolean suspicious = false;
            int interaction = cin.nextInt();
            for (int i = 0; i < interaction; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                if (suspicious == false) {
                    Head_Relation hr1 = head(a);
                    Head_Relation hr2 = head(b);
                    if (hr1.head == hr2.head && hr1.relation == hr2.relation) {
                        suspicious = true;
                    } else if (hr1.head != hr2.head) {
                        bugs[hr2.head] = hr1.head;
                        rels[hr2.head] = (hr1.relation + hr2.relation + 1) % 2;
                    }
                }
            }
            System.out.println("Scenario #" + t + ":");
            if (suspicious == true) {
                System.out.println("Suspicious bugs found!");
            } else {
                System.out.println("No suspicious bugs found!");
            }
            System.out.println();
        }
    }

    static Head_Relation head(int index) {
        int relation = 0;
        while (bugs[index] != 0) {
            relation = (relation + rels[index]) % 2;
            index = bugs[index];
        }
        return new Head_Relation(index, relation);
    }
}


class Head_Relation {
    int head;
    int relation;
    public Head_Relation(int theHead, int theRelation) {
        this.head = theHead;
        this.relation = theRelation;
    }
}
