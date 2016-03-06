package P1703__Find_them_Catch_them;

import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-18
 * Time: 22:25:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Criminal criminals[];

    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            criminals = new Criminal[N + 1];
            for (int i = 1; i <= N; i++) {
                criminals[i] = new Criminal(i);
            }
            for (int i = 0; i < M; i++) {
                line = stdin.readLine();
                st = new StringTokenizer(line);
                String str = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                Root_Same rs1 = searchRoot(a);
                Root_Same rs2 = searchRoot(b);
                if (str.equals("A") == true) {
                    if (rs1.root != rs2.root) {
                        System.out.println("Not sure yet.");
                    } else if (rs1.same == rs2.same) {
                        System.out.println("In the same gang.");
                    } else {
                        System.out.println("In different gangs.");
                    }
                } else {
                    criminals[rs2.root].parent = rs1.root;
                    criminals[rs2.root].same = rs2.same ^ rs1.same;
                }
            }
        }
    }

    static Root_Same searchRoot(int node) {
        int root = node;
        boolean same = true;
        while (criminals[root].parent != root) {
            same = !criminals[root].same ^ same;
            root = criminals[root].parent;
        }
        int temp = node;
        boolean tempSame = same;
        boolean previous = true;
        while (temp != root) {
            boolean temp1 = criminals[temp].same;
            criminals[temp].same = !tempSame ^ previous;
            tempSame = criminals[temp].same;
            previous = temp1;
            int temp2 = criminals[temp].parent;
            criminals[temp].parent = root;
            temp = temp2;
        }
        return new Root_Same(root, same);
    }
}

class Criminal {
    int parent;
    boolean same;

    public Criminal(int theParent) {
        this.parent = theParent;
        this.same = true;
    }
}

class Root_Same {
    int root;
    boolean same;

    public Root_Same(int theRoot, boolean theSame) {
        this.root = theRoot;
        this.same = theSame;
    }
}