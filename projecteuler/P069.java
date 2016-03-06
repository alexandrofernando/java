import java.util.ArrayList;

public class P069 {
	public static void main(String args[]) {
		int maxN = 0;
		int maxPhi = 1;
		for (int i = 2; i <= 1000000; i++) {
			ArrayList<Integer> primeFractors = factor(i);
			int size = primeFractors.size();
			int phi = 0;
			for (int j = 0, limit = 1 << size; j < limit; j++) {
				boolean flags[] = decode(j, size);
				int count = 0;
				int fac = 1;
				for (int k = 0; k < flags.length; k++) {
					if (flags[k]) {
						fac *= primeFractors.get(k);
						count++;
					}
				}
				int num = i / fac;
				if (count % 2 == 0) {
					phi += num;
				} else {
					phi -= num;
				}
			}
			if ((long) i * maxPhi > (long) maxN * phi) {
				maxN = i;
				maxPhi = phi;
			}
		}
		System.out.println(maxN);
	}

	static boolean[] decode(int number, int size) {
		boolean f[] = new boolean[size];
		for (int i = 0; i < size; i++) {
			f[i] = (number % 2 == 1) ? true : false;
			number /= 2;
		}
		return f;
	}

	static ArrayList<Integer> factor(int number) {
		ArrayList<Integer> p = new ArrayList<Integer>();
		for (int i = 2; i * i <= number; i++) {
			if (isPrime(i) && number % i == 0) {
				p.add(i);
				while (number % i == 0) {
					number /= i;
				}
			}
		}
		if (number > 1) {
			p.add(number);
		}
		return p;
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
