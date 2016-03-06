import java.util.Calendar;
import java.util.TimeZone;

public class P019 {
	public static void main(String args[]) {
		Calendar calendar = Calendar.getInstance(TimeZone
				.getTimeZone("GMT+8:00"));
		int count = 0;
		for (int year = 1901; year < 2001; year++) {
			for (int month = 0; month < 12; month++) {
				calendar.set(year, month, 1);
				if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
