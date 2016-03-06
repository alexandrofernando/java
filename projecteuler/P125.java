import java.util.HashSet;

public class P125 {
	public static void main(String args[]) {
		long sums[] = new long[10000];
		long sum = 0;
		for (int i = 1; i < sums.length; i++) {
			sum += i * i;
			sums[i] = sum;
		}
		HashSet<Long> solutions = new HashSet<Long>();
		long answer = 0;
		for (int i = 1; i < sums.length; i++) {
			for (int j = i - 2; j >= 0; j--) {
				long consecutive = sums[i] - sums[j];
				if (consecutive >= 100000000) {
					break;
				}
				if (isPalindromic(consecutive + "")
						&& !solutions.contains(consecutive)) {
					answer += consecutive;
					solutions.add(consecutive);
				}
			}
		}
		System.out.println(answer);
	}

	static boolean isPalindromic(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
