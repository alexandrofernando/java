public class P106 {
	public static void main(String args[]) {
		final int N = 12;
		int limit = (int) Math.pow(3, N);
		int count = 0;
		for (int i = 0; i < limit; i++) {
			int set[] = decode(i, N);
			if (needTest(set)) {
				count++;
			}
		}
		System.out.println(count);
	}

	static int[] decode(int number, int size) {
		int a[] = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = number % 3;
			number /= 3;
		}
		return a;
	}

	static boolean needTest(int set[]) {
		int first1 = -1;
		int first2 = -1;
		int count1 = 0;
		int count2 = 0;
		int mark = 0;
		boolean positive = false;
		boolean negative = false;
		for (int i = 0; i < set.length; i++) {
			if (set[i] == 1) {
				if (first1 < 0) {
					first1 = i;
				}
				count1++;
				mark++;
			} else if (set[i] == 2) {
				if (first2 < 0) {
					first2 = i;
				}
				count2++;
				mark--;
			}
			if (mark > 0) {
				positive = true;
			} else if (mark < 0) {
				negative = true;
			}
		}
		return first1 >= 0 && first2 >= 0 && first1 < first2
				&& count1 == count2 && positive && negative;
	}
}
