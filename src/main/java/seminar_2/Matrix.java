package seminar_2;

public class Matrix {
    final private double[][] storage;
    final private int width;
    final private int height;

    public Matrix(double[][] storage) {
        this.storage = storage;
        this.height = storage.length;
        this.width = storage[0].length;
    }
    public Matrix add(Matrix second) {
        double[][] res = new double[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res[i][j] = storage[i][j] + second.storage[i][j];
            }
        }
        return new Matrix(res);
    }
    public Matrix sub(Matrix second) {
        double[][] res = new double[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res[i][j] = storage[i][j] - second.storage[i][j];
            }
        }
        return new Matrix(res);
    }
    public Matrix mulNum(double num) {
        double[][] res = new double[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res[i][j] = storage[i][j] * num;
            }
        }
        return new Matrix(res);
    }
    public Matrix mul(Matrix second) {
        if (this.width != second.height) {throw new ArithmeticException();}
        double[][] res = new double[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double sum = 0;
                for (int k = 0; k < width; k++) {
                    sum += storage[i][k] * storage[k][j];
                }
                res[i][j] = sum;
            }
        }
        return new Matrix(res);
    }
    public Matrix pow(int num) {
        if (this.width != this.height) {throw new ArithmeticException();}
        Matrix a = new Matrix(storage);
        for (; num > 1; num--) {
            a = a.mul(a);
        }
        return a;
    }
    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(storage[i][j] + " ");
            }
            System.out.println();
        }
    }
}
