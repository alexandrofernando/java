public class P173 {
	public static void main(String args[]) {
		int count = 0;
		for (int i = 1; i * i < 250000; i++) {
			count += 250000 / i - i;
		}
		System.out.println(count);
	}
}
