// Abid Ahmed
// 10-4-17
// A class that creates a 3 dimensional vector


public class Vector3D extends Vector {

    // Instance variables
    private double x;
    private double y;
    private double z;

    // Default Constructor
    public Vector3D() {
        super(new double[] {0,0,0});
        x = getComponents()[0];
        y = getComponents()[1];
        z = getComponents()[2];
    }

    // Standard Constructor
    public Vector3D(double x, double y, double z) {
        super(new double[] {x,y,z});
        this.x = getComponents()[0];
        this.y = getComponents()[1];
        this.z = getComponents()[2];
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

    // Calculates the scalar projection of Vector 3D b onto Vector 3D a
    public static double comp (Vector3D a, Vector3D b) {
        return dotProduct(a,b) / a.getMagnitude();
    }

    // Calculates the projection of Vector3D b onto Vector3D a
    public static Vector3D proj (Vector3D a, Vector3D b) {
        return (Vector3D)multiply(a.getUnitVector(), comp(a,b));
    }

    // Creates a vector from two Point3Ds
    public static Vector3D getVector3D(Point3D a, Point3D b) {
        return new Vector3D(b.getX()-a.getX(), b.getY()-a.getY(), b.getZ()-a.getZ());
    }
}
