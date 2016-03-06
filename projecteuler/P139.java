import java.util.HashSet;

public class P139 {
	public static void main(String args[]) {
		final int LIMIT = 100000000;
		HashSet<Triangle> triangles = new HashSet<Triangle>();
		int count = 0;
		for (int n = 1;; n++) {
			boolean first = true;
			for (int m = n + 1;; m++) {
				int a = 2 * m * n;
				int b = m * m - n * n;
				if (a > b) {
					int temp = a;
					a = b;
					b = temp;
				}
				int c = m * m + n * n;
				if (a + b + c >= LIMIT) {
					break;
				}
				first = false;
				int common = gcd(gcd(a, b), c);
				a /= common;
				b /= common;
				c /= common;
				if (c % (b - a) == 0) {
					Triangle t = new Triangle(a, b, c);
					if (!triangles.contains(t)) {
						count += (LIMIT - 1) / (a + b + c);
						triangles.add(t);
					}
				}
			}
			if (first) {
				break;
			}
		}
		System.out.println(count);
	}

	static int gcd(int a, int b) {
		while (a != 0) {
			int c = b % a;
			b = a;
			a = c;
		}
		return b;
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

	public int hashCode() {
		return a * b * c;
	}

	public boolean equals(Object obj) {
		Triangle another = (Triangle) obj;
		return this.a == another.a && this.b == another.b
				&& this.c == another.c;
	}
}