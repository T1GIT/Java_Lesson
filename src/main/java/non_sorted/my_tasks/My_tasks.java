package non_sorted.my_tasks;

public class My_tasks {
    //public class Main
//{
//    public static void main(String[] args) {
//        double[] ar = new double[100];
//        for (int i = 0; i < ar.length; i++) {
//            ar[i] = Math.random();
//        }
//
//        double max = ar[0];
//        double min = ar[0];
//        double sum = 0;
//
//        for (double x: ar) {
//            if (x > max) max = x;
//            if (x < min) min = x;
//            sum += x;
//        }
//
//        double avg = sum / ar.length;
//
//        System.out.println("max = " + max);
//        System.out.println("min = " + min);
//        System.out.println("avg = " + avg);
//    }
//}

//public class Main
//{
//    public static void main(String[] args) {
//        double[] ar = new double[100];
//        for (int i = 0; i < ar.length; i++) {
//            ar[i] = Math.random();
//        }
//
//        double temp;
//
//        for (int i = 0; i < ar.length - 1; i++) {
//            for (int j = 0; j < ar.length - 1; j++) {
//                if (ar[j] > ar[j + 1]) {
//                    temp = ar[j];
//                    ar[j] = ar[j + 1];
//                    ar[j + 1] = temp;
//                }
//            }
//        }
//
//        for (double x: ar) {
//            System.out.println(x);
//        }
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        boolean complex;
//        for (int i = 2; i <= 100; i++) {
//            complex = false;
//            for (int j = 2; j <= i / 2; j++) {
//                if (i % j == 0) {
//                    complex = true;
//                    break;
//                }
//            }
//            if (!complex) System.out.println(i);
//        }
//    }
//}

//public class Main
//{
//    public static void main(String[] args) {
//        final int elNum = 4;
//        double[] ar = new double[10];
//        for (int i = 0; i < ar.length; i++) {
//            ar[i] = i;
//        }
//        arOut(arDel(ar, elNum));
//    }
//
//    public static double[] arDel(double[] ar, int elNum) {
//        double[] newAr = new double[ar.length - 1];
//        for (int i = 0; i < elNum; i++) {
//            newAr[i] = ar[i];
//        }
//        for (int i = elNum; i < ar.length - 1; i++) {
//            newAr[i] = ar[i + 1];
//        }
//        return newAr;
//    }
//
//    public static void  arOut(double[] ar) {
//        for (double x: ar) {
//            System.out.print(x + " ");
//        }
//    }
//}
}
