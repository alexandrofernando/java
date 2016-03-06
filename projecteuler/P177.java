
/**
 * Have used different labeling to the diagram
 * 
 * Imagine a quadrilateral, vertices labeled ABCD clockwise
 * Lay it out so DB is horizontal, A at the top, C at the bottom.
 * Call the intersection of the diagonals (DB and AC) X
 *
 * Label interior angles as follows:
 * p = AXD
 * q = XAD
 * r = XAB
 * s = XDC
 * t = XBC
 * 
 * Now we can examine values for parameter angles p, q, r & s (which are
 * sufficient to define the quadrilateral) and for each set derive angle t,
 * to determine if it's an integer angle. If t is an integer angle, all 
 * interior angles are integers.
 * 
 * We can ignore cases where p > 90, because these are all similar to
 * quadrilaterals where p <= 90
 * 
 * Note angles r and s are always < p 
 * (otherwise the sides don't converge with the diagonals)
 * This implies p >= 2
 * 
 * So the range of values for p, q, r, s to consider is:-
 * 2 <= p <= 90
 * 1 <= q <= (179-p)
 * 1 <= r < p
 * 1 <= s < p
 * 
 * A formula for TAN(t) in terms of p, q, r, s can be obtained via the 
 * sine rule and trig identities
 * Because we are only concerned with integer angles (with a certain tolerance)
 * the arctan can be found using a look-up table with upper and lower limits
 * for the tan of each integer angle. Because each successive t we examine is
 * likely to be close to the previous value, we can use the last t approximation
 * as a starting point in the look-up table, gaining much efficiency.
 * 
 * Once we have found a set p, q, r, s, t that constructs an integer quad,
 * we can generate all possible similar quads by rotating and reflecting, then
 * determine if the p', q', r', s' values for each similar quad have already been 
 * considered. This eliminates the need to store shapes in an array!
 * 
 */
public class P177 {

    static double sinTable[];   // sine lookup table
    static double tanTable[][]; // tan upper- and lower- value lookup table
    static double TOLERANCE = 0.000000001;  // tolerance for integer angles
    static int lastArcTan;      // last arctan value

    public static void main(String args[]) {
        lastArcTan = 0;     // init lastArcTan found
        initTrigTables();   // set up lookup tables

        int totalUnique = 0;    // init count

        for (int p = 2; p <= 90; p++) {   // loop through angle p
            for (int q = 1; q < 180 - p; q++) {     // loop through angle q
                for (int r = 1; r < p; r++) {       // loop through angle r
                    for (int s = 1; s < p; s++) {   // loop through angle s
                        int t = calcT(p, q, r, s);  // calculate angle t
                        if (t > Integer.MIN_VALUE) {    // if integer angle found
                            // if first instance of this quadrilateral
                            if (firstInstance(p, q, r, s, t)) {
                                totalUnique++;      // increment count
                            }
                        }
                    }
                }
            }
        }
        System.out.println(totalUnique);
    }

    /**
     * Initialize trig lookup tables
     */
    static void initTrigTables() {
        // build sine table (0-90 degrees)
        sinTable = new double[91];
        for (int n = 0; n <= 90; n++) {
            sinTable[n] = Math.sin(Math.toRadians(n));
        }

        // build tan table (0-89 degrees)
        // gives a min and max acceptable tan for integer angle
        tanTable = new double[90][2];
        for (int n = 0; n < 90; n++) {
            tanTable[n][0] = Math.tan(Math.toRadians(n - TOLERANCE));
            tanTable[n][1] = Math.tan(Math.toRadians(n + TOLERANCE));
        }
    }

    /**
     * Determines if these angles define an integer quadrilateral
     *  and returns the derived integer angle t in degrees, or if
     *  t is not an integer, flags with MIN_VALUE
     * 
     * @param p angle p in degrees
     * @param q angle q in degrees
     * @param r angle r in degrees
     * @param s angle s in degrees
     * @return derived angle t in degrees,
     *         or Integer.MIN_VALUE if angle t is not an integer
     */
    static int calcT(int p, int q, int r, int s) {
        // build denominator
        double denom = quickSine(q + r) * quickSine(p - s);
        denom /= quickSine(q) * quickSine(p - r);
        denom -= quickCos(s);

        // catch tan(T) == infinity (i.e. t == 90 degrees)
        if (denom == 0) {
            return 90;
        }

        double tanT = quickSine(s) / denom; // get tan(t)
        int t = quickArcTan(tanT);          // get integer arctan, or MIN_VALUE

        return t;                           // return angle t or MIN_VALUE
    }

