package P2051__Argus;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
        ArrayList<Query> queries = new ArrayList<Query> ();
        while (true) {
            String command = cin.next();
            if (command.equals("#") == true) {
                break;
            }
            queries.add(new Query(cin.nextInt(), cin.nextInt()));
        }
        int K = cin.nextInt();
        for (int i = 0; i < K; i++) {
            int index = 0;
            for (int j = 1; j < queries.size(); j++) {
                Query query1 = queries.get(j);
                Query query2 = queries.get(index);
                if (query1.next < query2.next ||
                    (query1.next == query2.next &&
                     query1.number < query2.number)) {
                    index = j;
                }
            }
            Query query = queries.get(index);
            System.out.println(query.number);
            query.next += query.period;
        }
    }
}

class Query {
    int number;
    int period;
    int next;
    public Query(int theNumber, int thePeriod) {
        this.number = theNumber;
        this.period = thePeriod;
        this.next = thePeriod;
    }
}
