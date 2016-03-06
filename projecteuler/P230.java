public class P230 {
	static final int LENGTH = 100;
	static String A = "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
	static String B = "8214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196";
	static int back;
	static long pos;
	static int minSequence;

	public static void main(String args[]) {
		long answer = 0;
		long power10 = 1;
		long power7 = 1;
		for (int n = 0; n <= 17; n++) {
			answer += power10 * D((127 + 19 * n) * power7);
			power10 *= 10;
			power7 *= 7;
		}
		System.out.println(answer);
	}

	static int D(long position) {
		int digitPos = (int) ((position - 1) % LENGTH);
		long letterPos = (position - 1) / LENGTH + 1;
		if (letterPos == 1) {
			minSequence = 1;
		} else {
			simplify(2, 1, 1, letterPos);
		}
		if (minSequence == 1) {
			return A.charAt(digitPos) - '0';
		} else {
			return B.charAt(digitPos) - '0';
		}
	}

	static void simplify(int sequence, long length1, long length2, long target) {
		if (target <= length2) {
			back = 1;
			pos = target - (length2 - length1);
			minSequence = sequence - back;
			return;
		}
		simplify(sequence + 1, length2, length1 + length2, target);
		back--;
		if (back > 0) {
			return;
		}
		if (sequence <= 2) {
			return;
		}
		if (pos <= length2 - length1) {
			back = 2;
		} else {
			back = 1;
			pos -= length2 - length1;
		}
		minSequence = sequence - back;
	}
}
