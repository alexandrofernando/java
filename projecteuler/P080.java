import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class P080 {
	public static void main(String args[]) throws Exception {
		int total = 0;
		for (int i = 1; i <= 100; i++) {
			double x0 = Math.sqrt(i);
			if ((int) x0 * (int) x0 == i) {
				continue;
			}
			BigDecimal x = new BigDecimal(x0);
			BigDecimal bd_i = new BigDecimal(i);
			BigDecimal bd_2 = new BigDecimal(2);
			BigDecimal threshold = new BigDecimal(BigInteger.ONE, 100);
			while (true) {
				BigDecimal nextX = x.add(bd_i.divide(x, new MathContext(105)))
						.divide(bd_2);
				if (nextX.subtract(x).abs().compareTo(threshold) < 0) {
					break;
				}
				x = nextX;
			}
			String str = x.toPlainString();
			int sum = 0;
			for (int j = 0; j < 101; j++) {
				char ch = str.charAt(j);
				if (ch == '.') {
					continue;
				}
				sum += ch - '0';
			}
			total += sum;
		}
		System.out.println(total);
	}
}
