public class P196 {
	static long baseOffset;
	static boolean nonPrimes[];

	public static void main(String args[]) {
		System.out.println(s(5678027) + s(7208785));
	}

	static long s(int row) {
		buildPrimes((long) (row - 3) * (row - 2) / 2 + 1, (long) (row + 2)
				* (row + 3) / 2);
		long sum = 0;
		long begin = (long) row * (row - 1) / 2;
		for (int column = 1; column <= row; column++) {
			long n = begin + column;
			if (isPrime(n)) {
				Element e = new Element(row, column, n);
				boolean triplet = false;
				if (countNeighborPrime(e) >= 2) {
					triplet = true;
				} else {
					Element neighbors[] = getNeighbors(e);
					for (Element neighbor : neighbors) {
						if (isPrime(neighbor.number)
								&& countNeighborPrime(neighbor) >= 2) {
							triplet = true;
							break;
						}
					}
				}
				if (triplet) {
					sum += n;
				}
			}
		}
		return sum;
	}

	static void buildPrimes(long begin, long end) {
		baseOffset = begin;
		boolean sieved[] = new boolean[(int) Math.floor(Math.sqrt(end)) + 1];
		nonPrimes = new boolean[(int) (end - begin + 1)];
		for (int i = 2; i < sieved.length; i++) {
			if (!sieved[i]) {
				for (int j = i + i; j < sieved.length; j += i) {
					sieved[j] = true;
				}
				int start = (int) ((i - begin % i) % i) + (begin <= i ? i : 0);
				for (int j = start; j < nonPrimes.length; j += i) {
					nonPrimes[j] = true;
				}
			}
		}
	}

	static boolean isPrime(long number) {
		return !nonPrimes[(int) (number - baseOffset)];
	}

	static int countNeighborPrime(Element e) {
		Element neighbors[] = getNeighbors(e);
		int count = 0;
		for (Element neighbor : neighbors) {
			if (isPrime(neighbor.number)) {
				count++;
			}
		}
		return count;
	}

	static Element[] getNeighbors(Element e) {
		if (e.column == 1) {
			return new Element[] {
					new Element(e.row - 1, e.column, e.number - e.row + 1),
					new Element(e.row - 1, e.column + 1, e.number - e.row + 2),
					new Element(e.row, e.column + 1, e.number + 1),
					new Element(e.row + 1, e.column + 1, e.number + e.row + 1),
					new Element(e.row + 1, e.column, e.number + e.row) };
		} else if (e.column + 1 == e.row) {
			return new Element[] {
					new Element(e.row - 1, e.column - 1, e.number - e.row),
					new Element(e.row - 1, e.column, e.number - e.row + 1),
					new Element(e.row, e.column + 1, e.number + 1),
					new Element(e.row + 1, e.column + 1, e.number + e.row + 1),
					new Element(e.row + 1, e.column, e.number + e.row),
					new Element(e.row + 1, e.column - 1, e.number + e.row - 1),
					new Element(e.row, e.column - 1, e.number - 1) };
		} else if (e.column == e.row) {
			return new Element[] {
					new Element(e.row - 1, e.column - 1, e.number - e.row),
					new Element(e.row + 1, e.column + 1, e.number + e.row + 1),
					new Element(e.row + 1, e.column, e.number + e.row),
					new Element(e.row + 1, e.column - 1, e.number + e.row - 1),
					new Element(e.row, e.column - 1, e.number - 1) };
		} else {
			return new Element[] {
					new Element(e.row - 1, e.column - 1, e.number - e.row),
					new Element(e.row - 1, e.column, e.number - e.row + 1),
					new Element(e.row - 1, e.column + 1, e.number - e.row + 2),
					new Element(e.row, e.column + 1, e.number + 1),
					new Element(e.row + 1, e.column + 1, e.number + e.row + 1),
					new Element(e.row + 1, e.column, e.number + e.row),
					new Element(e.row + 1, e.column - 1, e.number + e.row - 1),
					new Element(e.row, e.column - 1, e.number - 1) };
		}
	}
}

class Element {
	int row;
	int column;
	long number;

	Element(int theRow, int theColumn, long theNumber) {
		this.row = theRow;
		this.column = theColumn;
		this.number = theNumber;
	}
}