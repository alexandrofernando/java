
import java.util.HashSet;
import java.util.LinkedList;

public class P224 {

    public static void main(String args[]) {
        final int LIMIT = 75000000;
        HashSet<Triangle> solutions = new HashSet<Triangle>();
        LinkedList<Triangle> queue = new LinkedList<Triangle>();
        Triangle seed = new Triangle(2, 2, 3);
        solutions.add(seed);
        queue.offer(seed);
        while (!queue.isEmpty()) {
            Triangle head = queue.poll();
            if (head.a <= head.b) {
                if (head.a + head.b + head.c <= LIMIT) {
                    int nextA[] = {
                        -2 * head.a + head.b + 2 * head.c,
                        2 * head.a + head.b + 2 * head.c,
                        head.a - 2 * head.b + 2 * head.c};
                    int nextB[] = {
                        -head.a + 2 * head.b + 2 * head.c,
                        head.a + 2 * head.b + 2 * head.c,
                        2 * head.a - head.b + 2 * head.c};
                    int nextC[] = {
                        -2 * head.a + 2 * head.b + 3 * head.c,
                        2 * head.a + 2 * head.b + 3 * head.c,
                        2 * head.a - 2 * head.b + 3 * head.c};
                    for (int i = 0; i < 3; i++) {
                        if (nextA[i] + nextB[i] + nextC[i] <= LIMIT) {
                            Triangle next = new Triangle(nextA[i], nextB[i], nextC[i]);
                            if (!solutions.contains(next)) {
                                solutions.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(solutions.size());
    }
}

class Triangle {

    int a;
    int b;
    int c;

    Triangle(int A, int B, int C) {
        this.a = A;
        this.b = B;
        this.c = C;
    }

    @Override
    public boolean equals(Object obj) {
        Triangle other = (Triangle) obj;
        return this.a == other.a && this.b == other.b && this.c == other.c;
    }

    @Override
    public int hashCode() {
        return a * b * c;
    }
}