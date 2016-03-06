package P1860__Currency_Exchange;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean visited[];
	static boolean reachS[];
	static ArrayList<Exchange> exchanges[];
	static BigDecimal quantities[];
	static final BigDecimal NO_QUANTITY = new BigDecimal(-1);
	static final BigDecimal EPSILON = new BigDecimal(1E-12);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int S = in.nextInt();
		double V = in.nextDouble();
		exchanges = new ArrayList[N + 1];
		for (int i = 1; i < exchanges.length; i++) {
			exchanges[i] = new ArrayList<Exchange>();
		}
		for (int i = 0; i < M; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			double R_AB = in.nextDouble();
			double C_AB = in.nextDouble();
			double R_BA = in.nextDouble();
			double C_BA = in.nextDouble();
			exchanges[A].add(new Exchange(B, R_AB, C_AB));
			exchanges[B].add(new Exchange(A, R_BA, C_BA));
		}

		reachS = new boolean[N + 1];
		for (int i = 1; i < exchanges.length; i++) {
			visited = new boolean[N + 1];
			reachS[i] = dfsReach(i, S);
		}

		quantities = new BigDecimal[N + 1];
		Arrays.fill(quantities, NO_QUANTITY);
		boolean increase = dfsIncrease(S, new BigDecimal(V));
		System.out.println(increase ? "YES" : "NO");

		in.close();
	}

	static boolean dfsIncrease(int v, BigDecimal quantity) {
		quantities[v] = quantity;
		for (Exchange exchange : exchanges[v]) {
			if (!reachS[exchange.to]) {
				continue;
			}
			BigDecimal nextQuantity = quantity.subtract(
					new BigDecimal(exchange.commission)).multiply(
					new BigDecimal(exchange.rate));
			if (nextQuantity.compareTo(BigDecimal.ZERO) < 0) {
				continue;
			}

			if (quantities[exchange.to] == NO_QUANTITY) {
				if (dfsIncrease(exchange.to, nextQuantity)) {
					return true;
				}
			} else if (nextQuantity.subtract(quantities[exchange.to])
					.compareTo(EPSILON) > 0) {
				return true;
			}
		}
		quantities[v] = NO_QUANTITY;
		return false;
	}

	static boolean dfsReach(int v, int target) {
		if (v == target) {
			return true;
		}
		visited[v] = true;
		for (Exchange exchange : exchanges[v]) {
			if (!visited[exchange.to]) {
				if (dfsReach(exchange.to, target)) {
					return true;
				}
			}
		}
		visited[v] = false;
		return false;
	}
}

class Exchange {
	int to;
	double rate;
	double commission;

	public Exchange(int to, double rate, double commission) {
		this.to = to;
		this.rate = rate;
		this.commission = commission;
	}
}