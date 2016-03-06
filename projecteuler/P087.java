import java.util.HashSet;
import java.util.Iterator;

public class P087 {
	static final int LIMIT = 50000000;

	public static void main(String args[]) {
		HashSet<Integer> squares = new HashSet<Integer>();
		HashSet<Integer> cubes = new HashSet<Integer>();
		HashSet<Integer> fouths = new HashSet<Integer>();
		for (int i = 2; i * i < LIMIT; i++) {
			if (isPrime(i)) {
				squares.add(i * i);
				if ((long) i * i * i < LIMIT) {
					cubes.add(i * i * i);
					if ((long) i * i * i * i < LIMIT) {
						fouths.add(i * i * i * i);
					}
				}
			}
		}
		HashSet<Integer> sums = add(squares, cubes);
		sums = add(sums, fouths);
		System.out.println(sums.size());
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static HashSet<Integer> add(HashSet<Integer> a, HashSet<Integer> b) {
		HashSet<Integer> c = new HashSet<Integer>();
		for (Iterator<Integer> i = a.iterator(); i.hasNext();) {
			int n1 = i.next();
			for (Iterator<Integer> j = b.iterator(); j.hasNext();) {
				int n2 = j.next();
				if (n1 + n2 < LIMIT) {
					c.add(n1 + n2);
				}
			}
		}
		return c;
	}
}
