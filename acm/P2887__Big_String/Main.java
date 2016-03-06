package P2887__Big_String;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-17
 * Time: 0:11:12
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String str = stdin.readLine();
        int length = str.length();
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Index_Char> inserts = new ArrayList<Index_Char>();
        for (int i = 0; i < N; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            String command = st.nextToken();
            if (command.equals("I") == true) {
                String temp = st.nextToken();
                int index = Integer.parseInt(st.nextToken()) - 1;
                if (index > length) {
                    index = length;
                }
                inserts.add(new Index_Char(index, temp.charAt(0)));
                length++;
            } else {
                int pos = Integer.parseInt(st.nextToken()) - 1;
                boolean find = false;
                for (int j = inserts.size() - 1; j >= 0; j--) {
                    Index_Char ic = inserts.get(j);
                    if (pos == ic.index) {
                        System.out.println(ic.ch);
                        find = true;
                        break;
                    } else if (ic.index < pos) {
                        pos--;
                    }
                }
                if (find == false) {
                    System.out.println(str.charAt(pos));
                }
            }
        }
    }
}

class Index_Char {
    int index;
    char ch;

    public Index_Char(int theIndex, char theCh) {
        this.index = theIndex;
        this.ch = theCh;
    }
}