package P3157__Java_vs_Cpp;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-31
 * Time: 9:17:30
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    enum Version {
        BOTH, JAVA, CPP, ERROR
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String identifier = in.next();
        Version version = Version.BOTH;
        int length = identifier.length();
        for (int i = 0; i < length; i++) {
            char ch = identifier.charAt(i);
            if (ch == '_') {
                if (version != Version.JAVA && i != 0 && i != length - 1 && identifier.charAt(i - 1) != '_' && identifier.charAt(i + 1) != '_') {
                    version = Version.CPP;
                } else {
                    version = Version.ERROR;
                    break;
                }
            } else if (Character.isUpperCase(ch) == true) {
                if (i == 0 || version == Version.CPP) {
                    version = Version.ERROR;
                    break;
                } else {
                    version = Version.JAVA;
                }
            }
        }
        if (version == Version.ERROR) {
            System.out.println("Error!");
        } else if (version == Version.BOTH) {
            System.out.println(identifier);
        } else if (version == Version.JAVA) {
            StringBuffer str = new StringBuffer(identifier);
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (Character.isUpperCase(ch) == true) {
                    str.setCharAt(i, Character.toLowerCase(ch));
                    str.insert(i, '_');
                    i++;
                }
            }
            System.out.println(str);
        } else {
            StringBuffer str = new StringBuffer(identifier);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '_') {
                    char ch = str.charAt(i + 1);
                    str.setCharAt(i + 1, Character.toUpperCase(ch));
                    str.delete(i, i + 1);
                }
            }
            System.out.println(str);
        }
    }
}
