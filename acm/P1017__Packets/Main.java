package P1017__Packets;

import java.util.Scanner;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int packets[] = new int[7];
        do {
            boolean power = false;
            for (int i = 1; i <= 6; i++) {
                packets[i] = cin.nextInt();
                if (packets[i] != 0) {
                    power = true;
                }
            }
            if (power == false) {
                break;
            }
            int rest;
            int parcel = packets[6];
            parcel += packets[5];
            if (packets[1] >= packets[5] * 11) {
                packets[1] -= packets[5] * 11;
            }
            else {
                packets[1] = 0;
            }
            parcel += packets[4];
            if (packets[2] >= packets[4] * 5) {
                packets[2] -= packets[4] * 5;
            }
            else {
                rest = (packets[4] * 5 - packets[2]) * 4;
                packets[2] = 0;
                if (packets[1] >= rest) {
                    packets[1] -= rest;
                }
                else {
                    packets[1] = 0;
                }
            }
            parcel += packets[3] / 4;
            rest = packets[3] % 4;
            if (rest != 0) {
                parcel++;
                if (rest == 1) {
                    if (packets[2] >= 5) {
                        packets[2] -= 5;
                        if (packets[1] >= 7) {
                            packets[1] -= 7;
                        }
                        else {
                            packets[1] = 0;
                        }
                    }
                    else {
                        if (packets[1] >= 27 - packets[2] * 4) {
                            packets[1] -= 27 - packets[2] * 4;
                        }
                        else {
                            packets[1] = 0;
                        }
                        packets[2] = 0;
                    }
                }
                else if (rest == 2) {
                    if (packets[2] >= 3) {
                        packets[2] -= 3;
                        if (packets[1] >= 6) {
                            packets[1] -= 6;
                        }
                        else {
                            packets[1] = 0;
                        }
                    }
                    else {
                        if (packets[1] >= 18 - packets[2] * 4) {
                            packets[1] -= 18 - packets[2] * 4;
                        }
                        else {
                            packets[1] = 0;
                        }
                        packets[2] = 0;
                    }
                }
                else if (rest == 3) {
                    if (packets[2] >= 1) {
                        packets[2] -= 1;
                        if (packets[1] >= 5) {
                            packets[1] -= 5;
                        }
                        else {
                            packets[1] = 0;
                        }
                    }
                    else {
                        if (packets[1] >= 9) {
                            packets[1] -= 9;
                        }
                        else {
                            packets[1] = 0;
                        }
                    }
                }
            }
            parcel += packets[2] / 9;
            rest = packets[2] % 9;
            if (rest != 0) {
                parcel++;
                if (packets[1] >= 36 - rest * 4) {
                    packets[1] -= 36 - rest * 4;
                }
                else {
                    packets[1] = 0;
                }
            }
            parcel += packets[1] / 36;
            rest = packets[1] % 36;
            if (rest != 0) {
                parcel++;
            }
            System.out.println(parcel);
        }
        while (true);
    }
}
