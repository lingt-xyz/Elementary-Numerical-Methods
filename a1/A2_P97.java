public class A2_P97 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(p7(i)[0] + "," + p7(i)[1]);
		}
	}

	private static double[] p7(int n) {
		if (n == 0) {
			return new double[] { 2.0, 2.0 };
		} else {
			double[] xs = p7(n - 1);
			double x1 = xs[0];
			double x2 = xs[1];
			return new double[] { x1 + p7_1(x1, x2), x2 + p7_2(x1, x2) };
		}
	}

	private static double p7_1(double x1, double x2) {
		return (1 - Math.pow(x1, 6)) / (2 * x1 * x2 + 4 * Math.pow(x1, 5));
	}

	private static double p7_2(double x1, double x2) {
		return Math.pow(x1, 4) - x2 + 2 * Math.pow(x1, 2) * (1 - Math.pow(x1, 6)) / (x2 + 2 * Math.pow(x1, 4));
	}

}
