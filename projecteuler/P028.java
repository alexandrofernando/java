public class P028 {
	public static void main(String args[]) {
		int sum = 1;
		int a1 = 3;
		int d = 2;
		for (int i = 1; i <= 500; i++) {
			sum += 4 * a1 + 6 * d;
			a1 += 3 * d + 2 * (i + 1);
			d += 2;
		}
		System.out.println(sum);
	}
}
