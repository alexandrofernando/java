package P3264__Balanced_Lineup;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-6
 * Time: 2:09:10
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        Height heights[] = new Height[N];
        int minRoot = 0;
        int maxRoot = 0;
        for (int i = 0; i < N; i++) {
            heights[i] = new Height(in.nextInt());
            int current = i - 1;
            int previous = -1;
            while (true) {
                if (current == -1) {
                    if (previous != -1) {
                        heights[i].minLeft = previous;
                        heights[previous].minParent = i;
                        minRoot = i;
                    }
                    break;
                }
                if (heights[i].height >= heights[current].height) {
                    heights[i].minLeft = heights[current].minRight;
                    heights[current].minRight = i;
                    if (heights[i].minLeft != -1) {
                        heights[heights[i].minLeft].minParent = i;
                    }
                    heights[i].minParent = current;
                    break;
                }
                previous = current;
                current = heights[current].minParent;
            }
            current = i - 1;
            previous = -1;
            while (true) {
                if (current == -1) {
                    if (previous != -1) {
                        heights[i].maxLeft = previous;
                        heights[previous].maxParent = i;
                        maxRoot = i;
                    }
                    break;
                }
                if (heights[i].height <= heights[current].height) {
                    heights[i].maxLeft = heights[current].maxRight;
                    heights[current].maxRight = i;
                    if (heights[i].maxLeft != -1) {
                        heights[heights[i].maxLeft].maxParent = i;
                    }
                    heights[i].maxParent = current;
                    break;
                }
                previous = current;
                current = heights[current].maxParent;
            }
        }
        for (int i = 0; i < Q; i++) {
            int A = in.nextInt() - 1;
            int B = in.nextInt() - 1;
            int min = minRoot;
            while (min < A || min > B) {
                if (min < A) {
                    min = heights[min].minRight;
                } else {
                    min = heights[min].minLeft;
                }
            }
            int max = maxRoot;
            while (max < A || max > B) {
                if (max < A) {
                    max = heights[max].maxRight;
                } else {
                    max = heights[max].maxLeft;
                }
            }
            System.out.println(heights[max].height - heights[min].height);
        }
    }
}

class Height {
    int height;
    int minParent;
    int minLeft;
    int minRight;
    int maxParent;
    int maxLeft;
    int maxRight;

    public Height(int theHeight) {
        this.height = theHeight;
        this.minParent = -1;
        this.minLeft = -1;
        this.minRight = -1;
        this.maxParent = -1;
        this.maxLeft = -1;
        this.maxRight = -1;
    }
}