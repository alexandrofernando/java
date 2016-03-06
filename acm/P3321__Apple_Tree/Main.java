package P3321__Apple_Tree;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-3-8
 * Time: 21:46:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int N;
    static ArrayList<Integer> adjacents[];
    static int begins[];
    static int ends[];
    static int c[];

    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        adjacents = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacents[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N - 1; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacents[u].add(v);
            adjacents[v].add(u);
        }
        boolean apples[] = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            apples[i] = true;
        }
        c = new int[N + 1];
        begins = new int[N + 1];
        ends = new int[N + 1];
        dfs();
        line = stdin.readLine();
        st = new StringTokenizer(line);
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            String command = st.nextToken();
            int fork = Integer.parseInt(st.nextToken());
            if (command.equals("Q")) {
                System.out.println(ends[fork] - begins[fork] + 1 + sum(ends[fork]) - sum(begins[fork] - 1));
            } else if (command.equals("C")) {
                if (apples[fork]) {
                    apples[fork] = false;
                    modify(begins[fork], -1);
                } else {
                    apples[fork] = true;
                    modify(begins[fork], 1);
                }
            }
        }
    }

    static int lowBit(int number) {
        return number & (-number);
    }

    static void modify(int index, int offset) {
        while (index <= N) {
            c[index] += offset;
            index += lowBit(index);
        }
    }

    static int sum(int index) {
        int total = 0;
        while (index > 0) {
            total += c[index];
            index -= lowBit(index);
        }
        return total;
    }

    static void dfs() {
        boolean visited[] = new boolean[N + 1];
        int index = 1;
        Stack<Integer> stack = new Stack<Integer>();
        visited[1] = true;
        stack.push(-1);
        stack.push(1);
        while (!stack.empty()) {
            int top = stack.pop();
            if (top > 0) {
                begins[top] = index;
                index++;
                for (int i = 0; i < adjacents[top].size(); i++) {
                    int next = adjacents[top].get(i);
                    if (!visited[next]) {
                        visited[next] = true;
                        stack.push(-next);
                        stack.push(next);
                    }
                }
            } else {
                top = -top;
                ends[top] = index - 1;
            }
        }
    }
}
