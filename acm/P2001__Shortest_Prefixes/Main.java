package P2001__Shortest_Prefixes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-5
 * Time: 7:18:39
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        ArrayList<Word> words = new ArrayList<Word>();
        int number = 0;
        while (in.hasNext() == true) {
            words.add(new Word(number, in.next()));
            number++;
        }
        Collections.sort(words, new MyComparator1());
        for (int i = 0; i < words.size(); i++) {
            if (i > 0) {
                searchPrefix(words.get(i), words.get(i - 1));
            }
            if (i < words.size() - 1) {
                searchPrefix(words.get(i), words.get(i + 1));
            }
        }
        Collections.sort(words, new MyComparator2());
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i).str + " " + words.get(i).prefix);
        }
    }

    static void searchPrefix(Word word, Word refer) {
        int pos = 0;
        while (pos < word.str.length() && pos < refer.str.length()) {
            if (word.str.charAt(pos) != refer.str.charAt(pos)) {
                break;
            }
            pos++;
        }
        if (pos < word.str.length()) {
            pos++;
        }
        if (pos > word.prefix.length()) {
            word.prefix = word.str.substring(0, pos);
        }
    }

    static class MyComparator1 implements Comparator<Word> {
        public int compare(Word word0, Word word1) {
            return word0.str.compareTo(word1.str);
        }
    }

    static class MyComparator2 implements Comparator<Word> {
        public int compare(Word word0, Word word1) {
            return word0.index - word1.index;
        }
    }
}

class Word {
    int index;
    String str;
    String prefix;

    public Word(int theIndex, String theStr) {
        this.index = theIndex;
        this.str = theStr;
        this.prefix = "";
    }
}