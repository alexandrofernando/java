import java.util.ArrayList;
import java.util.Arrays;

public class P170 {
	static String answer = "";

	public static void main(String args[]) {
		roll(new StringBuffer("0123456789"), 0);
		System.out.println(answer);
	}

	static void roll(StringBuffer str, int index) {
		if (index == str.length()) {
			split(str, new ArrayList<Integer>(), new boolean[str.length()], "",
					0);
			return;
		}
		for (int i = index; i < str.length(); i++) {
			char temp = str.charAt(index);
			str.setCharAt(index, str.charAt(i));
			str.setCharAt(i, temp);
			roll(str, index + 1);
			temp = str.charAt(index);
			str.setCharAt(index, str.charAt(i));
			str.setCharAt(i, temp);
		}
	}

	static void split(StringBuffer str, ArrayList<Integer> numbers,
			boolean appears[], String result, int index) {
		if (index == str.length()) {
			if (result.length() == str.length() && result.compareTo(answer) > 0) {
				answer = result;
			}
			return;
		}
		if (!result.equals("") && !answer.equals("")
				&& result.compareTo(answer.substring(0, result.length())) < 0) {
			return;
		}
		if (str.charAt(index) == '0') {
			return;
		}
		int number = 0;
		for (int i = index; i < str.length(); i++) {
			number = number * 10 + (str.charAt(i) - '0');
			if (numbers.isEmpty()) {
				numbers.add(number);
				split(str, numbers, appears, result, i + 1);
				numbers.remove(numbers.size() - 1);
			} else {
				long product = (long) numbers.get(0) * number;
				if (valid(appears, product)) {
					numbers.add(number);
					fill(appears, product, true);
					split(str, numbers, appears, result + product, i + 1);
					numbers.remove(numbers.size() - 1);
					fill(appears, product, false);
				}
			}
		}
	}

	static boolean valid(boolean appears[], long number) {
		boolean appears1[] = Arrays.copyOf(appears, appears.length);
		String str = number + "";
		for (int i = 0; i < str.length(); i++) {
			int digit = str.charAt(i) - '0';
			if (appears1[digit]) {
				return false;
			}
			appears1[digit] = true;
		}
		return true;
	}

	static void fill(boolean appears[], long number, boolean value) {
		String str = number + "";
		for (int i = 0; i < str.length(); i++) {
			int digit = str.charAt(i) - '0';
			appears[digit] = value;
		}
	}
}
