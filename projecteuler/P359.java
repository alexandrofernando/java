import java.math.BigInteger;

public class P359 {
	static final int MODULO = 100000000;

	public static void main(String args[]) {
		final long PRODUCT = 71328803586048L;
		int sum = 0;
		for (long i = 1; i * i <= PRODUCT; i++) {
			if (PRODUCT % i == 0) {
				long j = PRODUCT / i;
				sum = addMod(sum, P(i, j));
				if (i != j) {
					sum = addMod(sum, P(j, i));
				}
			}
		}
		System.out.println(sum);
	}

	static int addMod(int a, int b) {
		return (a + b) % MODULO;
	}

	static int multiplyMod(long a, long b) {
		return (int) ((a % MODULO) * (b % MODULO) % MODULO);
	}

	static int multiplyAndHalfMod(long a, long b) {
		return new BigInteger(a + "").multiply(new BigInteger(b + ""))
				.divide(new BigInteger("2")).mod(new BigInteger(MODULO + ""))
				.intValue();
	}

	static int P(long floor, long room) {
		int floorStart = calcFloorStart(floor);
		Offsets floorOffsets = calcFloorOffsets(floor);
		int offset = calcOffset(floorOffsets, room);
		return addMod(floorStart, offset);
	}

	static int sumAP(int a1, int d, long n) {
		int temp = multiplyAndHalfMod(n, n - 1);
		return addMod(multiplyMod(n, a1), multiplyMod(temp, d));
	}

	static int calcOffset(Offsets floorOffsets, long room) {
		if (room % 2 == 0) {
			return addMod(
					floorOffsets.offset1,
					sumAP(addMod(
							addMod(floorOffsets.offset1, floorOffsets.offset2),
							2), 4, room / 2 - 1));
		} else {
			return sumAP(addMod(floorOffsets.offset1, floorOffsets.offset2), 4,
					(room - 1) / 2);
		}
	}

	static Offsets calcFloorOffsets(long floor) {
		if (floor == 1) {
			return new Offsets(2, 3);
		}
		if (floor % 2 == 0) {
			return new Offsets(addMod(multiplyMod(floor, 2), 1), 2);
		} else {
			return new Offsets(1, multiplyMod(floor, 2));
		}
	}

	static int calcFloorStart(long floor) {
		if (floor == 1) {
			return 1;
		}
		return multiplyAndHalfMod(floor, floor);
	}
}

class Offsets {
	int offset1;
	int offset2;

	public Offsets(int offset1, int offset2) {
		this.offset1 = offset1;
		this.offset2 = offset2;
	}
}