import java.util.Hashtable;

public class P062 {
	public static void main(String args[]) {
		Hashtable<Digits, Cubes> dc = new Hashtable<Digits, Cubes>();
		for (int i = 100;; i++) {
			long number = (long) i * i * i;
			Digits d = new Digits(number);
			Cubes c = dc.get(d);
			if (c != null) {
				if (c.cubeNum == 4) {
					System.out.println(c.minCube);
					break;
				} else {
					c.cubeNum++;
				}
			} else {
				dc.put(d, new Cubes(number, 1));
			}
		}
	}
}

class Digits {
	int digits[];

	Digits(long number) {
		this.digits = new int[10];
		while (number != 0) {
			digits[(int) (number % 10)]++;
			number /= 10;
		}
	}

	public int hashCode() {
		int code = 0;
		for (int i = 0; i < digits.length; i++) {
			code += digits[i] * i * i * i * i;
		}
		return code;
	}

	public boolean equals(Object obj) {
		Digits another = (Digits) obj;
		for (int i = 0; i < this.digits.length; i++) {
			if (this.digits[i] != another.digits[i]) {
				return false;
			}
		}
		return true;
	}
}

class Cubes {
	long minCube;
	int cubeNum;

	Cubes(long theMinCube, int theCubeNum) {
		this.minCube = theMinCube;
		this.cubeNum = theCubeNum;
	}
}