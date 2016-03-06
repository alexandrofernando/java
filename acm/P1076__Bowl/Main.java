package P1076__Bowl;

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
        while (cin.hasNext() == true) {
            String name = cin.next();
            Frame frame[] = new Frame[10];
            for (int i = 0; i < 10; i++) {
                frame[i] = new Frame();
            }
            int frameNumber = 0;
            int ball = 0;
            int rest = 0;
            int offset = 0;
            int number = cin.nextInt();
            while (number != -1) {
                if (ball == 0) {
                    if (frameNumber >= 2 &&
                        frame[frameNumber - 1 + offset].bonus == 2 &&
                        frame[frameNumber - 2 + offset].bonus == 1) {
                        frame[frameNumber - 2 + offset].determined = true;
                        frame[frameNumber - 2 + offset].bonus = 0;
                        frame[frameNumber - 2 + offset].score += 10 - number;
                    }
                    if (frameNumber >= 1 &&
                        frame[frameNumber - 1 + offset].bonus > 0) {
                        frame[frameNumber - 1 + offset].bonus--;
                        frame[frameNumber - 1 + offset].score += 10 - number;
                        if (frame[frameNumber - 1 + offset].bonus == 0) {
                            frame[frameNumber - 1 + offset].determined = true;
                        }
                    }
                    if (number == 0) {
                        frame[frameNumber].record.add('X');
                        if (offset == 0) {
                            frame[frameNumber].bonus = 2;
                            frame[frameNumber].score = 10;
                        }
                        if (frameNumber != 9) {
                            frameNumber++;
                        }
                        else {
                            offset = 1;
                        }
                    }
                    else {
                        if (number == 10) {
                            frame[frameNumber].record.add('-');
                        }
                        else {
                            frame[frameNumber].record.add( (char) ('0' + 10 -
                                number));
                        }
                        if (offset == 0) {
                            frame[frameNumber].score = 10 - number;
                        }
                        rest = number;
                        ball = 1;
                    }
                }
                else {
                    if (number == 0) {
                        frame[frameNumber].record.add('/');
                        if (offset == 0) {
                            frame[frameNumber].bonus = 1;
                            frame[frameNumber].score = 10;
                        }
                    }
                    else {
                        if (number == rest) {
                            frame[frameNumber].record.add('-');
                        }
                        else {
                            frame[frameNumber].record.add( (char) ('0' + rest -
                                number));
                        }
                        frame[frameNumber].determined = true;
                        frame[frameNumber].bonus = 0;
                        frame[frameNumber].score += rest - number;
                    }
                    if (frameNumber >= 1 &&
                        frame[frameNumber - 1 + offset].bonus == 1) {
                        frame[frameNumber - 1 + offset].determined = true;
                        frame[frameNumber - 1 + offset].bonus = 0;
                        frame[frameNumber - 1 + offset].score += rest - number;
                    }
                    if (frameNumber != 9) {
                        frameNumber++;
                    }
                    else {
                        offset = 1;
                    }
                    ball = 0;
                }
                number = cin.nextInt();
            }
            int cumulative = 0;
            System.out.printf("%-12s", name);
            for (int i = 0; i < 10; i++) {
                if (frame[i].record.isEmpty() == true) {
                    break;
                }
                System.out.print(" ");
                for (int j = 0; j < frame[i].record.size(); j++) {
                    System.out.print(frame[i].record.get(j));
                }
                for (int j = 0; j < 3 - frame[i].record.size(); j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            System.out.printf("%12s", "");
            for (int i = 0; i < 10; i++) {
                if (frame[i].record.isEmpty() == true) {
                    break;
                }
                if (frame[i].determined == true) {
                    cumulative += frame[i].score;
                    System.out.printf("%4d", cumulative);
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}

class Frame {
    ArrayList<Character> record;
    boolean determined;
    int bonus;
    int score;
    public Frame() {
        this.record = new ArrayList<Character> ();
        this.determined = false;
        this.bonus = 0;
    }
}
