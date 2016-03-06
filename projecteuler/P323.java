import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class P323 {
	public static void main(String args[]) {
		final int DIGIT_NUM = 32;
		ArrayList<BigDecimal> probs = new ArrayList<BigDecimal>();
		BigDecimal probAllZero = new BigDecimal("0.5");
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal roundedSum = BigDecimal.ZERO;
		for (int n = 1;; n++) {
			BigDecimal newProb = BigDecimal.ONE.subtract(probAllZero);
			newProb = newProb.pow(DIGIT_NUM);
			for (BigDecimal prob : probs) {
				newProb = newProb.subtract(prob);
			}
			probs.add(newProb);
			sum = sum.add(newProb.multiply(new BigDecimal(n + "")));
			BigDecimal newRoundedSum = sum.setScale(10, RoundingMode.HALF_UP);
			if (roundedSum.compareTo(newRoundedSum) == 0) {
				System.out.println(roundedSum);
				break;
			}
			roundedSum = newRoundedSum;
			probAllZero = probAllZero.divide(new BigDecimal(2));
		}
	}
}
