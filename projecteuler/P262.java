public class P262 {
	/*
	 * http://www.wolframalpha.com/
	 * 
	 * Original chart: Plot[( 5000-0.005*(x*x+y*y+x*y)+12.5*(x+y) ) * exp(
	 * -abs(0.000001*(x*x+y*y)-0.0015*(x+y)+0.7) ), {x, 0, 1600}, {y, 0, 1600}]
	 * 
	 * y = 0 chart: Plot[( 5000-0.005*(x*x)+12.5*(x) ) * exp(
	 * -abs(0.000001*(x*x)-0.0015*(x)+0.7) ), {x, 0, 1600}]
	 * 
	 * f(x) for x in [0, 1600] = -abs(0.000001*(x*x)-0.0015*(x)+0.7) > 0, so
	 * |f(x)| = f(x): Plot[0.000001*(x*x)-0.0015*(x)+0.7, {x, 0, 1600}]
	 * 
	 * Solve the highest point for x in [0, 1600] in y = 0 chart, so x =
	 * 895.483: Solve[D[( 5000-0.005*(x*x)+12.5*(x) ) * exp(
	 * -(0.000001*(x*x)-0.0015*(x)+0.7) ), x] == 0, x]
	 * 
	 * fmin = h(895.483, 0) = 10396.5: h = ( 5000-0.005*(x*x+y*y+x*y)+12.5*(x+y)
	 * ) * exp( -abs(0.000001*(x*x+y*y)-0.0015*(x+y)+0.7) ), x = 895.483, y = 0
	 * 
	 * Intersecting surface for h = fmin: Plot[sign((
	 * 5000-0.005*(x*x+y*y+x*y)+12.5*(x+y) ) * exp(
	 * -abs(0.000001*(x*x+y*y)-0.0015*(x+y)+0.7) ) - 10396.5), {x, 0, 1600}, {y,
	 * 0, 1600}]
	 */

	final static double EPSILON = 1e-5;

	public static void main(String args[]) {
		final double XA = 200;
		final double YA = 200;
		final double XB = 1400;
		final double YB = 1400;
		final double X0 = 895.483;
		final double Y0 = 0;
		double fmin = h(X0, Y0);
		double step = 1;
		double length = -1;
		while (true) {
			double lengthA = calcTangentLineLength(X0, Y0, XA, YA, step,
					Math.PI, 0, -Math.PI / 2, fmin);
			double lengthB = calcTangentLineLength(X0, Y0, XB, YB, step, 0, 0,
					Math.PI / 2, fmin);
			double curLength = lengthA + lengthB;
			if (Math.abs(curLength - length) < EPSILON) {
				break;
			}
			length = curLength;
			step /= 2;
		}
		System.out.printf("%.3f\n", length);
	}

	static double calcTangentLineLength(double x0, double y0, double xTarget,
			double yTarget, double step, double angle,
			double rotateAngleRange1, double rotateAngleRange2, double fmin) {
		double length = 0;
		double x = x0;
		double y = y0;
		double prevError = Double.MAX_VALUE;
		while (true) {
			double leftRotateAngle = rotateAngleRange1;
			double rightRotateAngle = rotateAngleRange2;
			while (Math.abs(rightRotateAngle - leftRotateAngle) > EPSILON) {
				double middleRotateAngle = (leftRotateAngle + rightRotateAngle) / 2;
				double dx = step * Math.cos(angle + middleRotateAngle);
				double dy = step * Math.sin(angle + middleRotateAngle);
				if (h(x + dx, y + dy) > fmin) {
					rightRotateAngle = middleRotateAngle;
				} else {
					leftRotateAngle = middleRotateAngle;
				}
			}
			double rotateAngle = (leftRotateAngle + rightRotateAngle) / 2;
			angle += rotateAngle;
			double dx = step * Math.cos(angle);
			double dy = step * Math.sin(angle);
			double error = Math.abs(dy * (xTarget - x) - dx * (yTarget - y));
			if (error > prevError) {
				length += distance(x, y, xTarget, yTarget);
				break;
			}
			prevError = error;
			length += step;
			x += dx;
			y += dy;
		}
		return length;
	}

	static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	static double h(double x, double y) {
		return (5000 - 0.005 * (x * x + y * y + x * y) + 12.5 * (x + y))
				* Math.exp(-Math.abs(0.000001 * (x * x + y * y) - 0.0015
						* (x + y) + 0.7));
	}
}
