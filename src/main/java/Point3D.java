// Abid Ahmed
// 10-2-17
// A class that creates a 3 dimensional point

public class Point3D extends Point2D {

    // Instance variables
    private double z;

    // Default Constructor
    public Point3D() {
        super();
        this.z = 0;
    }

    // Constructors
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point2D point, double z) {
        super(point.getX(), point.getY());
        this.z = z;
    }

    // Accessor methods
    public double getZ() {
        return z;
    }

    // toString method
    public String toString() {
        return "(" + super.getX() + ", " + super.getY() + ", " + z + ")";
    }

    // Calculates the distance between two Point3Ds
    public static double distance(Point3D a, Point3D b) {
        return Math.sqrt(Math.pow(a.getX()-b.getX(),2) + Math.pow(a.getY()-b.getY(),2) +
                Math.pow(a.getZ()-b.getZ(),2));
    }

    // Moves a Point3D by assigning x, y, and z to new values
    public void move(double x, double y, double z) {
        super.move(x,y);
        this.z = z;
    }
}
