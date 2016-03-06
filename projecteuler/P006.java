public class P006 {
	public static void main(String args[]) {
		int sum = 0;
		int sumSqure = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			sumSqure += i * i;
		}
		int squreSum = sum * sum;
		System.out.println(squreSum - sumSqure);
	}
}
