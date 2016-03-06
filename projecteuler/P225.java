import java.util.HashSet;

public class P225 {
	public static void main(String args[]) {
		int number = -1;
		for (int i = 0; i < 124; i++) {
			number += 2;
			while (isDividable(number)) {
				number += 2;
			}
			System.out.println(number);
		}
		System.out.println(number);
	}

	static boolean isDividable(int modulo) {
		int t3 = 1;
		int t2 = 1;
		int t1 = 1;
		HashSet<Combination> history = new HashSet<Combination>();
		history.add(new Combination(modulo, t3, t2, t1));
		while (true) {
			int t = (t3 + t2 + t1) % modulo;
			if (t == 0) {
				return true;
			}
			t3 = t2;
			t2 = t1;
			t1 = t;
			Combination next = new Combination(modulo, t3, t2, t1);
			if (!history.add(next)) {
				return false;
			}
		}
	}
}

class Combination {
	int modulo;
	int t3;
	int t2;
	int t1;

	Combination(int theModulo, int T3, int T2, int T1) {
		this.modulo = theModulo;
		this.t3 = T3;
		this.t2 = T2;
		this.t1 = T1;
	}

	public boolean equals(Object obj) {
		Combination another = (Combination) obj;
		return this.t3 == another.t3 && this.t2 == another.t2
				&& this.t1 == another.t1;
	}

	public int hashCode() {
		return this.t3 * modulo * modulo + this.t2 * modulo + this.t1;
	}

}