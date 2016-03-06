
import java.util.HashSet;

public class P228 {

    public static void main(String args[]) {
        final int BEGIN = 1864;
        final int END = 1909;
        HashSet<Pair> set = new HashSet<Pair>();
        for (int i = BEGIN; i <= END; i++) {
            for (int j = 0; j < i; j++) {
                int common = gcd(i, j);
                set.add(new Pair(j / common, i / common));
            }
        }
        System.out.println(set.size());
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}

class Pair {

    int num1;
    int num2;

    Pair(int theNum1, int theNum2) {
        this.num1 = theNum1;
        this.num2 = theNum2;
    }

    @Override
    public boolean equals(Object obj) {
        Pair another = (Pair) obj;
        return this.num1 == another.num1 && this.num2 == another.num2;
    }

    @Override
    public int hashCode() {
        return this.num1 * this.num2;
    }
}