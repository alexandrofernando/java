package P1075__University_Entrance_Examination;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

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
    static Student students[];
    static FDU fdu[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = cin.nextInt();
            int M = cin.nextInt();
            students = new Student[N];
            for (int i = 0; i < N; i++) {
                students[i] = new Student(cin.nextInt(), cin.nextInt());
                int temp = cin.nextInt();
                for (int j = 0; j < temp; j++) {
                    students[i].priority.add(cin.nextInt());
                }
            }
            fdu = new FDU[M + 1];
            PriorityQueue<Integer> accept[] = new PriorityQueue[M + 1];
            for (int i = 1; i <= M; i++) {
                fdu[i] = new FDU(cin.nextInt(), cin.nextInt());
                accept[i] = new PriorityQueue<Integer> (1, new MyComparator(i));
            }
            for (int i = 0; i < N; i++) {
                if (students[i].priority.isEmpty() == false) {
                    accept[students[i].priority.get(0)].offer(i);
                }
            }
            boolean power;
            do {
                power = false;
                for (int i = 1; i <= M; i++) {
                    while (accept[i].size() > fdu[i].capacity) {
                        int temp = accept[i].poll();
                        students[temp].priority.remove(0);
                        if (students[temp].priority.isEmpty() == false) {
                            accept[students[temp].priority.get(0)].offer(temp);
                        }
                        power = true;
                    }
                }
            }
            while (power == true);
            for (int i = 1; i <= M; i++) {
                Iterator<Integer> iterator = accept[i].iterator();
                while (iterator.hasNext() == true) {
                    students[iterator.next()].result = i;
                }
            }
            for (int i = 0; i < N; i++) {
                if (students[i].result == 0) {
                    System.out.println("not accepted");
                }
                else {
                    System.out.println(students[i].result);
                }
            }
            System.out.println();
        }
    }

    static class MyComparator
        implements Comparator<Integer> {
        int fduIndex;
        public MyComparator(int theFDUIndex) {
            this.fduIndex = theFDUIndex;
        }

        public int compare(Integer a, Integer b) {
            double scoreA = students[a].score;
            if (students[a].region != fdu[fduIndex].region) {
                scoreA *= 0.7;
            }
            double scoreB = students[b].score;
            if (students[b].region != fdu[fduIndex].region) {
                scoreB *= 0.7;
            }
            if (scoreA > scoreB) {
                return 1;
            }
            else if (scoreA < scoreB) {
                return -1;
            }
            else if (students[a].region != fdu[fduIndex].region &&
                     students[b].region == fdu[fduIndex].region) {
                return 1;
            }
            else if (students[a].region == fdu[fduIndex].region &&
                     students[b].region != fdu[fduIndex].region) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}

class Student {
    int region;
    int score;
    int result;
    LinkedList<Integer> priority;
    public Student(int theRegion, int theScore) {
        this.region = theRegion;
        this.score = theScore;
        this.result = 0;
        this.priority = new LinkedList<Integer> ();
    }
}

class FDU {
    int region;
    int capacity;
    public FDU(int theRegion, int theCapacity) {
        this.region = theRegion;
        this.capacity = theCapacity;
    }
}
