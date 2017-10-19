public class A2_P7 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			double[] res = p7_1(i);
			System.out.println(res[0] + "," + res[1]);
			// -1.0,0.0
			// -1.0,0.36787944117144233
			// -0.9217411786251671,0.3966692526455516
			// -0.9165897048743263,0.39987514091248655
			// -0.9165625838414706,0.3998912738453655
			// -0.9165625831056982,0.3998912742866619
			// -0.9165625831056982,0.3998912742866619
			// -0.9165625831056982,0.3998912742866619
			// -0.9165625831056982,0.3998912742866619
			// -0.9165625831056982,0.3998912742866619
		}

		for (int i = 0; i < 10; i++) {
			double[] res = p7_2(i);
			System.out.println(res[0] + "," + res[1] + "," + res[2]);
			// -1.0,0.0
			// -1.0,0.36787944117144233
			// -0.9217411786251671,0.3966692526455516
			// -0.9165897048743263,0.39987514091248655
			// -0.9165625838414706,0.3998912738453655
			// -0.9165625831056982,0.3998912742866619
			// -0.9165625831056982,0.3998912742866619
			// -0.9165625831056982,0.3998912742866619
			// -0.9165625831056982,0.3998912742866619
			// -0.9165625831056982,0.3998912742866619
		}

	}

	private static double[] p7_1(int n) {
		if (n == 0) {
			return new double[] { -1, 0.0 };
		} else {
			double[] xs = p7_1(n - 1);
			double x1 = xs[0];
			double x2 = xs[1];
			double[] res = twoDimension(
					new double[][] { new double[] { 2 * x1, 2 * x2, 1 - Math.pow(x1, 2) - Math.pow(x2, 2) },
							new double[] { -Math.exp(x1), 1, Math.exp(x1) - x2 } });
			return new double[] { x1 + res[0], x2 + res[1] };
		}
	}

	private static double[] p7_2(int n) {
		if (n == 0) {
			return new double[] { -1, -1, 0.0 };
		} else {
			double[] xs = p7_2(n - 1);
			double x1 = xs[0];
			double x2 = xs[1];
			double x3 = xs[2];
			double[] res = threeDimension(new double[][] {
					new double[] { 2 * x1, 2 * x2, 2 * x3, 1 - Math.pow(x1, 2) - Math.pow(x2, 2) - Math.pow(x3, 2) },
					new double[] { -Math.exp(x1), 0, 1, Math.exp(x1) - x3 },
					new double[] { 0, -Math.exp(x2), 1, Math.exp(x2) - x3 } });
			return new double[] { x1 + res[0], x2 + res[1], x3 + res[2] };
		}
	}

	private static double[] twoDimension(double[][] e) {
		double a = e[0][0];
		double b = e[0][1];
		double c = e[1][0];
		double d = e[1][1];

		double m = e[0][2];
		double n = e[1][2];

		double mutl1 = c / a;
		d = d - mutl1 * b;
		n = n - mutl1 * m;
		double y = n / d;
		double x = (m - b * y) / a;

		return new double[] { x, y };
	}

	private static double[] threeDimension(double[][] e) {
		double a = e[0][0];
		double b = e[0][1];
		double c = e[0][2];
		double r = e[1][0];
		double s = e[1][1];
		double t = e[1][2];
		double u = e[2][0];
		double v = e[2][1];
		double w = e[2][2];

		double i = e[0][3];
		double j = e[1][3];
		double k = e[2][3];

		double mutl1 = r / a;
		s = s - mutl1 * b;
		t = t - mutl1 * c;
		j = j - mutl1 * i;

		double mutl2 = u / a;
		v = v - mutl2 * b;
		w = w - mutl2 * c;
		k = k - mutl2 * i;

		double mutl3 = v / s;
		w = w - mutl3 * t;
		k = k - mutl3 * j;

		double z = k / w;
		double y = (j - t * z) / s;
		double x = (i - c * z - b * y) / a;

		return new double[] { x, y, z };
	}

}
