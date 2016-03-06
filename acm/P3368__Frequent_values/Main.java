package P3368__Frequent_values;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = in.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			int Q = Integer.parseInt(st.nextToken());
			int a[] = new int[N];
			int startPos = 0;
			Hashtable<Integer, Range> ranges = new Hashtable<Integer, Range>();
			ArrayList<Integer> frequencies = new ArrayList<Integer>();
			line = in.readLine();
			st = new StringTokenizer(line);
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				if (i == 0 || a[i] != a[i - 1]) {
					if (i != 0) {
						ranges.put(a[i - 1], new Range(startPos, i - 1,
								frequencies.size()));
						frequencies.add(i - startPos);
					}
					startPos = i;
				}
			}
			ranges.put(a[N - 1], new Range(startPos, N - 1, frequencies.size()));
			frequencies.add(N - startPos);
			int maxSpan = (int) Math.floor(Math.log(frequencies.size())
					/ Math.log(2));
			int max[][] = new int[maxSpan + 1][];
			for (int i = 0, span = 1; i < max.length; i++, span *= 2) {
				max[i] = new int[frequencies.size() - span + 1];
				for (int j = 0; j < max[i].length; j++) {
					if (i == 0) {
						max[i][j] = frequencies.get(j);
					} else {
						max[i][j] = Math.max(max[i - 1][j], max[i - 1][j
								+ (int) Math.pow(2, i - 1)]);
					}
				}
			}
			StringBuffer output = new StringBuffer();
			for (int i = 0; i < Q; i++) {
				line = in.readLine();
				st = new StringTokenizer(line);
				int queryBegin = Integer.parseInt(st.nextToken()) - 1;
				int queryEnd = Integer.parseInt(st.nextToken()) - 1;
				if (a[queryBegin] == a[queryEnd]) {
					output.append("" + (queryEnd - queryBegin + 1) + "\n");
					continue;
				}
				Range rangeBegin = ranges.get(a[queryBegin]);
				Range rangeEnd = ranges.get(a[queryEnd]);
				if (a[rangeBegin.end + 1] == a[queryEnd]) {
					output.append(""
							+ Math.max(rangeBegin.end - queryBegin + 1,
									queryEnd - rangeBegin.end) + "\n");
					continue;
				}
				Range rangeBeginAfter = ranges.get(a[rangeBegin.end + 1]);
				Range rangeEndBefore = ranges.get(a[rangeEnd.begin - 1]);
				int indexA = rangeBeginAfter.freqIndex;
				int indexB = rangeEndBefore.freqIndex;
				int exponent = (int) Math.floor(Math.log(indexB - indexA + 1)
						/ Math.log(2));
				output.append(""
						+ Math.max(Math.max(
								max[exponent][indexA],
								max[exponent][indexB
										- (int) Math.pow(2, exponent) + 1]),
								Math.max(rangeBeginAfter.begin - queryBegin,
										queryEnd - rangeEndBefore.end)) + "\n");
			}
			System.out.print(output);
		}
	}
}

class Range {
	int begin;
	int end;
	int freqIndex;

	Range(int theBegin, int theEnd, int theFreqIndex) {
		this.begin = theBegin;
		this.end = theEnd;
		this.freqIndex = theFreqIndex;
	}
}