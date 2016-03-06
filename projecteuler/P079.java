import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class P079 {
	public static void main(String args[]) {
		String input[] = new String[] { "319", "680", "180", "690", "129",
				"620", "762", "689", "762", "318", "368", "710", "720", "710",
				"629", "168", "160", "689", "716", "731", "736", "729", "316",
				"729", "729", "710", "769", "290", "719", "680", "318", "389",
				"162", "289", "162", "718", "729", "319", "790", "680", "890",
				"362", "319", "760", "316", "729", "380", "319", "728", "716" };
		LinkedList<Key> queue = new LinkedList<Key>();
		queue.offer(new Key(new HashSet<String>(Arrays.asList(input)), ""));
		boolean found = false;
		while (!queue.isEmpty()) {
			Key head = queue.poll();
			boolean determined = false;
			for (int i = 0; i < 10; i++) {
				boolean hasFirst = false;
				boolean valid = true;
				Iterator<String> iter = head.keyLogs.iterator();
				while (iter.hasNext()) {
					String keyLog = iter.next();
					if (keyLog.equals("")) {
						continue;
					}
					if (keyLog.charAt(0) - '0' == i) {
						hasFirst = true;
					} else if (keyLog.indexOf(i + '0') >= 1) {
						valid = false;
						break;
					}
				}
				if (hasFirst && valid) {
					found = insertNext((char) (i + '0'), head, queue);
					if (found) {
						break;
					}
					determined = true;
					break;
				}
			}
			if (found) {
				break;
			}
			if (determined) {
				continue;
			}
			boolean used[] = new boolean[10];
			Iterator<String> iter = head.keyLogs.iterator();
			while (iter.hasNext()) {
				String keyLog = iter.next();
				if (!keyLog.equals("") && !used[keyLog.charAt(0) - '0']) {
					char ch = keyLog.charAt(0);
					used[ch - '0'] = true;
					found = insertNext(ch, head, queue);
					if (found) {
						break;
					}
				}
			}
			if (found) {
				break;
			}
		}
	}

	static boolean insertNext(char ch, Key head, LinkedList<Key> queue) {
		HashSet<String> nextKeyLogs = new HashSet<String>();
		boolean complete = true;
		Iterator<String> iter1 = head.keyLogs.iterator();
		while (iter1.hasNext()) {
			String kl = iter1.next();
			String temp;
			if (kl.equals("") || kl.charAt(0) != ch) {
				temp = kl;
			} else {
				temp = kl.substring(1);
			}
			nextKeyLogs.add(temp);
			if (!temp.equals("")) {
				complete = false;
			}
		}
		if (complete) {
			System.out.println(head.passcode + ch);
			return true;
		}
		queue.offer(new Key(nextKeyLogs, head.passcode + ch));
		return false;
	}
}

class Key implements Comparable<Key> {
	HashSet<String> keyLogs;
	String passcode;

	Key(HashSet<String> theKeyLogs, String thePasscode) {
		this.keyLogs = theKeyLogs;
		this.passcode = thePasscode;
	}

	public int compareTo(Key another) {
		return this.passcode.length() - another.passcode.length();
	}
}