    /**
     * Determines whether this angle configuration (p, q, r, s, t)
     *  is the first instance of its kind 
     *  (i.e. no previous discoveries could be similar)
     * 
     * @param p angle p
     * @param q angle q
     * @param r angle r
     * @param s angle s
     * @param t angle t
     * @return true if first instance of this quadrilateral
     */
    static boolean firstInstance(int p, int q, int r, int s, int t) {
        int rows = (p == 90) ? 7 : 3;   // need more translations if p == 90
        int tr[][] = new int[rows][3];  // array of b, c, d values for translations

        tr[0][0] = 180 - p - t;     // q, r, s values if r180   CDAB
        tr[0][1] = p - s;
        tr[0][2] = p - r;
        tr[1][0] = t;               // q, r, s values flipped   BADC
        tr[1][1] = p - r;
        tr[1][2] = p - s;
        tr[2][0] = 180 - p - q;     // q, r, s values fr180     DCBA
        tr[2][1] = s;
        tr[2][2] = r;

        if (p == 90) {
            tr[3][0] = p - r;       // q, r, s values r90   BCDA  
            tr[3][1] = t;
            tr[3][2] = q;
            tr[4][0] = s;           // q, r, s values r270  DABC
            tr[4][1] = 180 - p - q;
            tr[4][2] = 180 - p - t;
            tr[5][0] = r;           // q, r, s values fr90  ADCB
            tr[5][1] = q;
            tr[5][2] = t;
            tr[6][0] = p - s;       // q, r, s values fr270 CBAD
            tr[6][1] = 180 - p - t;
            tr[6][2] = 180 - p - q;
        }

        for (int n = 0; n < tr.length; n++) {
            if (tr[n][0] < q) {
                return false;
            }
            if (tr[n][0] > q) {
                continue;
            }

            if (tr[n][1] < r) {
                return false;
            }
            if (tr[n][1] > r) {
                continue;
            }

            if (tr[n][2] < s) {
                return false;
            }
            if (tr[n][2] > s) {
                continue;
            }
        }
        return true;
    }

    /**
     * Gets sine of the integer angle in degrees using lookup
     * 
     * @param angleDeg the angle in degrees
     * @return the sine
     */
    static double quickSine(int angleDeg) {
        if (angleDeg < 0) {
            return -quickSine(-angleDeg);
        }
        if (angleDeg > 90) {
            return quickSine(180 - angleDeg);   // handle obtuse angles
        }
        return sinTable[angleDeg];              // return sine
    }

    /**
     * Gets cosine of the integer angle in degrees using lookup
     * @param angleDeg the angle in degrees
     * @return the cosine
     */
    static double quickCos(int angleDeg) {
        if (angleDeg < 0) {
            return quickCos(-angleDeg);
        }
        if (angleDeg > 90) {
            return -quickCos(180 - angleDeg);   // handle obtuse
        }
        return sinTable[90 - angleDeg];         // return cosine
    }

    /**
     * Gets the integer angle in degrees corresponding to the specified tan value
     *  or returns Integer.MIN_VALUE if not an integer angle
     * 
     * @param tanVal the tan value
     * @return the angle in degrees, 
     *         OR Integer.MIN_VALUE if angle non-integer
     */
    static int quickArcTan(double tanVal) {
        // handle negative tanVal
        if (tanVal < 0) {
            int val = quickArcTan(-tanVal);   // get positive value
            if (val == Integer.MIN_VALUE) {
                return val;     // return if MIN_VALUE
            }
            return 180 - val;   // return neg equivalent
        }

        // get first guess (using last approximation found)
        // return if correct
        if (tanTable[lastArcTan][0] < tanVal && tanTable[lastArcTan][1] > tanVal) {
            return lastArcTan;
        }

        // else get search direction
        boolean forwards = tanTable[lastArcTan][1] <= tanVal;

        if (forwards) { // search forwards from first guess
            for (int n = lastArcTan + 1; n < 90; n++) { // loop through lookup
                if (tanTable[n][0] < tanVal && tanTable[n][1] > tanVal) {   // if in range
                    lastArcTan = n; // save angle/index
                    return n;       // return angle
                }
                if (tanTable[n][1] > tanVal) {    // if range exceeded
                    lastArcTan = n; // save angle/index
                    break;          // quit loop
                }
            }
            // no matching integer angle found; flag with MIN_VALUE
            return Integer.MIN_VALUE;
        } else {  // search backwards from first guess
            for (int n = lastArcTan - 1; n >= 0; n--) { // loop through lookup
                if (tanTable[n][0] < tanVal && tanTable[n][1] > tanVal) {   // if in range
                    lastArcTan = n; // save angle/index
                    return n;       // return angle
                }
                if (tanTable[n][0] < tanVal) {    // if range exceeded
                    lastArcTan = n; // save angle/index
                    break;          // quit loop
                }
            }
            // no matching integer angle found; flag with MIN_VALUE
            return Integer.MIN_VALUE;
        }
    }
}
