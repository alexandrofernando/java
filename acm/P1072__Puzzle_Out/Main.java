package P1072__Puzzle_Out;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    static Node dict[];
    static int nodeNumber;
    static ArrayList<Word> words;
    static int state;
    static char resultTable[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        dict = new Node[350000];
        dict[0] = new Node('+');
        nodeNumber = 1;
        int D = cin.nextInt();
        for (int i = 0; i < D; i++) {
            build(dict[0], cin.next());
        }
        int test = cin.nextInt();
        cin.nextLine();
        cin.nextLine();
        for (int t = 1; t <= test; t++) {
            words = new ArrayList<Word> ();
            do {
                if (cin.hasNext() == false) {
                    break;
                }
                String line = cin.nextLine();
                if (line.equals("") == true) {
                    break;
                }
                Scanner cin1 = new Scanner(line);
                while (cin1.hasNext() == true) {
                    String temp = cin1.next();
                    if (words.contains(temp) == false) {
                        words.add(new Word(temp));
                    }
                }
            }
            while (true);
            Collections.sort(words);
            order();
            char table[] = new char[26];
            for (int i = 0; i < 26; i++) {
                table[i] = '*';
            }
            state = 0;
            search( -1, table, new boolean[26], dict[0], "");
            if (state == 0) {
                System.out.println("#No solution#");
            }
            else if (state == 1) {
                for (int i = 0; i < 26; i++) {
                    System.out.print(resultTable[i]);
                }
                System.out.println();
            }
            else if (state == 2) {
                System.out.println("#More than one solution#");
            }
        }
    }

    static void search(int depth, char table[], boolean used[], Node node,
                       String str) {
        if (depth == words.size()) {
            if (state == 0) {
                resultTable = new char[26];
                for (int i = 0; i < 26; i++) {
                    resultTable[i] = '*';
                }
                for (int i = 0; i < 26; i++) {
                    if (table[i] != '*') {
                        resultTable[table[i] - 'A'] = (char) ('A' + i);
                    }
                }
                state = 1;
            }
            else if (state == 1) {
                state = 2;
            }
        }
        else {
            if (str.equals("") == true) {
                if (node.ch != '+') {
                    return;
                }
                String temp;
                if (depth + 1 == words.size()) {
                    temp = "";
                }
                else {
                    temp = words.get(depth + 1).word;
                }
                search(depth + 1, table, used, dict[0], temp);
                if (state == 2) {
                    return;
                }
            }
            else {
                char ch = str.charAt(0);
                char ch1 = table[ch - 'A'];
                if (ch1 != '*') {
                    while (node != null && node.ch != ch1) {
                        node = node.sibling;
                    }
                    if (node == null) {
                        return;
                    }
                    else {
                        search(depth, table, used, node.child, str.substring(1));
                        if (state == 2) {
                            return;
                        }
                    }
                }
                else {
                    while (node != null) {
                        char ch2 = node.ch;
                        if (ch2 != '+' && used[ch2 - 'A'] == false) {
                            table[ch - 'A'] = ch2;
                            used[ch2 - 'A'] = true;
                            search(depth, table, used, node.child,
                                   str.substring(1));
                            if (state == 2) {
                                return;
                            }
                            used[ch2 - 'A'] = false;
                            table[ch - 'A'] = '*';
                        }
                        node = node.sibling;
                    }
                }
            }
        }
    }

    static void order() {
        ArrayList<Word> temp = new ArrayList<Word> ();
        boolean determine[] = new boolean[26];
        while (words.isEmpty() == false) {
            int maxCount = -1;
            int pos = 0;
            for (int i = 0; i < words.size(); i++) {
                int count = 0;
                String one = words.get(i).word;
                for (int j = 0; j < one.length(); j++) {
                    if (determine[one.charAt(j) - 'A'] == true) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    pos = i;
                }
            }
            Word w = words.remove(pos);
            temp.add(w);
            for (int i = 0; i < w.word.length(); i++) {
                determine[w.word.charAt(i) - 'A'] = true;
            }
        }
        words = temp;
    }

    static Node build(Node node, String str) {
        if (str.equals("") == true) {
            if (node == null) {
                dict[nodeNumber] = new Node('+');
                node = dict[nodeNumber];
                nodeNumber++;
            }
            else {
                dict[nodeNumber] = new Node('+');
                dict[nodeNumber].sibling = node.sibling;
                node.sibling = dict[nodeNumber];
                node = dict[nodeNumber];
                nodeNumber++;
            }
        }
        else {
            char ch = str.charAt(0);
            Node p = node;
            Node q = null;
            while (p != null && p.ch < ch) {
                q = p;
                p = p.sibling;
            }
            if (p == null || p.ch > ch) {
                dict[nodeNumber] = new Node(ch);
                Node copy = dict[nodeNumber];
                nodeNumber++;
                copy.child = build(dict[nodeNumber], str.substring(1));
                if (q == null) {
                    node = copy;
                }
                else {
                    copy.sibling = q.sibling;
                    q.sibling = copy;
                }
            }
            else {
                p.ch = ch;
                build(p.child, str.substring(1));
            }
        }
        return node;
    }
}

class Node {
    char ch;
    Node sibling;
    Node child;
    public Node(char theChar) {
        this.ch = theChar;
    }
}

class Word
    implements Comparable<Word> {
    String word;
    int kind;
    int length;
    public Word(String str) {
        this.word = str;
        this.length = str.length();
        boolean used[] = new boolean[26];
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (used[ch - 'A'] == false) {
                this.kind++;
                used[ch - 'A'] = true;
            }
        }
    }

    public boolean equals(Object another) {
        Word a = (Word) another;
        return this.word.equals(a.word);
    }

    public int compareTo(Word another) {
        if (this.kind != another.kind) {
            return this.kind - another.kind;
        }
        else {
           return another.length - this.length;
        }
    }
}
