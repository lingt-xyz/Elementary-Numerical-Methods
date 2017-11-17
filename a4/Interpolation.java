import java.text.DecimalFormat;
import java.util.Random;

public class Interpolation {
	
	private static DecimalFormat df3 = new DecimalFormat(".###");

	public static void main(String[] args) {
		//update getValue() !!!!

		//sinx();
		
		ex();
	}
	
	private static void sinx(){
		int n = 3;

		// range for sin(x)
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------sin(x)-------------------------------------------------------------");
		System.out.println("-------------------------------------Arbitrary local interpolation points------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		int N = 29;// arbitrary points
		double range_low = 0;
		double range_high = 2 * Math.PI;
		double[] localRange = getEquallySpacedPoints(range_low, range_high, N);
		for (int i = 0; i < localRange.length - 1; i++) {
			range_low = localRange[i];
			range_high = localRange[i + 1];
			System.out.println("N = " + (i + 1) + ", [" + range_low + ", " + range_high + "]:");
			double[] arbitrary = getArbitraryPoints(range_low, range_high, n);
			System.out.println("------>Points are " + java.util.Arrays.toString(arbitrary));
			System.out.println("------>Function is " + lagrangeFunction(arbitrary));
			for (int v = 0; v < arbitrary.length; v++) {
				System.out.println("------>p(" + df3.format(arbitrary[v]) + ")=" + df3.format(lagrangeValue(arbitrary, arbitrary[v])));
			}
		}
		
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------sin(x)-------------------------------------------------------------");
		System.out.println("----------------------------------Equally spaced local interpolation points----------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		N = 10; // equally spaced
		range_low = 0;
		range_high = 2 * Math.PI;
		localRange = getEquallySpacedPoints(range_low, range_high, N);
		for (int i = 0; i < localRange.length - 1; i++) {
			range_low = localRange[i];
			range_high = localRange[i + 1];
			System.out.println("N = " + (i + 1) + ", [" + range_low + ", " + range_high + "]:");
			double[] points = getEquallySpacedPoints(range_low, range_high, n);
			System.out.println("------>Points are " + java.util.Arrays.toString(points));
			System.out.println("------>Function is " + lagrangeFunction(points));
			for (int v = 0; v < points.length; v++) {
				System.out.println("------>p(" + df3.format(points[v]) + ")=" + df3.format(lagrangeValue(points, points[v])));
			}
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------sin(x)-------------------------------------------------------------");
		System.out.println("-------------------------------------Chebyshev local interpolation points------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		N = 9; // Chebyshev
		range_low = 0;
		range_high = 2 * Math.PI;
		localRange = getEquallySpacedPoints(range_low, range_high, N);
		for (int i = 0; i < localRange.length - 1; i++) {
			range_low = localRange[i];
			range_high = localRange[i + 1];
			System.out.println("N = " + (i + 1) + ", [" + range_low + ", " + range_high + "]:");
			double[] points = chebyshevPoints(range_low, range_high, n);
			System.out.println("------>Points are " + java.util.Arrays.toString(points));
			System.out.println("------>Function is " + chebyshevFunction(points));
			for (int v = 0; v < points.length; v++) {
				System.out.println("------>p(" + df3.format(points[v]) + ")=" + df3.format(lagrangeValue(points, points[v])));
			}
		}
		
	}
	
	private static void ex(){
		int n = 3;
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------e^x----------------------------------------------------------------");
		System.out.println("----------------------------------Equally spaced local interpolation points----------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		int N = 13;// arbitrary points
		double range_low = 0;
		double range_high = 1;
		double[] localRange = getEquallySpacedPoints(range_low, range_high, N);
		for (int i = 0; i < localRange.length - 1; i++) {
			range_low = localRange[i];
			range_high = localRange[i + 1];
			System.out.println("N = " + (i + 1) + ", [" + range_low + ", " + range_high + "]:");
			double[] points = getEquallySpacedPoints(range_low, range_high, n);
			System.out.println("------>Points are " + java.util.Arrays.toString(points));
			System.out.println("------>Function is " + lagrangeFunction(points));
			for (int v = 0; v < points.length; v++) {
				System.out.println("------>p(" + df3.format(points[v]) + ")=" + df3.format(lagrangeValue(points, points[v])));
			}
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------e^x----------------------------------------------------------------");
		System.out.println("-------------------------------------Chebyshev local interpolation points------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		N = 11; // Chebyshev
		range_low = 0;
		range_high = 1;
		localRange = getEquallySpacedPoints(range_low, range_high, N);
		for (int i = 0; i < localRange.length - 1; i++) {
			range_low = localRange[i];
			range_high = localRange[i + 1];
			System.out.println("N = " + (i + 1) + ", [" + range_low + ", " + range_high + "]:");
			double[] points = chebyshevPoints(range_low, range_high, n);
			System.out.println("------>Points are " + java.util.Arrays.toString(points));
			System.out.println("------>Function is " + chebyshevFunction(points));
			for (int v = 0; v < points.length; v++) {
				System.out.println("------>p(" + df3.format(points[v]) + ")=" + df3.format(lagrangeValue(points, points[v])));
			}
		}
	}

	private static double getValue(double x) {
		// TODO set function f(x)
		return Math.exp(x);
		// return Math.sin(x);
	}

	private static double[] getArbitraryPoints(double range_low, double range_high, int n) {
		double[] points = new double[n + 1];
		Random r = new Random();
		for (int i = 0; i < points.length; i++) {
			double range = range_high - range_low;
			double h = range_low + range * r.nextDouble();
			points[i] = h;
			range_low = h;
		}
		return points;
	}

	private static double[] getEquallySpacedPoints(double range_low, double range_high, int n) {
		double[] points = new double[n + 1];
		double range = range_high - range_low;
		double h = range / n;
		for (int i = 0; i < points.length; i++) {
			points[i] = range_low + i * h;
		}
		return points;
	}

	private static String lagrangeFunction(double[] points) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < points.length; i++) {
			double fi = getValue(points[i]);
			double coefficient = 1;
			StringBuilder sb_term = new StringBuilder();
			for (int j = 0; j < points.length; j++) {
				if (j != i) {
					coefficient *= (points[i] - points[j]);
					sb_term.append("(x-").append(df3.format(points[j])).append(")");
				}
			}
			sb.append("(").append(df3.format(fi / coefficient)).append(sb_term).append(")");
			if (i != points.length - 1) {
				sb.append("+");
			}
		}
		return sb.toString();
	}

	private static double lagrangeValue(double[] points, double point) {
		double result = 0;
		for (int i = 0; i < points.length; i++) {
			double fi = getValue(points[i]);
			double down = 1;
			double up = 1;
			for (int j = 0; j < points.length; j++) {
				if (j != i) {
					down *= (points[i] - points[j]);
					up *= (point - points[j]);
				}
			}
			result += fi * (up / down);

		}
		return result;
	}

	private static double[] chebyshevPoints(double range_low, double range_high, int n) {
		double[] points = new double[n];
		for (int k = 1; k <= n; k++) {
			points[k - 1] = 0.5 * (range_low + range_high)
					+ 0.5 * (range_high - range_low) * Math.cos(((double) (2 * k - 1) / (2 * n)) * Math.PI);
		}
		return points;
	}

	private static String chebyshevFunction(double[] zeros) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < zeros.length; i++) {
			sb.append("(x-(").append(df3.format(zeros[i])).append("))");
		}
		return sb.toString();
	}
	
	private static double chebyshevFunction(double[] zeros, double value) {
		double result = 1;
		for (int i = 0; i < zeros.length; i++) {
			result*=(value-zeros[i]);
		}
		return result;
	}
}
