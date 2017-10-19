

public class A1_P10 {

	private static double sequence(int n) {
		if (n == 0) {
			return 2000.0;
		}
		double x = sequence(n-1);
		return (Math.pow(x, 2) + 5) / (2 * x);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(sequence(i));
		}
	}
}
