class P2 {
    public static void main(String[] args) {
        double x = 100;
        for (int i=0; i<100000; i++){
            x = P141(x);
        }
        System.out.println("P141:" + x);

        x = 0;
        for (int i=0; i<100; i++){
            x = P142(x);
        }
        System.out.println("P142:" + x);

        x = 100;
        for (int i=0; i<100; i++){
            x = P143_1(x);
        }
        System.out.println("P143, cos:" + x);

        x = 100;
        for (int i=0; i<100; i++){
            x = P143_2(x);
        }
        System.out.println("P143, sin:" + x);

        x = 100;
        for (int i=0; i<1000; i++){
            x = P143_3(x);
        }
        System.out.println("P143, tan:" + x);

        x = 100;
        for (int i=0; i<100; i++){
            x = P144(x);
        }
        System.out.println("P144:" + x);
    }

    public static double P141(double x) {
        return Math.sin(x);
    }

    public static double P142(double x) {
        return x - Math.pow(x, 3) / 12 + 5.0 / 12;
    }

    public static double P143_1(double x) {
        return Math.cos(x);
    }

    public static double P143_2(double x) {
        return Math.sin(x);
    }

    public static double P143_3(double x) {
        return Math.tan(x);
    }

    public static double P144(double x) {
        return 1 / Math.sqrt(x);
    }
}