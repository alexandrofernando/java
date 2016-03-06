package P2186__Popular_Cows;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-1-17
 * Time: 21:17:37
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Cow cows[];
    static int count;
    static int table[];
    static int componentIndex;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        cows = new Cow[N + 1];
        for (int i = 1; i <= N; i++) {
            cows[i] = new Cow();
        }
        table = new int[N + 1];
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            cows[B].adjacents.add(A);
        }
        count = 1;
        for (int i = 1; i <= N; i++) {
            if (cows[i].visited == false) {
                dfs1(i);
            }
        }
        ArrayList<Integer> temps[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            temps[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < cows[i].adjacents.size(); j++) {
                temps[cows[i].adjacents.get(j)].add(i);
            }
        }
        for (int i = 1; i <= N; i++) {
            cows[i].adjacents = temps[i];
            cows[i].visited = false;
        }
        ArrayList<Component> components = new ArrayList<Component>();
        componentIndex = 0;
        for (int i = N; i >= 1; i--) {
            if (cows[table[i]].visited == false) {
                int count = dfs2(table[i]);
                components.add(new Component(count));
                componentIndex++;
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < cows[i].adjacents.size(); j++) {
                int componentIndex1 = cows[i].componentIndex;
                int componentIndex2 = cows[cows[i].adjacents.get(j)].componentIndex;
                if (componentIndex1 != componentIndex2) {
                    components.get(componentIndex1).root = false;
                }
            }
        }
        int result = -1;
        int rootComponent = -1;
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).root == true) {
                if (rootComponent != -1) {
                    result = 0;
                    break;
                } else {
                    rootComponent = i;
                    result = components.get(i).count;
                }
            }
        }
        System.out.println(result);
    }

    static void dfs1(int v) {
        Stack<Integer> stack = new Stack<Integer>();
        cows[v].visited = true;
        stack.push(v);
        while (stack.empty() == false) {
            int top = stack.pop();
            if (top > 0) {
                stack.push(-top);
                for (int i = 0; i < cows[top].adjacents.size(); i++) {
                    int index = cows[top].adjacents.get(i);
                    if (cows[index].visited == false) {
                        cows[index].visited = true;
                        stack.push(index);
                    }
                }
            } else {
                table[count] = -top;
                count++;
            }
        }
    }

    static int dfs2(int v) {
        int count = 0;
        Stack<Integer> stack = new Stack<Integer>();
        cows[v].visited = true;
        stack.push(v);
        while (stack.empty() == false) {
            count++;
            int top = stack.pop();
            cows[top].componentIndex = componentIndex;
            for (int i = 0; i < cows[top].adjacents.size(); i++) {
                int index = cows[top].adjacents.get(i);
                if (cows[index].visited == false) {
                    cows[index].visited = true;
                    stack.push(index);
                }
            }
        }
        return count;
    }
}

class Cow {
    ArrayList<Integer> adjacents;
    boolean visited;
    int componentIndex;

    public Cow() {
        this.adjacents = new ArrayList<Integer>();
        this.visited = false;
    }
}

class Component {
    int count;
    boolean root;

    public Component(int theCount) {
        this.count = theCount;
        this.root = true;
    }
}