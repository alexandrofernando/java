public class P129 {
	public static void main(String args[]) {
		for (int i = 1000001;; i += 2) {
			if (i % 5 == 0) {
				continue;
			}
			if (repunitLen(i) > 1000000) {
				System.out.println(i);
				break;
			}
		}
	}

	static int repunitLen(int number) {
		int p = 1;
		int reminder = 1;
		while (reminder != 0) {
			p++;
			reminder = (reminder * 10 + 1) % number;
		}
		return p;
	}
}
