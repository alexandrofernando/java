import java.io.IOException;

public class P286 {
	public static void main(String args[]) throws IOException {
		double top = 100;
		double bottom = 51;
		String previous = "";
		while (true) {
			double middle = (top + bottom) / 2;
			String current = toTenDigits(middle);
			if (current.equals(previous)) {
				System.out.println(current);
				break;
			}
			if (probable(middle) < 0.02) {
				top = middle;
			} else {
				bottom = middle;
			}
			previous = current;
		}
	}

	static String toTenDigits(double number) {
		String str = number + "";
		int count = 0;
		boolean point = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				point = true;
			} else if (point) {
				count++;
			}
			if (count == 10) {
				return str.substring(0, i + 1);
			}
		}
		return str;
	}

	static double probable(double q) {
		double p[][] = new double[51][21];
		p[0][0] = 1;
		for (int x = 1; x < p.length; x++) {
			for (int point = 0; point < p[0].length; point++) {
				p[x][point] = x / q * p[x - 1][point];
				if (point >= 1) {
					p[x][point] += (1 - x / q) * p[x - 1][point - 1];
				}
			}
		}
		return p[50][20];
	}
}
