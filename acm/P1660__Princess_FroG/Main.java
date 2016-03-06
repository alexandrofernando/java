package P1660__Princess_FroG;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-14
 * Time: 8:32:58
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static ArrayList<Integer> rope;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            rope = new ArrayList<Integer>();
            while (true) {
                String str = in.next();
                int temp;
                if (str.charAt(0) == '+') {
                    temp = Integer.parseInt(str.substring(1));
                } else {
                    temp = Integer.parseInt(str);
                }
                if (temp == 0) {
                    break;
                }
                rope.add(temp);
            }
            while (true) {
                if (rope.isEmpty() == true) {
                    System.out.println("Right");
                    break;
                }
                if (removeSingle() == false && removeDouble() == false) {
                    System.out.println("Not right");
                    break;
                }
            }
        }
    }

    static boolean removeSingle() {
        int size = rope.size();
        for (int start = 0; start < size; start++) {
            int end = rope.indexOf(-rope.get(start));
            boolean power = true;
            int temp = rope.get((start + 1) % size);
            ArrayList<Integer> array = new ArrayList<Integer>();
            array.add(rope.get(start));
            for (int j = (start + 1) % size; j != end; j = (j + 1) % size) {
                if (rope.get(j) * temp < 0) {
                    power = false;
                    break;
                }
                array.add(rope.get(j));
            }
            if (power == true) {
                for (int j = 0; j < array.size(); j++) {
                    int number = array.get(j);
                    rope.remove(new Integer(number));
                    rope.remove(new Integer(-number));
                }
                return true;
            }
        }
        return false;
    }

    static boolean removeDouble() {
        int size = rope.size();
        for (int start1 = 0; start1 < size; start1++) {
            int start2 = (start1 + 1) % size;
            while (rope.get(start2) * rope.get(start1) < 0) {
                start2 = (start2 + 1) % size;
            }
            int end1 = rope.indexOf(-rope.get(start1));
            int end2 = rope.indexOf(-rope.get(start2));
            if (isSameSign(end1, end2) == true) {
                reconstruct(start1, start2, end1, end2);
                return true;
            }
            if (isSameSign(end2, end1) == true) {
                reverse(start1, start2);
                reverse(end2, end1);
                reconstruct(start1, start2, end2, end1);
                return true;
            }
        }
        return false;
    }

    static boolean isSameSign(int start, int end) {
        int size = rope.size();
        int temp = rope.get(start);
        for (int i = (start + 1) % size; i != end; i = (i + 1) % size) {
            if (rope.get(i) * temp < 0) {
                return false;
            }
        }
        return true;
    }

    static void reconstruct(int start1, int start2, int end1, int end2) {
        int size = rope.size();
        ArrayList<Integer> newRope = new ArrayList<Integer>();
        for (int i = (end1 + 1) % size; i != end2; i = (i + 1) % size) {
            newRope.add(rope.get(i));
        }
        for (int i = (start2 + 1) % size; i != end1; i = (i + 1) % size) {
            newRope.add(rope.get(i));
        }
        for (int i = (start1 + 1) % size; i != start2; i = (i + 1) % size) {
            newRope.add(rope.get(i));
        }
        for (int i = (end2 + 1) % size; i != start1; i = (i + 1) % size) {
            newRope.add(rope.get(i));
        }
        rope = newRope;
    }

    static void reverse(int start, int end) {
        int size = rope.size();
        if ((start + 1) % size == end) {
            return;
        }
        int pos1 = (start + 1) % size;
        int pos2 = (end - 1 + size) % size;
        while (true) {
            int temp = rope.get(pos1);
            rope.set(pos1, rope.get(pos2));
            rope.set(pos2, temp);
            if (pos1 == pos2 || (pos1 + 1) % size == pos2) {
                break;
            }
            pos1 = (pos1 + 1) % size;
            pos2 = (pos2 - 1 + size) % size;
        }
    }
}
