
import java.util.PriorityQueue;

public class P247 {

    static final int LIMIT_LEFT = 3;
    static final int LIMIT_BELOW = 3;

    public static void main(String args[]) {
        PriorityQueue<Square> queue = new PriorityQueue<Square>();
        queue.add(fit(1, 0, 0, 0));
        int count = 1;
        int maxN = -1;
        for (int n = 1; count > 0; n++) {
            Square square = queue.poll();
            if (notExceedLimit(square.left, square.below)) {
                count--;
            }
            if (square.left == LIMIT_LEFT && square.below == LIMIT_BELOW) {
                maxN = n;
            }

            Square next = fit(square.maxX, square.maxY - square.size, square.left + 1, square.below);
            queue.add(next);
            if (notExceedLimit(next.left, next.below)) {
                count++;
            }

            next = fit(square.maxX - square.size, square.maxY, square.left, square.below + 1);
            queue.add(next);
            if (notExceedLimit(next.left, next.below)) {
                count++;
            }
        }
        System.out.println(maxN);
    }

    static boolean notExceedLimit(int left, int below) {
        return left <= LIMIT_LEFT && below <= LIMIT_BELOW;
    }

    static Square fit(double x, double y, int left, int below) {
        double size = (-(x + y) + Math.sqrt((x + y) * (x + y) - 4 * (x * y - 1))) / 2;
        return new Square(size, x + size, y + size, left, below);
    }
}

class Square implements Comparable<Square> {

    double size;
    double maxX;
    double maxY;
    int left;
    int below;

    Square(double theSize, double theMaxX, double theMaxY, int theLeft, int theBelow) {
        this.size = theSize;
        this.maxX = theMaxX;
        this.maxY = theMaxY;
        this.left = theLeft;
        this.below = theBelow;
    }

    @Override
    public int compareTo(Square another) {
        return (int) Math.signum(another.size - this.size);
    }
}