package P3349__Snowflake_Snow_Snowflakes;

import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-11
 * Time: 0:09:58
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin =new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n=Integer.parseInt(st.nextToken());
        HashSet<Snowflake> set=new HashSet<Snowflake>();
        boolean find=false;
        for (int i=0;i<n;i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            int lengths[]=new int[6];
            for (int j=0;j<6;j++) {
                lengths[j]=Integer.parseInt(st.nextToken());
            }
            if (find==false) {
                Snowflake snowflake=new Snowflake(lengths);
                if (set.add(snowflake)==false) {
                    find=true;
                }
            }
        }
        if (find==true) {
            System.out.println("Twin snowflakes found.");
        }
        else {
            System.out.println("No two snowflakes are alike.");
        }
    }
}

class Snowflake {
    int lengths[];

    public Snowflake(int theLengths[]) {
        this.lengths=theLengths;
    }

    public int hashCode() {
        int result=0;
        for (int i=0;i<6;i++) {
            int temp=this.lengths[i]%32767;
            result=(result+temp*temp)%1073741824;
        }
        return result;
    }

    public boolean equals(Object object) {
        Snowflake another=(Snowflake)object;
        for (int i=0;i<6;i++) {
            if (another.lengths[i]==this.lengths[0]) {
                if (isEqual(another.lengths,i,1)==true) {
                    return true;
                }
                if (isEqual(another.lengths,i,-1)==true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEqual(int lengths1[],int start,int offset) {
        int index1=start;
        for (int i=0;i<6;i++) {
            if (lengths[i]!=lengths1[index1]) {
                return false;
            }
            index1=(index1+offset+6)%6;
        }
        return true;
    }
}