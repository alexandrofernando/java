package P1036__Gangsters;

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

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
        int n = cin.nextInt();
        int K = cin.nextInt();
        int T = cin.nextInt();
        Gangster gangsters[] = new Gangster[n];
        for (int i = 0; i < n; i++) {
            gangsters[i] = new Gangster();
        }
        for (int i = 0; i < n; i++) {
            gangsters[i].time = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            gangsters[i].prosperity = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            gangsters[i].stoutness = cin.nextInt();
            if (gangsters[i].stoutness <= gangsters[i].time) {
                gangsters[i].possible = true;
            }
            else {
                gangsters[i].possible = false;
            }
        }
        Arrays.sort(gangsters);
        int max[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (gangsters[i].possible == true) {
                max[i] = gangsters[i].prosperity;
            }
            else {
                max[i] = 0;
            }
            for (int j = 0; j < i; j++) {
                if (gangsters[j].possible == true &&
                    Math.abs(gangsters[i].stoutness - gangsters[j].stoutness) <=
                    gangsters[i].time - gangsters[j].time) {
                    if (max[j] + gangsters[i].prosperity > max[i]) {
                        max[i] = max[j] + gangsters[i].prosperity;
                    }
                }
            }
        }
        int result = max[0];
        for (int i = 1; i < n; i++) {
            if (max[i] > result) {
                result = max[i];
            }
        }
        System.out.println(result);
    }
}

class Gangster
    implements Comparable<Gangster> {
    int time;
    int prosperity;
    int stoutness;
    boolean possible;
    public int compareTo(Gangster another) {
        return this.time - another.time;
    }
}
