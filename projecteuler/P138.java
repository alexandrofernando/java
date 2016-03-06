public class P138 {
	public static void main(String args[]) {
		Irrational base = new Irrational(2, 1);
		Irrational number = new Irrational(1, 0);
		long sum = 0;
		for (int i = 1; i <= 12 * 2 + 1; i++) {
			number.multiply(base);
			if (i % 2 == 1 && i != 1) {
				sum += number.y;
			}
		}
		System.out.println(sum);
	}
}

class Irrational { // z + y * sqrt(5)
	long z;
	long y;

	Irrational(long Z, long Y) {
		this.z = Z;
		this.y = Y;
	}

	void multiply(Irrational another) {
		long newZ = this.z * another.z + this.y * another.y * 5;
		long newY = this.z * another.y + this.y * another.z;
		this.z = newZ;
		this.y = newY;
	}
}