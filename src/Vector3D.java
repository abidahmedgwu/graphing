// Abid Ahmed
// 10-4-17
// A class that creates a 3 dimensional vector

public class Vector3D {

    // Instance variables
    private double x;
    private double y;
    private double z;

    // Default Constructor
    public Vector3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    // Standard Constructor
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Accessor Methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    // Other methods
    public String toString() {
        return "<" + x + ", " + y + ", " + z + ">";
    }

    // Calculates the length/magnitude of the vector
    public double getMagnitude() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    // Calculates the unit vector
    public Vector3D getUnitVector() {
        return new Vector3D(x/getMagnitude(), y/getMagnitude(), z/getMagnitude());
    }

    // Calculates the dot product of two given vectors
    public static double dotProduct(Vector3D a, Vector3D b) {
        return a.getX()*b.getX() + a.getY()*b.getY() + a.getZ()*b.getZ();
    }

    // Calculates the dot product of two vectors using the magnitude of a and b
    // and the angle (in degrees) between a and b
    public static double dotProduct(double aMagnitude, double bMagnitude, double theta) {
        return aMagnitude*bMagnitude*Math.cos(theta);
    }

    // Calculates the cross product of two given vectors
    public static Vector3D crossProduct(Vector3D a, Vector3D b) {
        double x = a.getY()*b.getZ() - a.getZ()*b.getY();
        double y = -1*(a.getX()*b.getZ() - a.getZ()*b.getX());
        double z = (a.getX()*b.getY() - a.getY()*b.getX());
        return new Vector3D(x,y,z);
    }

    // Calculates the magnitude of the cross product of two vectors using the magnitude of a and b
    // and the angle (in degrees) between a and b
    public static double crossProductMagnitude(double aMagnitude, double bMagnitude, double theta) {
        return aMagnitude*bMagnitude*Math.sin(theta);
    }

    // Adds two given vectors
    public static Vector3D add (Vector3D a, Vector3D b) {
        return new Vector3D(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    // Subtracts two given vectors
    public static Vector3D subtract(Vector3D a, Vector3D b) {
        return new Vector3D(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
    }

    // Multiplies a vector and a scalar
    public static Vector3D multiply (Vector3D a, double t) {
        return new Vector3D(t*a.getX(), t*a.getY(), t*a.getZ());
    }

    // Divides a vector and a scalar
    public static Vector3D divide (Vector3D a, double t) {
        return new Vector3D(a.getX()/t, a.getY()/t, a.getZ()/t);
    }

    // Calculates which vector is larger (by magnitude).
    // Returns -1 if a < b. Returns 0 if a = b, Returns 1 if a > b
    public static int compareTo (Vector3D a, Vector3D b) {
        if (a.getMagnitude() < b.getMagnitude()) {
            return -1;
        } else if (a.getMagnitude() > b.getMagnitude()) {
            return 1;
        } else {
            return 0;
        }
    }

    // Calculates the scalar projection of Vector 3D b onto Vector 3D a
    public static double comp (Vector3D a, Vector3D b) {
        return dotProduct(a,b) / a.getMagnitude();
    }

    // Calculates the projection of Vector3D b onto Vector3D a
    public static Vector3D proj (Vector3D a, Vector3D b) {
        return multiply(a.getUnitVector(), comp(a,b));
    }

    // Creates a vector from two Point3Ds
    public static Vector3D getVector3D(Point3D a, Point3D b) {
        return new Vector3D(b.getX()-a.getX(), b.getY()-a.getY(), b.getZ()-a.getZ());
    }
}
