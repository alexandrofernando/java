package P1609__Tiling_Up_Blocks;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-11
 * Time: 19:52:32
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            Block blocks[] = new Block[n];
            for (int i = 0; i < n; i++) {
                blocks[i] = new Block(in.nextInt(), in.nextInt());
            }
            Arrays.sort(blocks);
            int max[] = new int[n];
            for (int i = 0; i < n; i++) {
                max[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (blocks[j].middle <= blocks[i].middle && max[j] + 1 > max[i]) {
                        max[i] = max[j] + 1;
                    }
                }
            }
            int result = -1;
            for (int i = 0; i < n; i++) {
                if (max[i] > result) {
                    result = max[i];
                }
            }
            System.out.println(result);
        }
        System.out.println("*");
    }
}

class Block implements Comparable<Block> {
    int left;
    int middle;

    public Block(int theLeft, int theMiddle) {
        this.left = theLeft;
        this.middle = theMiddle;
    }

    public int compareTo(Block another) {
        if (this.left != another.left) {
            return this.left - another.left;
        } else {
            return this.middle - another.middle;
        }
    }
}