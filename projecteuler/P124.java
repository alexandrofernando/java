import java.util.Arrays;
import java.util.Comparator;

public class P124 {
	public static void main(String args[]) {
		Element elements[] = new Element[100001];
		for (int i = 1; i < elements.length; i++) {
			elements[i] = new Element(rad(i), i);
		}
		Arrays.sort(elements, 1, elements.length, new ElementComparator());
		System.out.println(elements[10000].n);
	}

	static int rad(int n) {
		int radical = 1;
		for (int i = 2; i * i <= n; i++) {
			if (isPrime(i) && n % i == 0) {
				radical *= i;
				while (n % i == 0) {
					n /= i;
				}
			}
		}
		if (n > 1) {
			radical *= n;
		}
		return radical;
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

class Element {
	int radical;
	int n;

	Element(int theRadical, int N) {
		this.radical = theRadical;
		this.n = N;
	}
}

class ElementComparator implements Comparator<Element> {
	public int compare(Element e1, Element e2) {
		return (e1.radical != e2.radical) ? (e1.radical - e2.radical)
				: (e1.n - e2.n);
	}
}