package P3278__Catch_That_Cow;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-17
 * Time: 6:15:06
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        boolean visited[] = new boolean[100001];
        LinkedList<Point_Step> queue = new LinkedList<Point_Step>();
        queue.offer(new Point_Step(N, 0));
        while (queue.isEmpty() == false) {
            Point_Step head = queue.poll();
            if (head.point == K) {
                System.out.println(head.step);
                break;
            }
            if (head.point > 0 && visited[head.point - 1] == false) {
                visited[head.point - 1] = true;
                queue.offer(new Point_Step(head.point - 1, head.step + 1));
            }
            if (head.point < 100000 && visited[head.point + 1] == false) {
                visited[head.point + 1] = true;
                queue.offer(new Point_Step(head.point + 1, head.step + 1));
            }
            if (head.point <= 50000 && visited[head.point * 2] == false) {
                visited[head.point * 2] = true;
                queue.offer(new Point_Step(head.point * 2, head.step + 1));
            }
        }
    }
}

class Point_Step {
    int point;
    int step;

    public Point_Step(int thePoint, int theStep) {
        this.point = thePoint;
        this.step = theStep;
    }
}