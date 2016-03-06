import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

public class P253 {
	static HashMap<Element, BigInteger> history = new HashMap<Element, BigInteger>();

	public static void main(String args[]) {
		final int CATERPILLAR = 40;
		BigInteger factorial = calcFactorial(CATERPILLAR);
		BigInteger total = BigInteger.ZERO;
		int maxM = (CATERPILLAR + 1) / 2;
		for (int m = 1; m <= maxM; m++) {
			BigInteger waysM = calcWays(CATERPILLAR, 1, m).subtract(
					calcWays(CATERPILLAR, 1, m - 1));
			total = total.add(waysM.multiply(new BigInteger(m + "")));
		}
		System.out.println(new BigDecimal(total).divide(new BigDecimal(
				factorial), 6, BigDecimal.ROUND_HALF_UP));
	}

	static BigInteger calcFactorial(int n) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			factorial = factorial.multiply(new BigInteger(i + ""));
		}
		return factorial;
	}

	static BigInteger calcWays(int pieceNum, int segmentNum, int maxSegmentNum) {
		if (pieceNum == 1 && segmentNum == 1 && maxSegmentNum > 0) {
			return BigInteger.ONE;
		}
		if (pieceNum <= 0 || segmentNum <= 0 || segmentNum > maxSegmentNum) {
			return BigInteger.ZERO;
		}
		Element element = new Element(pieceNum, segmentNum, maxSegmentNum);
		BigInteger wayNum = history.get(element);
		if (wayNum != null) {
			return wayNum;
		}
		BigInteger addend1 = calcWays(pieceNum - 1, segmentNum - 1,
				maxSegmentNum).multiply(new BigInteger(segmentNum + ""));
		BigInteger addend2 = calcWays(pieceNum - 1, segmentNum + 1,
				maxSegmentNum).multiply(new BigInteger(segmentNum + ""));
		BigInteger addend3 = calcWays(pieceNum - 1, segmentNum, maxSegmentNum)
				.multiply(new BigInteger(segmentNum + "")).multiply(
						new BigInteger("2"));
		BigInteger ways = addend1.add(addend2).add(addend3);
		history.put(element, ways);
		return ways;
	}
}

class Element {
	int pieceNum;
	int segmentNum;
	int maxSegmentNum;

	public Element(int pieceNum, int segmentNum, int maxSegmentNum) {
		this.pieceNum = pieceNum;
		this.segmentNum = segmentNum;
		this.maxSegmentNum = maxSegmentNum;
	}

	@Override
	public int hashCode() {
		return pieceNum * segmentNum * maxSegmentNum;
	}

	@Override
	public boolean equals(Object obj) {
		Element other = (Element) obj;
		return pieceNum == other.pieceNum && segmentNum == other.segmentNum
				&& maxSegmentNum == other.maxSegmentNum;
	}
}