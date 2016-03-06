
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P184 {

    static HashMap<Angle, Integer> counts = new HashMap<Angle, Integer>();
    static HashMap<Angle, Angle> pres = new HashMap<Angle, Angle>();

    public static void main(String args[]) {
        final int R = 105;
        ArrayList<Angle> angles = new ArrayList<Angle>();
        long count = 0;
        for (int x = -R + 1; x <= R - 1; x++) {
            int farthest = (int) Math.floor(Math.sqrt(R * R - x * x));
            if (x * x + farthest * farthest == R * R) {
                farthest--;
            }
            for (int y = -farthest; y <= farthest; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }
                angles.add(new Angle(x, y));
            }
        }
        Collections.sort(angles);

        buildCountsAndPres(angles);

        for (int i = 0; i < angles.size(); i++) {
            Angle angle1 = angles.get(i);
            for (int j = i + 1; j < angles.size(); j++) {
                Angle angle2 = angles.get(j);
                Angle angleFrom = new Angle(angle1.x, angle1.y);
                Angle angleTo = new Angle(angle2.x, angle2.y);
                while (angleFrom.calcQuadrant() != 1) {
                    angleFrom = angleFrom.turn90Clockwise();
                    angleTo = angleTo.turn90Clockwise();
                }
                Angle angleFromReverse = angleFrom.reverse();
                int cmp = angleTo.compareTo(angleFromReverse);
                if (cmp == 0) {
                    continue;
                } else if (cmp < 0) {
                    count += calcCount(angleFrom, angleTo);
                } else {
                    while (angleTo.calcQuadrant() != 1) {
                        angleFrom = angleFrom.turn90Clockwise();
                        angleTo = angleTo.turn90Clockwise();
                    }
                    count += calcCount(angleTo, angleFrom);
                }
            }
        }
        System.out.println(count / 3);
    }

    static void buildCountsAndPres(ArrayList<Angle> angles) {
        Angle previous = angles.get(0);
        pres.put(previous, null);
        for (int i = 1; i < angles.size(); i++) {
            Angle current = angles.get(i);
            if (!current.equals(previous)) {
                counts.put(previous, i);
                pres.put(current, previous);
            }
            previous = current;
        }
        counts.put(previous, angles.size());
    }

    static int calcCount(Angle from, Angle to) {
        Angle toPre = pres.get(to);
        int toPreCount;
        if (toPre == null) {
            toPreCount = 0;
        } else {
            toPreCount = counts.get(toPre);
        }
        int fromCount = counts.get(from);
        return Math.max(0, toPreCount - fromCount);
    }
}

class Angle implements Comparable<Angle> {

    int x;
    int y;

    Angle(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    @Override
    public boolean equals(Object obj) {
        Angle another = (Angle) obj;
        return this.x * another.y == this.y * another.x
                && this.x * another.x >= 0 && this.y * another.y >= 0;
    }

    @Override
    public int hashCode() {
        if (x == 0) {
            return 0;
        } else {
            return y * 1000 / x;
        }
    }

    @Override
    public int compareTo(Angle another) {
        int quadrant1 = calcQuadrant();
        int quadrant2 = another.calcQuadrant();
        if (quadrant1 != quadrant2) {
            return quadrant1 - quadrant2;
        }
        Angle a1 = this.convertToQuadrantI();
        Angle a2 = another.convertToQuadrantI();
        return a2.x * a1.y - a1.x * a2.y;
    }

    int calcQuadrant() {
        if (x > 0 && y >= 0) {
            return 1;
        } else if (y > 0 && x <= 0) {
            return 2;
        } else if (x < 0 && y <= 0) {
            return 3;
        } else {
            return 4;
        }
    }

    private Angle convertToQuadrantI() {
        Angle result = new Angle(x, y);
        while (result.calcQuadrant() != 1) {
            result = result.turn90Clockwise();
        }
        return result;
    }

    Angle turn90Clockwise() {
        return new Angle(y, -x);
    }

    Angle reverse() {
        return new Angle(-x, -y);
    }
}