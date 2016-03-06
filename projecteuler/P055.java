import java.math.BigInteger;

public class P055 {
	public static void main(String args[]) {
		int count = 0;
		for (int i = 0; i < 10000; i++) {
			BigInteger number = new BigInteger(i + "");
			boolean arrive = false;
			for (int j = 0; j < 49; j++) {
				BigInteger reverse = new BigInteger(new StringBuffer(
						number.toString()).reverse().toString());
				number = number.add(reverse);
				if (isPalindrome(number.toString())) {
					arrive = true;
					break;
				}
			}
			if (!arrive) {
				count++;
			}
		}
		System.out.println(count);
	}

	static boolean isPalindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
