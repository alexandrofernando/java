public class P276 {
	public static void main(String args[]) {
		final int LIMIT = 10000000;
		long primitives[] = new long[LIMIT + 1];
		long sum = 0;
		for (int i = 3; i < primitives.length; i++) {
			primitives[i] += calcTriangleNumber(i);
			sum += primitives[i];
			for (int j = i + i; j < primitives.length; j += i) {
				primitives[j] -= primitives[i];
			}
		}
		System.out.println(sum);
	}

	static long calcTriangleNumber(long perimeter) {
		long mod = perimeter % 12;
		if (mod == 0) {
			return perimeter * perimeter / 48;
		} else if (mod == 1) {
			return ((perimeter + 3) * (perimeter + 3) - 16) / 48;
		} else if (mod == 2) {
			return (perimeter * perimeter - 4) / 48;
		} else if (mod == 3) {
			return ((perimeter + 3) * (perimeter + 3) + 12) / 48;
		} else if (mod == 4) {
			return (perimeter * perimeter - 16) / 48;
		} else if (mod == 5) {
			return ((perimeter + 3) * (perimeter + 3) - 16) / 48;
		} else if (mod == 6) {
			return (perimeter * perimeter + 12) / 48;
		} else if (mod == 7) {
			return ((perimeter + 3) * (perimeter + 3) - 4) / 48;
		} else if (mod == 8) {
			return (perimeter * perimeter - 16) / 48;
		} else if (mod == 9) {
			return (perimeter + 3) * (perimeter + 3) / 48;
		} else if (mod == 10) {
			return (perimeter * perimeter - 4) / 48;
		} else if (mod == 11) {
			return ((perimeter + 3) * (perimeter + 3) - 4) / 48;
		}
		return -1;
	}
}
