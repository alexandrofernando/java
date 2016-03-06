package P1165__The_Primes;

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
    static ArrayList<Prime> primes[];
    static int sum;
    static int tld;
    static int solution[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        sum = cin.nextInt();
        tld = cin.nextInt();
        primes = new ArrayList[10];
        for (int i = 1; i < 10; i++) {
            primes[i] = new ArrayList<Prime> ();
        }
        genPrimes();
        solution = new int[5][5];
        H1();
    }

    static void genPrimes() {
        int head = 0;
        for (int i = 10000; i <= 99999; i++) {
            if (isPrime(i) == true) {
                Prime p = new Prime(i);
                int sumDigits = 0;
                for (int j = 0; j < 5; j++) {
                    sumDigits += p.digits[j];
                }
                if (sumDigits == sum) {
                    primes[p.digits[0]].add(p);
                }
            }
        }
    }

    static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int compose(int d0, int d1, int d2, int d3, int d4) {
        return d0 * 10000 + d1 * 1000 + d2 * 100 + d3 * 10 + d4;
    }

    static void H1() {
        for (int i = 0; i < primes[tld].size(); i++) {
            Prime prime = primes[tld].get(i);
            boolean power = true;
            for (int j = 0; j < 5; j++) {
                solution[0][j] = prime.digits[j];
                if (solution[0][j] == 0) {
                    power = false;
                    break;
                }
            }
            if (power == true) {
                V1();
            }
        }
    }

    static void V1() {
        for (int i = 0; i < primes[tld].size(); i++) {
            Prime prime = primes[tld].get(i);
            boolean power = true;
            for (int j = 1; j < 5; j++) {
                solution[j][0] = prime.digits[j];
                if (solution[j][0] == 0) {
                    power = false;
                    break;
                }
            }
            if (power == true) {
                D2();
            }
        }
    }

    static void D2() {
        for (int i = 0; i < primes[solution[4][0]].size(); i++) {
            Prime prime = primes[solution[4][0]].get(i);
            if (prime.digits[4] == solution[0][4]) {
                solution[3][1] = prime.digits[1];
                solution[2][2] = prime.digits[2];
                solution[1][3] = prime.digits[3];
                H2();
            }
        }
    }

    static void H2() {
        for (int i = 0; i < primes[solution[1][0]].size(); i++) {
            Prime prime = primes[solution[1][0]].get(i);
            if (prime.digits[3] == solution[1][3]) {
                solution[1][1] = prime.digits[1];
                solution[1][2] = prime.digits[2];
                solution[1][4] = prime.digits[4];
                V2();
            }
        }
    }

    static void V2() {
        for (int i = 0; i < primes[solution[0][1]].size(); i++) {
            Prime prime = primes[solution[0][1]].get(i);
            if (prime.digits[1] == solution[1][1] &&
                prime.digits[3] == solution[3][1]) {
                solution[2][1] = prime.digits[2];
                solution[4][1] = prime.digits[4];
                H3();
            }
        }
    }

    static void H3() {
        for (int i = 0; i < primes[solution[2][0]].size(); i++) {
            Prime prime = primes[solution[2][0]].get(i);
            if (prime.digits[1] == solution[2][1] &&
                prime.digits[2] == solution[2][2]) {
                solution[2][3] = prime.digits[3];
                solution[2][4] = prime.digits[4];
                V3();
            }
        }
    }

    static void V3() {
        for (int i = 0; i < primes[solution[0][2]].size(); i++) {
            Prime prime = primes[solution[0][2]].get(i);
            if (prime.digits[1] == solution[1][2] &&
                prime.digits[2] == solution[2][2]) {
                solution[3][2] = prime.digits[3];
                solution[4][2] = prime.digits[4];
                H4();
            }
        }
    }

    static void H4() {
        for (int i = 0; i < primes[solution[3][0]].size(); i++) {
            Prime prime = primes[solution[3][0]].get(i);
            if (prime.digits[1] == solution[3][1] &&
                prime.digits[2] == solution[3][2]) {
                solution[3][3] = prime.digits[3];
                solution[3][4] = prime.digits[4];
                V4();
            }
        }
    }

    static void V4() {
        solution[4][3] = sum - solution[0][3] - solution[1][3] - solution[2][3] -
            solution[3][3];
        if (solution[4][3] < 0 || solution[4][3] > 9) {
            return;
        }
        Prime prime = new Prime(compose(solution[0][3], solution[1][3],
                                        solution[2][3], solution[3][3],
                                        solution[4][3]));
        if (Collections.binarySearch(primes[solution[0][3]], prime) >= 0) {
            H5();
        }
    }

    static void H5() {
        solution[4][4] = sum - solution[4][3] - solution[4][2] - solution[4][1] -
            solution[4][0];
        if (solution[4][4] < 0 || solution[4][4] > 9) {
            return;
        }
        Prime prime = new Prime(compose(solution[4][0], solution[4][1],
                                        solution[4][2], solution[4][3],
                                        solution[4][4]));
        if (Collections.binarySearch(primes[solution[4][0]], prime) >= 0) {
            V5();
        }
    }

    static void V5() {
        if (solution[0][4] + solution[1][4] + solution[2][4] + solution[3][4] +
            solution[4][4] != sum) {
            return;
        }
        Prime prime = new Prime(compose(solution[0][4], solution[1][4],
                                        solution[2][4], solution[3][4],
                                        solution[4][4]));
        if (Collections.binarySearch(primes[solution[0][4]], prime) >= 0) {
            D1();
        }
    }

    static void D1() {
        if (solution[0][0] + solution[1][1] + solution[2][2] + solution[3][3] +
            solution[4][4] != sum) {
            return;
        }
        Prime prime = new Prime(compose(solution[0][0], solution[1][1],
                                        solution[2][2], solution[3][3],
                                        solution[4][4]));
        if (Collections.binarySearch(primes[solution[0][0]], prime) >= 0) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(solution[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

class Prime
    implements Comparable<Prime> {
    int number;
    int digits[];
    public Prime(int theNumber) {
        this.number = theNumber;
        this.digits = new int[5];
        for (int i = 4; i >= 0; i--) {
            this.digits[i] = theNumber % 10;
            theNumber /= 10;
        }
    }

    public int compareTo(Prime another) {
        return this.number - another.number;
    }
}
