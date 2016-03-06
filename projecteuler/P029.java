import java.math.BigInteger;
import java.util.HashSet;

public class P029 {
	public static void main(String args[]) {
		HashSet<String> terms = new HashSet<String>();
		for (int a = 2; a <= 100; a++) {
			BigInteger n = new BigInteger(a + "");
			for (int b = 2; b <= 100; b++) {
				n = n.multiply(new BigInteger(a + ""));
				terms.add(n.toString());
			}
		}
		System.out.println(terms.size());
	}
}
