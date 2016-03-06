package P2777__Count_Color;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-12
 * Time: 15:47:58
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int colors[];
    static boolean appears[];

    public static void main(String args[]) throws Exception {
        final int MAXLEN = 131072;
        colors = new int[MAXLEN * 2 - 1];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = 1;
        }
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int length = Integer.parseInt(st.nextToken());
        int colorNum = Integer.parseInt(st.nextToken());
        int operationNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < operationNum; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            String command = st.nextToken();
            if (command.equals("C")) {
                int begin = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                if (begin > end) {
                    int temp = begin;
                    begin = end;
                    end = temp;
                }
                int color = Integer.parseInt(st.nextToken());
                paint(0, 1, MAXLEN, begin, end, color);
            } else if (command.equals("P")) {
                int begin = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                if (begin > end) {
                    int temp = begin;
                    begin = end;
                    end = temp;
                }
                appears = new boolean[colorNum];
                statistic(0, 1, MAXLEN, begin, end);
                int count = 0;
                for (int j = 0; j < appears.length; j++) {
                    if (appears[j]) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }

    static void statistic(int index, int lower, int upper, int begin, int end) {
        if (colors[index] != 0) {
            appears[colors[index] - 1] = true;
            return;
        }
        int middle = (lower + upper) / 2;
        if (middle >= end) {
            statistic(index * 2 + 1, lower, middle, begin, end);
        } else if (middle + 1 <= begin) {
            statistic(index * 2 + 2, middle + 1, upper, begin, end);
        } else {
            statistic(index * 2 + 1, lower, middle, begin, middle);
            statistic(index * 2 + 2, middle + 1, upper, middle + 1, end);
        }
    }

    static void paint(int index, int lower, int upper, int begin, int end, int color) {
        if (colors[index] == color) {
            return;
        }
        if (lower == begin && upper == end) {
            colors[index] = color;
            return;
        }
        if (colors[index] != 0) {
            colors[index * 2 + 1] = colors[index];
            colors[index * 2 + 2] = colors[index];
        }
        int middle = (lower + upper) / 2;
        if (middle >= end) {
            paint(index * 2 + 1, lower, middle, begin, end, color);
        } else if (middle + 1 <= begin) {
            paint(index * 2 + 2, middle + 1, upper, begin, end, color);
        } else {
            paint(index * 2 + 1, lower, middle, begin, middle, color);
            paint(index * 2 + 2, middle + 1, upper, middle + 1, end, color);
        }
        if (colors[index * 2 + 1] == color && colors[index * 2 + 2] == color) {
            colors[index] = color;
        } else {
            colors[index] = 0;
        }
    }
}