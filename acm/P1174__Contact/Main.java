package P1174__Contact;

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
        int A = cin.nextInt();
        int B = cin.nextInt();
        int N = cin.nextInt();
        String str = cin.next();
        int count[] = new int[8192];
        int buffers[] = new int[B + 1];
        for (int i = 0; i < str.length() - 1; i++) {
            int digit = str.charAt(i) - '0';
            for (int j = (i + 1 <= B) ? (i + 1) : B; j >= 1; j--) {
                if (j == 1) {
                    buffers[j] = 2 + digit;
                }
                else {
                    buffers[j] = buffers[j - 1] * 2 + digit;
                }
                count[buffers[j]]++;
            }
        }
        ArrayList<Pattern_Frequency> array = new ArrayList<Pattern_Frequency> ();
        int bottom = (int) Math.pow(2, A);
        int top = (int) Math.pow(2, B + 1);
        for (int i = bottom; i < top; i++) {
            if (count[i] > 0) {
                array.add(new Pattern_Frequency(i, count[i]));
            }
        }
        Collections.sort(array);
        int number = 0;
        for (int i = 0; i < array.size(); i++) {
            if (i == 0 || array.get(i).frequency != array.get(i - 1).frequency) {
                number++;
                if (number > N) {
                    break;
                }
                if (i != 0) {
                    System.out.println();
                }
                System.out.print(array.get(i).frequency);
            }
            System.out.print(" " + convert(array.get(i).pattern));
        }
    }

    static String convert(int pattern) {
        String result = "";
        while (pattern != 1) {
            result = (pattern % 2) + result;
            pattern /= 2;
        }
        return result;
    }
}

class Pattern_Frequency
    implements Comparable<Pattern_Frequency> {
    int pattern;
    int frequency;
    public Pattern_Frequency(int thePattern, int theFrequency) {
        this.pattern = thePattern;
        this.frequency = theFrequency;
    }

    public int compareTo(Pattern_Frequency another) {
        if (this.frequency != another.frequency) {
            return another.frequency - this.frequency;
        }
        else {
            return another.pattern - this.pattern;
        }
    }
}
