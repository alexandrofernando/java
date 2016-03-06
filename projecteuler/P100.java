public class P100 {
	public static void main(String args[]) {
		long blue = 15;
		long total = 21;
		while (total <= 1000000000000L) {
			long nextBlue = 3 * blue + 2 * total - 2;
			long nextTotal = 4 * blue + 3 * total - 3;
			blue = nextBlue;
			total = nextTotal;
		}
		System.out.println(blue);
	}
}
