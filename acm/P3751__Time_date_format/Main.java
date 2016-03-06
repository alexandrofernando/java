package P3751__Time_date_format;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for (int t = 1; t <= test; t++) {
			String str = in.next();
			int hour_24 = Integer.parseInt(str.substring(11, 13));
			String meridiem = (hour_24 < 12) ? "am" : "pm";
			int hour_12 = hour_24 % 12;
			if (0 == hour_12) {
				hour_12 = 12;
			}
			System.out.println(str.substring(5, 10) + "/" + str.substring(0, 4)
					+ "-" + ((hour_12 < 10) ? "0" : "") + hour_12
					+ str.substring(13) + meridiem);
		}
	}
}
