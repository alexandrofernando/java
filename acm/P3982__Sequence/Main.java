package P3982__Sequence;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			BigInteger an3 = new BigInteger(in.next());
			BigInteger an2 = new BigInteger(in.next());
			BigInteger an1 = new BigInteger(in.next());
			for (int n = 3; n <= 99; n++) {
				BigInteger an = an1.add(an2.add(an3));
				an3 = an2;
				an2 = an1;
				an1 = an;
			}
			System.out.println(an1);
		}

		in.close();
	}
}
