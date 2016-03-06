package P1109__Index_Generation;

import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Comparator;

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
        cin.useDelimiter("\\*\\*");
        String all = cin.next();
        cin = new Scanner(" " + all);
        cin.useDelimiter("\\*\r\n");
        int test = 1;
        while (cin.hasNext() == true) {
            TreeMap<String, Primary>
                indies = new TreeMap<String, Primary> (new MyComparator());
            String document = cin.next();
            Scanner cin1 = new Scanner(" " + document);
            cin1.useDelimiter("&");
            int pageNumber = 1;
            while (cin1.hasNext() == true) {
                String page = cin1.next();
                Scanner cin2 = new Scanner(page);
                do {
                    String entry = cin2.findWithinHorizon("\\{[^\\{\\}]*\\}", 0);
                    if (entry == null) {
                        break;
                    }
                    entry = entry.replaceAll("\r\n", " ");
                    entry = entry.substring(1, entry.length() - 1);
                    int pos0 = entry.indexOf('%');
                    int pos1 = entry.indexOf('$');
                    String priName;
                    if (pos0 == -1 && pos1 == -1) {
                        priName = entry.trim();
                    }
                    else if (pos0 == -1 && pos1 != -1) {
                        priName = entry.substring(0, pos1).trim();
                    }
                    else if (pos0 != -1 && pos1 == -1) {
                        priName = entry.substring(pos0 + 1).trim();
                    }
                    else {
                        priName = entry.substring(pos0 + 1, pos1).trim();
                    }
                    if (pos1 == -1) {
                        if (indies.containsKey(priName) == true) {
                            indies.get(priName).pageNumbers.add(pageNumber);
                        }
                        else {
                            Primary primary = new Primary();
                            primary.pageNumbers.add(pageNumber);
                            indies.put(priName, primary);
                        }
                    }
                    else {
                        String secName = entry.substring(pos1 + 1).trim();
                        if (indies.containsKey(priName) == true) {
                            TreeMap<String, TreeSet<Integer>>
                                sec = indies.get(priName).secondarys;
                            if (sec.containsKey(secName) == true) {
                                sec.get(secName).add(pageNumber);
                            }
                            else {
                                TreeSet<Integer> set = new TreeSet<Integer> ();
                                set.add(pageNumber);
                                sec.put(secName, set);
                            }
                        }
                        else {
                            TreeSet<Integer> set = new TreeSet<Integer> ();
                            set.add(pageNumber);
                            Primary primary = new Primary();
                            primary.secondarys.put(secName, set);
                            indies.put(priName, primary);
                        }
                    }
                }
                while (true);
                pageNumber++;
            }
            System.out.println("DOCUMENT " + test);
            Iterator<Entry<String, Primary>> iterator = indies.entrySet().
                iterator();
            while (iterator.hasNext() == true) {
                Entry<String, Primary> one = iterator.next();
                System.out.print(one.getKey());
                Iterator<Integer> iterator1 = one.getValue().pageNumbers.
                    iterator();
                while (iterator1.hasNext() == true) {
                    System.out.print(", " + iterator1.next());
                }
                System.out.println();
                Iterator<Entry<String, TreeSet<Integer>>> iterator2 = one.
                    getValue().secondarys.entrySet().iterator();
                while (iterator2.hasNext() == true) {
                    Entry<String, TreeSet<Integer>> sec = iterator2.next();
                    System.out.print("+ " + sec.getKey());
                    Iterator<Integer> iterator3 = sec.getValue().iterator();
                    while (iterator3.hasNext() == true) {
                        System.out.print(", " + iterator3.next());
                    }
                    System.out.println();
                }
            }
            test++;
        }
    }
}

class Primary {
    TreeSet<Integer> pageNumbers;
    TreeMap<String, TreeSet<Integer>> secondarys;
    public Primary() {
        this.pageNumbers = new TreeSet<Integer> ();
        this.secondarys = new TreeMap<String,
                                      TreeSet<Integer>> (new MyComparator());
    }
}

class MyComparator
    implements Comparator<String> {
    public int compare(String a, String b) {
        return a.compareToIgnoreCase(b);
    }
}
