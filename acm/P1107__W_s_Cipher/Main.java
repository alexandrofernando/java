package P1107__W_s_Cipher;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            int k[] = new int[3];
            for (int i = 0; i < 3; i++) {
                k[i] = cin.nextInt();
            }
            if (k[0] == 0 && k[1] == 0 && k[2] == 0) {
                break;
            }
            String encrypted = cin.next();
            Group groups[] = new Group[3];
            for (int i = 0; i < 3; i++) {
                groups[i] = new Group();
            }
            for (int i = 0; i < encrypted.length(); i++) {
                char ch = encrypted.charAt(i);
                if (ch >= 'a' && ch <= 'i') {
                    groups[0].positions.add(i);
                    groups[0].letters.add(ch);
                }
                else if (ch >= 'j' && ch <= 'r') {
                    groups[1].positions.add(i);
                    groups[1].letters.add(ch);
                }
                else {
                    groups[2].positions.add(i);
                    groups[2].letters.add(ch);
                }
            }
            for (int i = 0; i < 3; i++) {
                groups[i].rotate(k[i]);
            }
            StringBuffer decrypted = new StringBuffer(encrypted);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < groups[i].positions.size(); j++) {
                    int pos = groups[i].positions.get(j);
                    char letter = groups[i].letters.get(j);
                    decrypted.setCharAt(pos, letter);
                }
            }
            System.out.println(decrypted);
        }
        while (true);
    }
}

class Group {
    ArrayList<Integer> positions;
    ArrayList<Character> letters;
    public Group() {
        this.positions = new ArrayList<Integer> ();
        this.letters = new ArrayList<Character> ();
    }

    void rotate(int offset) {
        int size = letters.size();
        if (size != 0) {
            offset %= size;
            for (int i = 0; i < offset; i++) {
                char ch = letters.remove(size - 1);
                letters.add(0, ch);
            }
        }
    }
}
