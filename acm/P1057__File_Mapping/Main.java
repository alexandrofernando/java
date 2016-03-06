package P1057__File_Mapping;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        String temp;
        while ( (temp = cin.next()).equals("#") == false) {
            Directory p = new Directory("ROOT", null);
            while (temp.equals("*") == false) {
                if (temp.charAt(0) == 'f') {
                    p.file.offer(temp);
                }
                else if (temp.charAt(0) == 'd') {
                    Directory s = new Directory(temp, p);
                    p.subDirectory.add(s);
                    p = s;
                }
                else if (temp.equals("]") == true) {
                    p = p.father;
                }
                temp = cin.next();
            }
            if (test != 1) {
                System.out.println();
            }
            System.out.println("DATA SET " + test + ":");
            p.display();
            test++;
        }
    }
}

class Directory {
    String name;
    PriorityQueue file;
    LinkedList subDirectory;
    Directory father;
    int depth;
    public Directory(String theName, Directory theFather) {
        this.name = theName;
        file = new PriorityQueue<String> ();
        subDirectory = new LinkedList<Directory> ();
        this.father = theFather;
        if (theFather == null) {
            this.depth = 0;
        }
        else {
            this.depth = theFather.depth + 1;
        }
    }

    public void display() {
        for (int i = 0; i < this.depth; i++) {
            System.out.printf("%-6s", "|");
        }
        System.out.println(this.name);
        while (this.subDirectory.isEmpty() == false) {
            ( (Directory)this.subDirectory.removeFirst()).display();
        }
        while (this.file.peek() != null) {
            for (int i = 0; i < this.depth; i++) {
                System.out.printf("%-6s", "|");
            }
            System.out.println(this.file.poll());
        }
    }
}
