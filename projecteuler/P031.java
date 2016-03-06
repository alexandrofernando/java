public class P031 {
	public static void main(String args[]) {
		int count = 0;
		int rest = 200;
		for (int a = 0; a <= rest / 200; a++) {
			rest -= a * 200;
			for (int b = 0; b <= rest / 100; b++) {
				rest -= b * 100;
				for (int c = 0; c <= rest / 50; c++) {
					rest -= c * 50;
					for (int d = 0; d <= rest / 20; d++) {
						rest -= d * 20;
						for (int e = 0; e <= rest / 10; e++) {
							rest -= e * 10;
							for (int f = 0; f <= rest / 5; f++) {
								rest -= f * 5;
								for (int g = 0; g <= rest / 2; g++) {
									count++;
								}
								rest += f * 5;
							}
							rest += e * 10;
						}
						rest += d * 20;
					}
					rest += c * 50;
				}
				rest += b * 100;
			}
			rest += a * 200;
		}
		System.out.println(count);
	}
}
