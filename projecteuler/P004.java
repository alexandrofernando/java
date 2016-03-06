public class P004 {
	public static void main(String args[]) {
		int max = -1;
		for (int i = 100; i <= 999; i++) {
			for (int j = 100; j <= 999; j++) {
				int product = i * j;
				if (isPalindrome(product + "") && product > max) {
					max = product;
				}
			}
		}
		System.out.println(max);
	}

	static boolean isPalindrome(String str) {
		int pos1 = 0;
		int pos2 = str.length() - 1;
		while (pos1 <= pos2 && str.charAt(pos1) == str.charAt(pos2)) {
			pos1++;
			pos2--;
		}
		return !(pos1 <= pos2);
	}
}
