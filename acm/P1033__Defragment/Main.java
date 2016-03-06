package P1033__Defragment;

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
        int diskCluster[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            diskCluster[i] = -1;
        }
        int fileNumber = cin.nextInt();
        ArrayList<Integer> fileCluster = new ArrayList<Integer> ();
        fileCluster.add(0);
        boolean need = false;
        for (int i = 1; i <= fileNumber; i++) {
            int temp = cin.nextInt();
            for (int j = 0; j < temp; j++) {
                int pos = cin.nextInt();
                if (pos != fileCluster.size()) {
                    need = true;
                }
                diskCluster[pos] = fileCluster.size();
                fileCluster.add(pos);
            }
        }
        if (need == false) {
            System.out.println("No optimization needed");
        }
        else {
            boolean power;
            do {
                power = false;
                for (int i = 1; i < fileCluster.size(); i++) {
                    if (diskCluster[i] == -1) {
                        int pos = fileCluster.get(i);
                        diskCluster[pos] = -1;
                        diskCluster[i] = i;
                        fileCluster.set(i, i);
                        System.out.println(pos + " " + i);
                        power = true;
                    }
                }
            }
            while (power == true); while (true) {
                int empty = 1;
                while (diskCluster[empty] == empty) {
                    empty++;
                }
                if (empty < fileCluster.size()) {
                    System.out.println(empty + " " + n);
                    fileCluster.set(diskCluster[empty], n);
                    diskCluster[empty] = -1;
                    diskCluster[n] = diskCluster[empty];
                }
                else {
                    break;
                }
                while (empty < fileCluster.size()) {
                    int pos = fileCluster.get(empty);
                    System.out.println(pos + " " + empty);
                    diskCluster[pos] = -1;
                    diskCluster[empty] = empty;
                    fileCluster.set(empty, empty);
                    empty = pos;
                }
            }
        }
    }
}
