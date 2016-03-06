package P1617__Crypto_Columns;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            String keyword = cin.next();
            if (keyword.equals("THEEND") == true) {
                break;
            }
            String ciphertext = cin.next();
            int column = keyword.length();
            int row = ciphertext.length() / column;
            char matrix[][] = new char[row][column];
            Letter_Position lps[] = new Letter_Position[column];
            for (int i = 0; i < column; i++) {
                lps[i] = new Letter_Position(keyword.charAt(i), i);
            }
            Arrays.sort(lps);
            for (int i = 0; i < column; i++) {
                int c = lps[i].position;
                for (int j = 0; j < row; j++) {
                    matrix[j][c] = ciphertext.charAt(i * row + j);
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}


class Letter_Position implements Comparable<Letter_Position> {
    char letter;
    int position;
    public Letter_Position(char theLetter, int thePosition) {
        this.letter = theLetter;
        this.position = thePosition;
    }

    public int compareTo(Letter_Position another) {
        return this.letter - another.letter;
    }
}
