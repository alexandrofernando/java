package P1740__A_New_Stone_Game;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-20
 * Time: 17:00:26
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        while (true) {
            int n=in.nextInt();
            if (n==0) {
                break;
            }
            int piles[]=new int[n];
            for (int i=0;i<n;i++) {
                piles[i]=in.nextInt();
            }
            Arrays.sort(piles);
            boolean win=true;
            if (n%2==0) {
                win=false;
                for (int i=0;i<n;i+=2) {
                    if (piles[i]!=piles[i+1]) {
                        win=true;
                        break;
                    }
                }
            }
            if (win==true) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}
