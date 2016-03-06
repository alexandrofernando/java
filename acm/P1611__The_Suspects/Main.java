package P1611__The_Suspects;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-4-30
 * Time: 22:53:23
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Student students[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            students = new Student[n];
            for (int i = 0; i < n; i++) {
                students[i] = new Student();
            }
            for (int i = 0; i < m; i++) {
                int K = in.nextInt();
                int head = -1;
                for (int j = 0; j < K; j++) {
                    if (j == 0) {
                        head = in.nextInt();
                    } else {
                        int root1 = searchRoot(head);
                        int root2 = searchRoot(in.nextInt());
                        if (root1 != root2) {
                            students[root1].number += students[root2].number;
                            students[root2].parent = root1;
                        }
                    }
                }
            }
            int root = searchRoot(0);
            System.out.println(students[root].number);
        }
    }

    static int searchRoot(int node) {
        int root = node;
        while (students[root].parent != -1) {
            root = students[root].parent;
        }
        while (node != root) {
            int temp = students[node].parent;
            students[node].parent = root;
            node = temp;
        }
        return root;
    }
}

class Student {
    int parent;
    int number;

    public Student() {
        this.parent = -1;
        this.number = 1;
    }
}