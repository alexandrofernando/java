package P1077__Eight;

import java.util.Scanner;
import java.io.File;

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
    static int puzzle[] = new int[9];
    static int pos9;
    static String moves = "";
    static boolean state[];
    static boolean find;
    static char move[] = {
        'u', 'r', 'd', 'l'};
    static int offset[] = {
        -3, 1, 3, -1};
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            if (cin.hasNextInt() == true) {
                puzzle[i] = cin.nextInt();
            }
            else {
                cin.next();
                puzzle[i] = 9;
                pos9 = i;
            }
        }
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (puzzle[i] != 9) {
                for (int j = 0; j < i; j++) {
                    if (puzzle[j] < puzzle[i]) {
                        count++;
                    }
                }
            }
        }
        if (count % 2 == 1) {
            System.out.println("unsolvable");
        }
        else {
            state = new boolean[362880];
            find = false;
            search(0);
        }
    }

    static void search(int depth) {
        if (depth == 200) {
            return;
        }
        int index = indexOf();
        if (state[index] == true) {
            return;
        }
        if (isFind() == true) {
            System.out.println(moves);
            find = true;
        }
        else {
            state[index] = true;
            int copy = pos9;
            for (int i = 0; i < 4; i++) {
                int newPos9 = pos9 + offset[i];
                if ( (pos9 % 3 == 2 && i == 1) || (pos9 % 3 == 0 && i == 3)) {
                    continue;
                }
                if (newPos9 >= 0 && newPos9 < 9 && puzzle[newPos9] == pos9 + 1) {
                    puzzle[pos9] = puzzle[newPos9];
                    puzzle[newPos9] = 9;
                    pos9 = newPos9;
                    moves = moves.concat(move[i] + "");
                    search(depth + 1);
                    moves = moves.substring(0, moves.length() - 1);
                    pos9 = copy;
                    puzzle[newPos9] = puzzle[pos9];
                    puzzle[pos9] = 9;
                    if (find == true) {
                        break;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int newPos9 = pos9 + offset[i];
                if ( (pos9 % 3 == 2 && i == 1) || (pos9 % 3 == 0 && i == 3)) {
                    continue;
                }
                if (newPos9 >= 0 && newPos9 < 9 && puzzle[newPos9] != pos9 + 1 &&
                    puzzle[newPos9] != newPos9 + 1) {
                    puzzle[pos9] = puzzle[newPos9];
                    puzzle[newPos9] = 9;
                    pos9 = newPos9;
                    moves = moves.concat(move[i] + "");
                    search(depth + 1);
                    moves = moves.substring(0, moves.length() - 1);
                    pos9 = copy;
                    puzzle[newPos9] = puzzle[pos9];
                    puzzle[pos9] = 9;
                    if (find == true) {
                        break;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int newPos9 = pos9 + offset[i];
                if ( (pos9 % 3 == 2 && i == 1) || (pos9 % 3 == 0 && i == 3)) {
                    continue;
                }
                if (newPos9 >= 0 && newPos9 < 9 &&
                    puzzle[newPos9] == newPos9 + 1) {
                    puzzle[pos9] = puzzle[newPos9];
                    puzzle[newPos9] = 9;
                    pos9 = newPos9;
                    moves = moves.concat(move[i] + "");
                    search(depth + 1);
                    moves = moves.substring(0, moves.length() - 1);
                    pos9 = copy;
                    puzzle[newPos9] = puzzle[pos9];
                    puzzle[pos9] = 9;
                    if (find == true) {
                        break;
                    }
                }
            }
        }
    }

    static boolean isFind() {
        for (int i = 0; i < 9; i++) {
            if (puzzle[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    static int indexOf() {
        int index = 0;
        int base[] = {
            40320, 5040, 720, 120, 24, 6, 2, 1, 1};
        int count[] = new int[9];
        for (int i = 0; i < 9; i++) {
            count[i] = i;
        }
        for (int i = 0; i < 9; i++) {
            index += count[puzzle[i] - 1] * base[i];
            for (int j = puzzle[i]; j < 9; j++) {
                count[j]--;
            }
        }
        return index;
    }
}
