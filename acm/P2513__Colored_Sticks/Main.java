package P2513__Colored_Sticks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Hashtable;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-5
 * Time: 1:58:52
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Hashtable<String, Color> table;

    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        table = new Hashtable<String, Color>();
        while (true) {
            String line = stdin.readLine();
            if (line == null) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            String name1 = st.nextToken();
            if (table.containsKey(name1) == false) {
                table.put(name1, new Color(name1));
            }
            String name2 = st.nextToken();
            if (table.containsKey(name2) == false) {
                table.put(name2, new Color(name2));
            }
            String root1 = searchRoot(name1);
            String root2 = searchRoot(name2);
            if (root1.compareTo(root2) != 0) {
                table.get(root2).parent = root1;
            }
            table.get(name1).count++;
            table.get(name2).count++;
        }
        boolean possible = true;
        String root = null;
        int odd = 0;
        Enumeration<Color> enumeration = table.elements();
        while (enumeration.hasMoreElements() == true) {
            Color color = enumeration.nextElement();
            if (color.count % 2 == 1) {
                odd++;
                if (odd > 2) {
                    possible = false;
                    break;
                }
            }
            if (root == null) {
                root = searchRoot(color.name);
            } else if (searchRoot(color.name).compareTo(root) != 0) {
                possible = false;
                break;
            }
        }
        if (possible == true) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }

    static String searchRoot(String node) {
        String root = node;
        while (true) {
            String temp = table.get(root).parent;
            if (temp.compareTo(root) == 0) {
                break;
            }
            root = temp;
        }
        while (node.compareTo(root) != 0) {
            String temp = table.get(node).parent;
            table.get(node).parent = root;
            node = temp;
        }
        return root;
    }
}

class Color {
    String name;
    String parent;
    int count;

    public Color(String theName) {
        this.name = theName;
        this.parent = theName;
        this.count = 0;
    }
}