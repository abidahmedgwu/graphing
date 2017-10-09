// Abid Ahmed
// 10-9-17
// Class that creates a 3D Plane

public class Plane3D {

    // Instance Variables
    private double a; // a is the x direction of the normal vector
    private double b; // b is the y direction of the normal vector
    private double c; // c is the z direction of the normal vector
    private double d; // d is the d in the equation ax + by + cz + d = 0
    private Vector3D direction; // direction is the direction of the normal vector

    // Constructors
    public Plane3D() {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        direction = new Vector3D(a,b,c);
    }

    // Used if the direction and point are given
    public Plane3D(Vector3D direction, Point3D point) {
        a = direction.getX();
        b = direction.getY();
        c = direction.getZ();
        d = -1*a*point.getX()-b*point.getY()-c*point.getZ();
        this.direction = direction;
    }

    // Used if the standard equation of a plane is given.
    // ax + by + cz + d = 0
    public Plane3D(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        direction = new Vector3D(a,b,c);
    }

    // Accessor methods
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public Vector3D getDirection() {
        return direction;
    }

    // toString method
    public String toString() {
        return a + "x + " + b + "y + " + c + "z + " + d + " = 0";
    }

    // Returns the distance between a plane and a point
    public static double distance(Plane3D plane, Point3D point) {
        return (Math.abs(plane.getA()*point.getX() + plane.getB()*point.getY() + plane.getC()*point.getZ() + plane.getD()))/(plane.getDirection().getMagnitude());
    }

    // Returns the distance between two planes
    public static double distance(Plane3D p1, Plane3D p2) {
        double z;
        z = (0-p2.getD())/p2.getC(); // Let x=y=0. Solve for z
        return distance(p1, new Point3D(0,0,z));
    }

}
