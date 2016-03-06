package P3233__Matrix_Power_Series;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int m = in.nextInt();
		int A[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = in.nextInt();
			}
		}

		int B[][] = new int[n * 2][n * 2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				B[i][j] = A[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			B[i][i + n] = 1;
			B[i + n][i + n] = 1;
		}
		int Bk1[][] = pow(B, k + 1, m);
		for (int i = 0; i < n; i++) {
			for (int j = n; j < n * 2; j++) {
				if (j != n) {
					System.out.print(" ");
				}
				int Sij = (i == j - n) ? ((Bk1[i][j] - 1 + m) % m) : Bk1[i][j];
				System.out.print(Sij);
			}
			System.out.println();
		}

		in.close();
	}

	static int[][] pow(int a[][], int power, int modulo) {
		int size = a.length;
		int result[][] = new int[size][size];
		int base[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			result[i][i] = 1;
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				base[i][j] = a[i][j];
			}
		}
		while (power != 0) {
			if (power % 2 != 0) {
				result = multiply(result, base, modulo);
			}
			base = multiply(base, base, modulo);
			power /= 2;
		}
		return result;
	}

	static int[][] multiply(int a[][], int b[][], int modulo) {
		int size = a.length;
		int result[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					result[i][j] = addMod(result[i][j],
							multiplyMod(a[i][k], b[k][j], modulo), modulo);
				}
			}
		}
		return result;
	}

	static int addMod(int a, int b, int modulo) {
		return (a + b) % modulo;
	}

	static int multiplyMod(int a, int b, int modulo) {
		return a * b % modulo;
	}
}
