package P1386__Play_on_Words;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-30
 * Time: 0:00:14
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int parents[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = in.nextInt();
            int counts[] = new int[26];
            parents = new int[26];
            boolean used[] = new boolean[26];
            for (int i = 0; i < 26; i++) {
                parents[i] = i;
            }
            for (int i = 0; i < N; i++) {
                String word = in.next();
                int head = word.charAt(0) - 'a';
                int tail = word.charAt(word.length() - 1) - 'a';
                used[head] = true;
                used[tail] = true;
                int rootHead = searchRoot(head);
                int rootTail = searchRoot(tail);
                if (rootHead < rootTail) {
                    parents[rootTail] = rootHead;
                } else if (rootHead > rootTail) {
                    parents[rootHead] = rootTail;
                }
                counts[head]++;
                counts[tail]--;
            }
            boolean possible = true;
            int root = -1;
            if (N > 1) {
                int odd = 0;
                for (int i = 0; i < 26; i++) {
                    if (counts[i] > 1 || counts[i] < -1) {
                        possible = false;
                        break;
                    }
                    if (counts[i] == 1 || counts[i] == -1) {
                        odd++;
                        if (odd > 2) {
                            possible = false;
                            break;
                        }
                    }
                    if (used[i] == true) {
                        if (root == -1) {
                            root = searchRoot(i);
                        } else if (root != searchRoot(i)) {
                            possible = false;
                            break;
                        }
                    }
                }
            }
            if (possible == true) {
                System.out.println("Ordering is possible.");
            } else {
                System.out.println("The door cannot be opened.");
            }
        }
    }

    static int searchRoot(int node) {
        int root = node;
        while (parents[root] != root) {
            root = parents[root];
        }
        while (node != root) {
            parents[node] = root;
            node = parents[node];
        }
        return root;
    }
}
