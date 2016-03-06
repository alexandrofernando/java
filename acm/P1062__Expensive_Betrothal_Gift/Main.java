package P1062__Expensive_Betrothal_Gift;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
    static int M;
    static int minTotal;
    static Goods goods[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        M = cin.nextInt();
        int N = cin.nextInt();
        goods = new Goods[N + 1];
        for (int i = 1; i <= N; i++) {
            goods[i] = new Goods(cin.nextInt(), cin.nextInt());
            int X = cin.nextInt();
            for (int j = 0; j < X; j++) {
                goods[i].replaces.add(new Element(cin.nextInt(), cin.nextInt()));
            }
        }
        minTotal = goods[1].price;
        search(1, goods[1].level, goods[1].level, 0);
        System.out.println(minTotal);
    }

    static void search(int vertex, int minLevel, int maxLevel, int money) {
        int curLevel = goods[vertex].level;
        int newMin = minLevel;
        if (curLevel < minLevel) {
            if (maxLevel - curLevel > M) {
                return;
            }
            else {
                newMin = curLevel;
            }
        }
        int newMax = maxLevel;
        if (curLevel > maxLevel) {
            if (curLevel - minLevel > M) {
                return;
            }
            else {
                newMax = curLevel;
            }
        }
        if (money + goods[vertex].price < minTotal) {
            minTotal = money + goods[vertex].price;
        }
        for (int i = 0; i < goods[vertex].replaces.size(); i++) {
            Element element = goods[vertex].replaces.get(i);
            if (money + element.V < minTotal) {
                search(element.T, newMin, newMax, money + element.V);
            }
        }
    }
}

class Goods {
    int price;
    int level;
    ArrayList<Element> replaces;
    public Goods(int thePrice, int theLevel) {
        this.price = thePrice;
        this.level = theLevel;
        this.replaces = new ArrayList<Element> ();
    }
}

class Element {
    int T;
    int V;
    public Element(int theT, int theV) {
        this.T = theT;
        this.V = theV;
    }
}
