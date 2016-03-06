import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P280 {
	static ArrayList<Integer> index2config = new ArrayList<Integer>();
	static HashMap<Integer, Integer> config2index = new HashMap<Integer, Integer>();

	public static void main(String args[]) {
		final double ERROR = 1E-12;

		buildConfigs(0, new int[5], false);
		buildConfigs(0, new int[5], true);

		ArrayList<TransProb> transProbs = new ArrayList<TransProb>();
		for (int from = 0; from < index2config.size(); from++) {
			Config current = Config.decode(index2config.get(from));
			ArrayList<Config> adjacents = current.getAdjacentConfigs();
			for (Config adjacent : adjacents) {
				int to = config2index.get(adjacent.encode());
				transProbs.add(new TransProb(from, to, 1.0 / adjacents.size()));
			}
		}

		double p[] = new double[index2config.size()];
		Config startConfig = new Config(new int[] { 0, 1, 2, 3, 4 }, 12);
		p[config2index.get(startConfig.encode())] = 1;
		int endConfigIndices[] = new int[5];
		for (int i = 0; i < endConfigIndices.length; i++) {
			endConfigIndices[i] = config2index.get(new Config(new int[] { 20,
					21, 22, 23, 24 }, i + 20).encode());
		}
		double expectedStep = 0;
		for (int step = 1;; step++) {
			p = multiply(p, transProbs);
			double nextExpectedStep = expectedStep;
			for (int endConfigIndex : endConfigIndices) {
				nextExpectedStep += step * p[endConfigIndex];
			}
			if (nextExpectedStep > 1
					&& Math.abs(nextExpectedStep - expectedStep) < ERROR) {
				break;
			}
			expectedStep = nextExpectedStep;
		}
		System.out.printf("%.6f\n", expectedStep);
	}

	static double[] multiply(double a[], ArrayList<TransProb> transProbs) {
		double b[] = new double[a.length];
		for (TransProb transProb : transProbs) {
			b[transProb.to] += a[transProb.from] * transProb.p;
		}
		return b;
	}

	static void buildConfigs(int seedIndex, int seeds[], boolean hasSeedWithAnt) {
		if (seedIndex == 4) {
			for (seeds[4] = seeds[3] + 1; seeds[4] <= 24; seeds[4]++) {
				if (seeds[4] == 5) {
					seeds[4] = 20;
				}
				if (Config.isSeedsInFinal(seeds)) {
					return;
				}
				for (int ant = 0; ant <= 24; ant++) {
					boolean skip = false;
					for (int seed : seeds) {
						if (ant == seed) {
							skip = true;
							break;
						}
					}
					if (skip) {
						continue;
					}
					Config config = new Config(seeds, ant);
					int configCode = config.encode();
					index2config.add(configCode);
					config2index.put(configCode, index2config.size() - 1);
				}
			}
		} else if (seedIndex == 3 && hasSeedWithAnt) {
			for (seeds[3] = seeds[2] + 1; seeds[3] <= 24; seeds[3]++) {
				if (seeds[3] == 5) {
					seeds[3] = 20;
				}
				for (int ant = 0; ant <= 24; ant++) {
					seeds[4] = ant;
					Config config = new Config(seeds, ant);
					int configCode = config.encode();
					index2config.add(configCode);
					config2index.put(configCode, index2config.size() - 1);
				}
			}
		} else {
			for (seeds[seedIndex] = (seedIndex == 0) ? 0
					: (seeds[seedIndex - 1] + 1); seeds[seedIndex] <= 24; seeds[seedIndex]++) {
				if (seeds[seedIndex] == 5) {
					seeds[seedIndex] = 20;
				}
				buildConfigs(seedIndex + 1, seeds, hasSeedWithAnt);
			}
		}
	}
}

class TransProb {
	int from;
	int to;
	double p;

	public TransProb(int from, int to, double p) {
		this.from = from;
		this.to = to;
		this.p = p;
	}
}

class Config {
	int seeds[];
	int ant;

	public Config(int[] seeds, int ant) {
		this.seeds = seeds.clone();
		Arrays.sort(this.seeds);
		this.ant = ant;
	}

	public int encode() {
		int code = ant;
		for (int seed : seeds) {
			code = code * 25 + seed;
		}
		return code;
	}

	public static Config decode(int code) {
		int seeds[] = new int[5];
		int ant;
		for (int i = 0; i < seeds.length; i++) {
			seeds[i] = code % 25;
			code /= 25;
		}
		ant = code;
		return new Config(seeds, ant);
	}

	public ArrayList<Config> getAdjacentConfigs() {
		ArrayList<Config> adjacents = new ArrayList<Config>();
		if (isSeedsInFinal(seeds)) {
			return adjacents;
		}
		int seedWithAnt = -1;
		for (int i = 0; i < seeds.length; i++) {
			if (seeds[i] == ant
					&& (ant <= 19 || (i + 1 < seeds.length && seeds[i] == seeds[i + 1]))) {
				seedWithAnt = i;
				break;
			}
		}
		int offsets[] = { -1, 1, -5, 5 };
		for (int offset : offsets) {
			int nextAnt = ant + offset;
			if (nextAnt < 0 || nextAnt > 24 || (ant % 5 == 0 && offset == -1)
					|| (ant % 5 == 4 && offset == 1)) {
				continue;
			}
			int nextSeeds[] = seeds.clone();
			if (seedWithAnt >= 0) {
				nextSeeds[seedWithAnt] = nextAnt;
			}
			Config nextConfig = new Config(nextSeeds, nextAnt);
			adjacents.add(nextConfig);
		}
		return adjacents;
	}

	public static boolean isSeedsInFinal(int seeds[]) {
		for (int i = 0; i < seeds.length; i++) {
			if (seeds[i] != i + 20) {
				return false;
			}
		}
		return true;
	}
}