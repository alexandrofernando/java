package P3624__Charm_Bracelet;
import java.util.Scanner;

public class Main
{
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        int desirabilities[]=new int[M+1];
        for (int i=0;i<N;i++) {
            int W=in.nextInt();
            int D=in.nextInt();
            int nextDesirabilities[]=new int[M+1];
            System.arraycopy(desirabilities,0,nextDesirabilities,0,desirabilities.length);
            for (int j=0;j+W<=M;j++) {
                nextDesirabilities[j+W]=Math.max(desirabilities[j+W],desirabilities[j]+D);
            }
            desirabilities=nextDesirabilities;
        }
        int max=0;
        for (int i=0;i<desirabilities.length;i++) {
            max=Math.max(max,desirabilities[i]);
        }
        System.out.println(max);
    }
}
