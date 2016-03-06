package P1010__Stamps;

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
    static Result result;
    static ArrayList<Integer> types;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext() == true) {
            types = new ArrayList<Integer> ();
            do {
                int temp = cin.nextInt();
                if (temp == 0) {
                    break;
                }
                types.add(temp);
            }
            while (true);
            Collections.sort(types);
            do {
                int request = cin.nextInt();
                if (request == 0) {
                    break;
                }
                result = new Result(request);
                if (search(0, request, 0, new ArrayList<Integer> (), 0) == true) {
                    System.out.print(request + " (" + result.typeNumber + "):");
                    if (result.tie == true) {
                        System.out.print(" tie");
                    }
                    else {
                        for (int i = 0; i < result.stamps.size(); i++) {
                            System.out.print(" " +
                                             types.get(result.stamps.get(i)));
                        }
                    }
                    System.out.println();
                }
                else {
                    System.out.println(request + " ---- none");
                }
            }
            while (true);
        }
    }

    static boolean search(int depth, int rest, int different,
                          ArrayList<Integer> current, int biggest) {
        if (rest == 0) {
            if (different > result.typeNumber ||
                (different == result.typeNumber &&
                 current.size() < result.stamps.size()) ||
                (different == result.typeNumber &&
                 current.size() == result.stamps.size() &&
                 biggest > result.highest)) {
                result.typeNumber = different;
                result.stamps = new ArrayList<Integer> ();
                for (int i = 0; i < current.size(); i++) {
                    result.stamps.add(current.get(i));
                }
                result.highest = biggest;
                result.tie = false;
            }
            else if (different == result.typeNumber &&
                     current.size() == result.stamps.size() &&
                     biggest == result.highest) {
                result.tie = true;
            }
            return true;
        }
        if (depth == 4 || different + 4 - depth < result.typeNumber ||
            types.get(types.size() - 1) * (4 - depth) < rest) {
            return false;
        }
        boolean power = false;
        int start = 0;
        if (current.isEmpty() == false) {
            start = current.get(current.size() - 1);
        }
        for (int i = start; i < types.size(); i++) {
            if (types.get(i) <= rest) {
                int tempDifferent = different;
                int tempBiggest = biggest;
                if (current.contains(i) == false) {
                    tempDifferent++;
                }
                if (types.get(i) > biggest) {
                    biggest = types.get(i);
                }
                current.add(i);
                if (search(depth + 1, rest - types.get(i), tempDifferent,
                           current, tempBiggest) == true) {
                    power = true;
                }
                current.remove(current.size() - 1);
            }
        }
        return power;
    }
}

class Result {
    int request;
    int typeNumber;
    ArrayList<Integer> stamps;
    int highest;
    boolean tie;
    public Result(int theRequest) {
        this.request = theRequest;
        this.typeNumber = 0;
        this.stamps = new ArrayList<Integer> ();
        this.highest = 0;
        this.tie = false;
    }
}
