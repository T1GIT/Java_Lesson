package seminar_1;

public abstract class sem_1 {
    public static void task_1() {
        System.out.print("Hello World");
    }
    public static void task_2() {
        int a;
        a = 5;
        System.out.print(a);
    }
    public static void task_3() {
        int a = 0;
        a++;
        ++a;
        a += 1;
        a = a + 1;
        System.out.print(a);
    }
    public static void task_4() {
        int a = 2;
        int b = 10;

        int c = a;
        a = b;
        b = c;
    }
    public static double task_5(double a, double b) {
        return Math.sqrt(a*a + b*b);
    }
    public static int task_6(int a) {
        return a % 10;
    }
    public static int task_7(int a) {
        return a / 100 % 10;
    }
    public static int task_8(int a) {
        return a / 10;
    }
    public static int task_9(int a) {
        return a - 21;
    }
    public static float task_10(int a, int b) {
        return (float) (a + b) / 2;
    }
    public static double task_11(int a, int b) {
        return (double) Math.sqrt(a * b);
    }
    public static double task_12(double x1, double y1, double x2, double y2) {
        double a = x2 - x1;
        double b = y2 - y1;
        return Math.sqrt(a*a + b*b);
    }
}
