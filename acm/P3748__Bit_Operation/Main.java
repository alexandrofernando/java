package P3748__Bit_Operation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str[] = in.next().split(",");
		long value = Long.parseLong(str[0], 16);
		int x = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[2]);
		value &= ~(1L << x);
		value |= 3L << (y - 1);
		value &= ~(1L << (y - 2));
		System.out.println(Long.toHexString(value));
	}
}
