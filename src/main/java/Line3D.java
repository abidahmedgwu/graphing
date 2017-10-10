// Abid Ahmed
// 10-8-17
// A class that creates a 3D line.
// Uses the vector equation of a line
// Does not inherit from Line2D

public class Line3D {

    // Instance variables
    private Point3D point;
    private Vector3D direction;

    // Constructors
    public Line3D() {
        point = new Point3D(0,0,0);
        direction = new Vector3D(0,0,0);
    }

    public Line3D(Point3D point, Vector3D direction) {
        this.point = point;
        this.direction = direction;
    }

    // Constructor that creates a Line3D from two points
    public Line3D(Point3D point1, Point3D point2) {
        this.point = point1;
        this.direction = Vector3D.getVector3D(point1, point2);
    }

    // Constructor that creates a Line3D from the intersection of two planes.

    // Accessor methods
    public Point3D getPoint() {
        return point;
    }

    public Vector3D getDirection() {
        return direction;
    }

    // toString method
    // Returns vector equation of a line
    public String toString() {
        return "<" + point.getX() + " + " + direction.getX() + "t, "
                + point.getY() + " + " + direction.getY() + "t, "
                + point.getZ() + " + " + direction.getZ() + "t>";
    }

    // Returns the parametric equation of a line
    public String parametricEquation() {
        return "x = " + point.getX() + " + " + direction.getX() + "t, "
                + "y = " + point.getY() + " + " + direction.getY() + "t, "
                + "z = " + point.getZ() + " + " + direction.getZ() + "t";
    }
}
