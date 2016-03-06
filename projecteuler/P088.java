import java.util.HashSet;
import java.util.LinkedList;

public class P088 {
	public static void main(String args[]) {
		final int LIMIT = 12000;
		int min[] = new int[LIMIT + 1];
		for (int i = 0; i < min.length; i++) {
			min[i] = Integer.MAX_VALUE;
		}
		LinkedList<Product_Sum> queue = new LinkedList<Product_Sum>();
		queue.add(new Product_Sum(1, 0, 2, 0));
		while (!queue.isEmpty()) {
			Product_Sum head = queue.poll();
			for (int i = head.lastNumber; i <= LIMIT; i++) {
				int nextProduct = head.product * i;
				int nextSum = head.sum + i;
				int totalLength = nextProduct - nextSum + head.length + 1;
				if (totalLength > LIMIT) {
					break;
				}
				min[totalLength] = Math.min(min[totalLength], nextProduct);
				queue.offer(new Product_Sum(nextProduct, nextSum, i,
						head.length + 1));
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		int sum = 0;
		for (int i = 2; i < min.length; i++) {
			if (set.add(min[i])) {
				sum += min[i];
			}
		}
		System.out.println(sum);
	}
}

class Product_Sum {
	int product;
	int sum;
	int lastNumber;
	int length;

	Product_Sum(int theProduct, int theSum, int theLastNumber, int theLength) {
		this.product = theProduct;
		this.sum = theSum;
		this.lastNumber = theLastNumber;
		this.length = theLength;
	}
}