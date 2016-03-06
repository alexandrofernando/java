public class P040 {
	public static void main(String args[]) {
		int answer = 1;
		int number = 1;
		int n = 0;
		while (n < 1000000) {
			String str = new String(number + "");
			for (int i = 0; i < str.length(); i++) {
				n++;
				double temp = Math.log10(n);
				if (Math.floor(temp) == temp) {
					answer *= str.charAt(i) - '0';
				}
			}
			number++;
		}
		System.out.println(answer);
	}
}
