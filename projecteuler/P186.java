public class P186 {
	static int s[] = new int[55];
	static Node nodes[] = new Node[1000000];

	public static void main(String args[]) {
		final int PM = 524287;
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i, 1);
		}
		for (int i = 0; i < s.length; i++) {
			s[i] = -1;
		}
		int success = 0;
		int indexS = 0;
		while (true) {
			int caller = generateS(indexS);
			indexS = (indexS + 1) % s.length;
			int called = generateS(indexS);
			indexS = (indexS + 1) % s.length;
			if (caller == called) {
				continue;
			}
			success++;
			int rootA = findRoot(caller);
			int rootB = findRoot(called);
			if (rootA == rootB) {
				continue;
			}
			if (rootA != PM) {
				nodes[rootA].parent = rootB;
				nodes[rootB].count += nodes[rootA].count;
			} else {
				nodes[rootB].parent = rootA;
				nodes[rootA].count += nodes[rootB].count;
			}
			if (nodes[PM].count * 100 >= nodes.length * 99) {
				break;
			}
		}
		System.out.println(success);
	}

	static int generateS(int index) {
		if (s[index] < 0) {
			return s[index] = (int) ((100003 - 200003L * (index + 1) + 300007L
					* (index + 1) * (index + 1) * (index + 1)) % 1000000);
		} else {
			return s[index] = (s[(index - 24 + s.length) % s.length] + s[(index - 55 + s.length)
					% s.length]) % 1000000;
		}
	}

	static int findRoot(int index) {
		int root = index;
		while (nodes[root].parent != root) {
			root = nodes[root].parent;
		}
		int p = index;
		while (p != root) {
			int temp = nodes[p].parent;
			nodes[p].parent = root;
			p = temp;
		}
		return root;
	}
}

class Node {
	int parent;
	int count;

	Node(int theParent, int theCount) {
		this.parent = theParent;
		this.count = theCount;
	}
}