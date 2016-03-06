package TreeHeight;

class Tree {
	public int x;
	public Tree l;
	public Tree r;
}

// http://codility.com/demo/results/demoRRYRT3-WVV/

public class Solution {
	public int solution(Tree T) {
		if (T == null) {
			return -1;
		}
		return 1 + Math.max(solution(T.l), solution(T.r));
	}
}
