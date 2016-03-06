public class P036 {
	public static void main(String args[]) {
		int sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (isPalindromic(i + "")
					&& isPalindromic(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		System.out.println(sum);
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
