package P1555__Polynomial_Showdown;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-23
 * Time: 3:05:48
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            boolean power = false;
            for (int i = 8; i >= 0; i--) {
                int coefficient = in.nextInt();
                if (i == 0) {
                    if (coefficient == 0) {
                        if (power == false) {
                            System.out.println("0");
                        } else {
                            System.out.println();
                        }
                    } else if (power == false) {
                        System.out.println(coefficient);
                    } else if (coefficient > 0) {
                        System.out.println(" + " + coefficient);
                    } else {
                        System.out.println(" - " + (-coefficient));
                    }
                } else if (coefficient != 0) {
                    if (power == false) {
                        if (coefficient == -1) {
                            System.out.print("-");
                        } else if (coefficient != 1) {
                            System.out.print(coefficient);
                        }
                        power = true;
                    } else {
                        if (coefficient > 0) {
                            System.out.print(" + ");
                        } else {
                            System.out.print(" - ");
                            coefficient = -coefficient;
                        }
                        if (coefficient != 1) {
                            System.out.print(coefficient);
                        }
                    }
                    if (i == 1) {
                        System.out.print("x");
                    } else {
                        System.out.print("x^" + i);
                    }
                }
            }
        }
    }
}
