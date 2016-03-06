package P1009__Edge_Detection;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
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
    static int width;
    static LinkedList<RLE> origin;
    static LinkedList<RLE> rows[];
    static LinkedList<RLE> result;
    static int currentValue;
    static int currentLength;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        width = cin.nextInt();
        while (width != 0) {
            System.out.println(width);
            origin = new LinkedList<RLE> ();
            int tempValue = cin.nextInt();
            int tempLength = cin.nextInt();
            while (tempValue != 0 || tempLength != 0) {
                origin.add(new RLE(tempValue, tempLength));
                tempValue = cin.nextInt();
                tempLength = cin.nextInt();
            }
            currentValue = -1;
            currentLength = 0;
            rows = new LinkedList[3];
            fillLine(0);
            if (origin.isEmpty() == true) {
                calculate(0, 0, 1);
                output(true);
            }
            else {
                fillLine(1);
                calculate(0, 0, 2);
                output(false);
                if (origin.isEmpty() == true) {
                    calculate(1, 0, 2);
                    output(true);
                }
                else {
                    int index = 2;
                    while (origin.isEmpty() == false) {
                        fillLine(index);
                        calculate( (index + 2) % 3, (index + 1) % 3, 3);
                        output(false);
                        if (rows[ (index + 2) % 3].size() == 1 &&
                            rows[index].size() == 1) {
                            int value1 = rows[ (index + 2) %
                                3].getFirst().value;
                            int value2 = rows[index].getFirst().value;
                            if (origin.isEmpty() == false) {
                                int value3 = origin.getFirst().value;
                                if (value1 == value2 && value2 == value3) {
                                    RLE first = origin.getFirst();
                                    if (first.length >= width) {
                                        result = new LinkedList<RLE> ();
                                        result.add(new RLE(0,
                                            first.length / width * width));
                                        output(false);
                                        first.length = first.length % width;
                                        if (first.length == 0) {
                                            origin.removeFirst();
                                        }
                                    }
                                }
                            }
                        }
                        index = (index + 1) % 3;
                    }
                    calculate( (index + 2) % 3, (index + 1) % 3, 2);
                    output(true);
                }
            }
            System.out.println("0 0");
            width = cin.nextInt();
        }
        System.out.println(0);
    }

    static void fillLine(int index) {
        rows[index] = new LinkedList<RLE> ();
        int len = 0;
        while (len != width) {
            RLE first = origin.remove(0);
            if (first.length + len <= width) {
                rows[index].add(first);
                len += first.length;
            }
            else {
                rows[index].add(new RLE(first.value, width - len));
                origin.addFirst(new RLE(first.value, first.length - width + len));
                len = width;
            }
        }
    }

    static void calculate(int target, int from, int count) {
        result = new LinkedList<RLE> ();
        result.add(new RLE(0, width));
        int currentRow = from;
        for (int i = 0; i < count; i++) {
            for (int j = -1; j <= 1; j++) {
                LinkedList<RLE> temp = move(currentRow, j);
                LinkedList<RLE> copy = move(target, 0);
                temp = different(copy, temp);
                result = max(result, temp);
            }
            currentRow = (currentRow + 1) % 3;
        }
    }

    static LinkedList<RLE> move(int index, int offset) {
        LinkedList<RLE> result = new LinkedList<RLE> ();
        ListIterator<RLE> iterator = rows[index].listIterator();
        while (iterator.hasNext() == true) {
            RLE one = iterator.next();
            result.add(new RLE(one.value, one.length));
        }
        if (offset == -1) {
            RLE first = result.get(0);
            if (first.length == 1) {
                result.remove(0);
            }
            else {
                first.length--;
            }
            result.add(new RLE( -1, 1));
        }
        else if (offset == 1) {
            result.addFirst(new RLE( -1, 1));
            RLE last = result.getLast();
            if (last.length == 1) {
                result.removeLast();
            }
            else {
                last.length--;
            }
        }
        return result;
    }

    static LinkedList<RLE> different(LinkedList<RLE> a, LinkedList<RLE> b) {
        LinkedList<RLE> c = new LinkedList<RLE> ();
        while (a.isEmpty() == false) {
            RLE first1 = a.getFirst();
            RLE first2 = b.getFirst();
            int tempValue;
            if (first1.value == -1 || first2.value == -1) {
                tempValue = 0;
            }
            else if (first1.value > first2.value) {
                tempValue = first1.value - first2.value;
            }
            else {
                tempValue = first2.value - first1.value;
            }
            int tempLength;
            if (first1.length < first2.length) {
                tempLength = first1.length;
                a.removeFirst();
                first2.length -= first1.length;
            }
            else {
                tempLength = first2.length;
                b.removeFirst();
                first1.length -= first2.length;
                if (first1.length == 0) {
                    a.removeFirst();
                }
            }
            if (c.isEmpty() == true || c.getLast().value != tempValue) {
                c.add(new RLE(tempValue, tempLength));
            }
            else {
                c.getLast().length += tempLength;
            }
        }
        return c;
    }

    static LinkedList<RLE> max(LinkedList<RLE> a, LinkedList<RLE> b) {
        LinkedList<RLE> c = new LinkedList<RLE> ();
        while (a.isEmpty() == false) {
            RLE first1 = a.getFirst();
            RLE first2 = b.getFirst();
            int tempValue;
            if (first1.value > first2.value) {
                tempValue = first1.value;
            }
            else {
                tempValue = first2.value;
            }
            int tempLength;
            if (first1.length < first2.length) {
                tempLength = first1.length;
                a.removeFirst();
                first2.length -= first1.length;
            }
            else {
                tempLength = first2.length;
                b.removeFirst();
                first1.length -= first2.length;
                if (first1.length == 0) {
                    a.removeFirst();
                }
            }
            if (c.isEmpty() == true || c.getLast().value != tempValue) {
                c.add(new RLE(tempValue, tempLength));
            }
            else {
                c.getLast().length += tempLength;
            }
        }
        return c;
    }

    static void output(boolean outputLast) {
        while (result.isEmpty() == false) {
            RLE first = result.removeFirst();
            if (currentValue == first.value) {
                currentLength += first.length;
            }
            else {
                if (currentValue != -1) {
                    System.out.println(currentValue + " " + currentLength);
                }
                currentValue = first.value;
                currentLength = first.length;
            }
        }
        if (outputLast == true) {
            System.out.println(currentValue + " " + currentLength);
        }
    }
}

class RLE {
    int value;
    int length;
    public RLE(int theValue, int theLength) {
        this.value = theValue;
        this.length = theLength;
    }
}
