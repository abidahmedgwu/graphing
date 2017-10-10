// Abid Ahmed
// 10-9-17
// Class that creates a 3D Plane

import org.jzy3d.chart.AWTChart;
import org.jzy3d.chart.Chart;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

public class Plane3D {

    // Instance Variables
    private double a; // a is the x direction of the normal vector to the plane
    private double b; // b is the y direction of the normal vector to the plane
    private double c; // c is the z direction of the normal vector to the plane
    private double d; // d is the d in the equation ax + by + cz + d = 0
    private Vector3D direction; // direction is the direction of the normal vector
    // Function of the Plane3D in terms of f(x,y)
    private Mapper mapper = new Mapper() {
        public double f(double x, double y) {
            return (-1 * a * x - b * y - d) / c;
        }
    };

    // Constructors
    public Plane3D() {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        direction = new Vector3D(a, b, c);
    }

    // Used if the direction and point are given
    public Plane3D(Vector3D direction, Point3D point) {
        a = direction.getX();
        b = direction.getY();
        c = direction.getZ();
        d = -1 * a * point.getX() - b * point.getY() - c * point.getZ();
        this.direction = direction;
    }

    // Used if the standard equation of a plane is given.
    // ax + by + cz + d = 0
    public Plane3D(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        direction = new Vector3D(a, b, c);
    }

    // Used if three Point3Ds are given.
    // Creates a plane using 3 Point3Ds.
    public Plane3D(Point3D p1, Point3D p2, Point3D p3) {
        // Creates two vectors using the three points
        Vector3D n1 = Vector3D.getVector3D(p1, p2);
        Vector3D n2 = Vector3D.getVector3D(p1, p3);
        // Gets the direction of the normal vector of the plane by getting the cross product of n1 and n2
        direction = Vector3D.crossProduct(n1, n2);
        // Calls a different constructor to create a Plane3D
        Plane3D helperPlane = new Plane3D(direction, p1);
        a = helperPlane.getA();
        b = helperPlane.getB();
        c = helperPlane.getC();
        d = helperPlane.getD();
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

    public Mapper getMapper() {
        return mapper;
    }

    // toString method
    public String toString() {
        return a + "x + " + b + "y + " + c + "z + " + d + " = 0";
    }

    // Returns the distance between a plane and a point
    public static double distance(Plane3D plane, Point3D point) {
        return (Math.abs(plane.getA() * point.getX() + plane.getB() * point.getY() + plane.getC() * point.getZ()
                + plane.getD())) / (plane.getDirection().getMagnitude());
    }

    // Returns the distance between two planes
    public static double distance(Plane3D p1, Plane3D p2) {
        double z;
        z = (0 - p2.getD()) / p2.getC(); // Let x=y=0. Solve for z
        return distance(p1, new Point3D(0, 0, z));
    }
}
