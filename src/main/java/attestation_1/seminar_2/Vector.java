package attestation_1.seminar_2;

public class Vector {
    final private double x;
    final private double y;
    final private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }
    public double scalar(Vector obj) {
        return x * obj.x + y * obj.y + z * obj.z;
    }
    public Vector mul(Vector obj) {
        return new Vector(
                y*obj.z - z*obj.y,
                z*obj.x - x*obj.z,
                x*obj.y - y*obj.x
        );
    }
    public double angle(Vector obj) {
        return Math.toDegrees(Math.acos(this.scalar(obj) / (this.length() * obj.length())));
    }
    public Vector add(Vector obj) {
        return new Vector(x + obj.x, y + obj.y, z + obj.z);
    }
    public Vector sub(Vector obj) {
        return new Vector(x - obj.x, y - obj.y, z - obj.z);
    }
    public static Vector[] randomVectorList(int n) {
        int halfRange = 1000;
        Vector[] res = new Vector[n];
        for (int i = 0; i < n; i++) {
            res[i] = new Vector(
                    (Math.random() - 0.5) * halfRange,
                    (Math.random() - 0.5) * halfRange,
                    (Math.random() - 0.5) * halfRange
            );
        }
        return res;
    }
    public void print() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
}
