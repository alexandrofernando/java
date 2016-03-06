package P1093__Formatting_Text;

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
        int n = cin.nextInt();
        while (n != 0) {
            ArrayList<Element> elements = new ArrayList<Element> ();
            ArrayList<String> words = new ArrayList<String> ();
            int index = 0;
            cin.nextLine();
            do {
                String line = cin.nextLine();
                if (line.equals("") == true) {
                    break;
                }
                Scanner cin1 = new Scanner(line);
                while (cin1.hasNext() == true) {
                    words.add(cin1.next());
                    Element s = new Element();
                    int length = 0;
                    for (int i = index; i >= 0; i--) {
                        length += words.get(i).length();
                        if (n - length >= index - i) {
                            Element temp = new Element();
                            if (i > 0) {
                                temp.badness = elements.get(i - 1).badness;
                                for (int j = 0;
                                     j < elements.get(i - 1).lines.size(); j++) {
                                    temp.lines.add(elements.get(i - 1).lines.
                                        get(j));
                                }
                            }
                            else {
                                temp.badness = 0;
                            }
                            if (i == index) {
                                if (length != n) {
                                    temp.badness += 500;
                                }
                            }
                            else {
                                int start = (n - length) / (index - i);
                                int countStart = index - i -
                                    (n - length) % (index - i);
                                int end = start + 1;
                                int countEnd = (n - length) % (index - i);
                                temp.badness += (start - 1) * (start - 1) *
                                    countStart;
                                temp.badness += (end - 1) * (end - 1) *
                                    countEnd;
                            }
                            temp.lines.add(new Line(i, index, n - length));
                            if (compare(s, temp) > 0) {
                                s = temp;
                            }
                        }
                        else {
                            break;
                        }
                    }
                    elements.add(s);
                    index++;
                }
            }
            while (true);
            ArrayList<Line> result = elements.get(elements.size() - 1).lines;
            for (int i = 0; i < result.size(); i++) {
                int from = result.get(i).fromIndex;
                int to = result.get(i).toIndex;
                int start = 0;
                int end = 0;
                int countStart = 0;
                if (from != to) {
                    start = result.get(i).space / (to - from);
                    end = start + 1;
                    countStart = to - from - result.get(i).space % (to - from);
                }
                for (int j = from; j <= to; j++) {
                    System.out.print(words.get(j));
                    if (j != to) {
                        int count;
                        if (j - from + 1 <= countStart) {
                            count = start;
                        }
                        else {
                            count = end;
                        }
                        for (int k = 0; k < count; k++) {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
            System.out.println();
            n = cin.nextInt();
        }
    }

    static int compare(Element a, Element b) {
        if (a.badness == -1) {
            return 1;
        }
        if (a.badness != b.badness) {
            return a.badness - b.badness;
        }
        int pos = 0;
        while (true) {
            int spaceA = a.lines.get(pos).space;
            int spaceB = b.lines.get(pos).space;
            if (spaceA != spaceB) {
                return spaceA - spaceB;
            }
            pos++;
        }
    }
}

class Element {
    int badness;
    ArrayList<Line> lines;
    public Element() {
        this.badness = -1;
        this.lines = new ArrayList<Line> ();
    }
}

class Line {
    int fromIndex;
    int toIndex;
    int space;
    public Line(int theFromIndex, int theToIndex, int theSpace) {
        this.fromIndex = theFromIndex;
        this.toIndex = theToIndex;
        this.space = theSpace;
    }
}
