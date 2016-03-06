public class P104 {
	public static void main(String args[]) {
		final int FIRST_PRECISION = 17;
		long Fk_2_last9 = 1;
		long Fk_1_last9 = 1;
		long Fk_2_first9 = 1;
		long Fk_1_first9 = 1;
		int k = 3;
		while (true) {
			long Fk_last9 = (Fk_2_last9 + Fk_1_last9) % 1000000000;
			long sum = Fk_2_first9 + Fk_1_first9;
			String temp = new String(sum + "");
			boolean leftShift = temp.length() > FIRST_PRECISION
					&& temp.length() > new String(Math.max(Fk_2_first9,
							Fk_1_first9) + "").length();
			int end = Math.min(FIRST_PRECISION, temp.length());
			long Fk_first9 = Long.parseLong(temp.substring(0, end));
			if (isPandigital(Fk_last9) && isPandigital(Fk_first9)) {
				System.out.println(k);
				break;
			}
			Fk_2_last9 = Fk_1_last9;
			Fk_1_last9 = Fk_last9;
			Fk_2_first9 = leftShift ? Fk_1_first9 / 10 : Fk_1_first9;
			Fk_1_first9 = Fk_first9;
			k++;
		}
	}

	static boolean isPandigital(long number) {
		String str = number + "";
		if (str.length() < 9) {
			return false;
		}
		str = str.substring(0, 9);
		for (int i = 1; i <= 9; i++) {
			if (str.indexOf(i + '0') == -1) {
				return false;
			}
		}
		return true;
	}
}
