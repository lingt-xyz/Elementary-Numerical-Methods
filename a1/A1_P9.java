public class A1_P9 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			run(i);
		}
	}
	
	public static void run(double N) {
		float sum = 0;
		float end = (float) Math.pow(10, N);
		for (float i = 1; i <= end; i++) {
			sum += 1 / i;
		}
		System.out.println(sum);
	}

}
