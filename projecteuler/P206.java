public class P206 {
	public static void main(String args[]) {
		for (long i = 1000000000; i * i < 2000000000000000000L; i += 10) {
			long number = i * i;
			if (isValid(number + "")) {
				System.out.println(i);
				break;
			}
		}
	}

	static boolean isValid(String str) {
		for (int i = 0; i < str.length(); i += 2) {
			if (str.charAt(i) - '0' != (i / 2 + 1) % 10) {
				return false;
			}
		}
		return true;
	}
}
