package P2985__The_k_th_Largest_Group;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-10
 * Time: 15:07:49
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int counts[] = new int[524287];
    static Cat cats[];

    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cats = new Cat[N + 1];
        for (int i = 1; i <= N; i++) {
            cats[i] = new Cat(i);
        }
        update(1, N);
        for (int i = 0; i < M; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            int C = Integer.parseInt(st.nextToken());
            if (C == 0) {
                int cat1 = Integer.parseInt(st.nextToken());
                int cat2 = Integer.parseInt(st.nextToken());
                int root1 = searchRoot(cat1);
                int root2 = searchRoot(cat2);
                if (root1 != root2) {
                    update(cats[root1].total, -1);
                    update(cats[root2].total, -1);
                    update(cats[root1].total + cats[root2].total, 1);
                    cats[root2].total += cats[root1].total;
                    cats[root1].parent = root2;
                }
            } else {
                int K = Integer.parseInt(st.nextToken());
                int size = find(K);
                System.out.println(size);
            }
        }
    }

    static void update(int number, int addition) {
        int bottom = 1;
        int top = 262144;
        int index = 0;
        for (int i = 0; i < 19; i++) {
            counts[index] += addition;
            int middle = (bottom + top) / 2;
            if (number <= middle) {
                top = middle;
                index = index * 2 + 1;
            } else {
                bottom = middle + 1;
                index = index * 2 + 2;
            }
        }
    }

    static int find(int serial) {
        int bottom = 1;
        int top = 262144;
        int index = 0;
        for (int i = 0; i < 18; i++) {
            int middle = (bottom + top) / 2;
            if (serial <= counts[index * 2 + 2]) {
                bottom = middle + 1;
                index = index * 2 + 2;
            } else {
                serial -= counts[index * 2 + 2];
                top = middle;
                index = index * 2 + 1;
            }
        }
        return bottom;
    }

    static int searchRoot(int node) {
        int root = node;
        while (cats[root].parent != -1) {
            root = cats[root].parent;
        }
        while (node != root) {
            int temp = cats[node].parent;
            cats[node].parent = root;
            node = temp;
        }
        return root;
    }
}

class Cat {
    int index;
    int parent;
    int total;

    public Cat(int theIndex) {
        this.index = theIndex;
        this.parent = -1;
        this.total = 1;
    }
}