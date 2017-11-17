public class Interpolation {

    public static void main(String[] args) {
       /* double[] points = {0,1,2};
        String function = lagrangeFunction(points);
        System.out.println("function = " + function);
        System.out.println("lagrangeValue(points, 1.5) = " + lagrangeValue(points, 1.5));
        double[] chebyshev = chebyshevPoints(-1,1,2);
        System.out.println("chebyshevPoints(-1,1,2) = " + java.util.Arrays.toString(chebyshev));
        System.out.println("chebyshevFunction(chebyshev) = " + chebyshevFunction(chebyshev));*/

        double range_low = 0;
        double range_high = 2 * Math.PI;
        int n = 3;
        int N = 10;

        double[] localRange = getEquallySpacedPoints(range_low, range_high, N);
        for (int i = 0; i < localRange.length-1; i++) {
            range_low = localRange[i];
            range_high = localRange[i+1];
            double[] points = getEquallySpacedPoints(range_low, range_high, n);
            System.out.println("lagrangeFunction(points) = " + lagrangeFunction(points));
            System.out.println("lagrangeValue(points, range_low) = " + lagrangeValue(points, range_low));
        }
    }

    private static double getValue(double x) {
        //TODO set function f(x)
        //return Math.exp(x);
        return Math.sin(x);
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
                    sb_term.append("(x-").append(points[j]).append(")");
                }
            }
            sb.append("(").append(fi / coefficient).append(sb_term).append(")");
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
            points[k - 1] = 0.5 * (range_low + range_high) + 0.5 * (range_high - range_low) * Math.cos(((double) (2 * k - 1) / (2 * n)) * Math.PI);
        }
        return points;
    }

    private static String chebyshevFunction(double[] zeros) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeros.length; i++) {
            sb.append("(x-(").append(zeros[i]).append("))");
        }
        return sb.toString();
    }
}
