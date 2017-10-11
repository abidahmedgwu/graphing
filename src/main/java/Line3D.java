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
    public Line3D(Plane3D plane1, Plane3D plane2) {
        // Get the direction of the line that intersects the plane
        direction = Vector3D.crossProduct(plane1.getDirection(), plane2.getDirection());
        // To get the point, let z = 0 and solve for the resulting system of equations
        // leftSide is the leftSide of the equation
        // rightSide is the rightSide of the equation
        double[][] leftSide = {{plane1.getA(), plane1.getB()},
                             {plane2.getA(), plane2.getB()}};
        double[][] rightSide = {{-1*plane1.getD()},
                              {-1*plane2.getD()}};
        Matrix solution = Matrix.multiply(new Matrix(leftSide).inverse2x2(), new Matrix(rightSide));
        point = new Point3D(solution.getMatrix()[0][0], solution.getMatrix()[1][0], 0);
    }

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
