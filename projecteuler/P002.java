public class P002 {
	public static void main(String args[]) {
		int fa = 1;
		int fb = 2;
		int fc = -1;
		int sum = 2;
		while (fc <= 4000000) {
			fc = fa + fb;
			if (fc % 2 == 0) {
				sum += fc;
			}
			fa = fb;
			fb = fc;
		}
		System.out.println(sum);
	}
}
