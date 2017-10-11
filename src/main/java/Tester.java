import org.jzy3d.colors.Color;
import org.jzy3d.plot3d.builder.Mapper;

public class Tester {

    public static void main(String[] args) {
        Vector3D a = new Vector3D(1, 1, 1);
        Vector3D b = new Vector3D(0, 3, 4);

        System.out.println(Vector3D.dotProduct(a, b));
        System.out.println(Vector3D.crossProduct(a, b));
        System.out.println(b.getUnitVector());

        double[] nums = {2, 5, 1, 3, 2};
        printArray(Derivative.deriveStandardPolynomial(nums));
        System.out.println(Point3D.distance(new Point3D(2, 2, Math.pow(8, .5)), new Point3D(0, 0, 0)));

        Line2D line1 = new Line2D(2, 2);
        Line2D line2 = new Line2D(0, 2);
        System.out.println(Line2D.getIntersection(line1, line2));

        Point2D test = new Point2D(0, 0);
        System.out.println(test);
        test.move(1, 1);
        System.out.println(test);

        Point3D test1 = new Point3D(0,0,0);
        Point3D test2 = new Point3D(5,2,6);
        System.out.println(Vector3D.getVector3D(test1, test2));

        Line3D line = new Line3D(new Point3D(1,2,3), new Vector3D(2,3,4));
        System.out.println(line.parametricEquation());

        Plane3D plane = new Plane3D(new Vector3D(2,-8,5), new Point3D(1,-2,0));
        System.out.println(plane);

        Plane3D plane1 = new Plane3D(3, 6, -3, -4);
        Point3D point = new Point3D(0,0,1);
        System.out.println(Plane3D.distance(plane1, point));

        Plane3D plane2 = new Plane3D(1, 2, -1, 1);
        System.out.println(Plane3D.distance(plane1, plane2));

        Point3D p1 = new Point3D(1,1,1);
        Point3D p2 = new Point3D(-1,1,0);
        Point3D p3 = new Point3D(2,0,3);
        Plane3D plane3 = new Plane3D(p1, p2, p3);
        System.out.println(plane3);

        Mapper mapper = plane3.getMapper();
        /*Grapher.graph(mapper);
        Grapher.graph(mapper, -200, 200, 100, -200, 200, 100);
        Grapher.graph(mapper, "My title", null, 1000, 750);*/
        //Grapher.graph(mapper, plane3.toString(), null, 1000, 1000, -500, 500, 250,
          //      -100, 100, 50, true);
        double[][] arr = {{1,2}, {3,4}};
        Matrix matrix = new Matrix(arr);
        System.out.println(matrix);

        double[][] arr1 = {{1,2,3}, {4,5,6}};
        double[][] arr2 = {{7,8}, {9,10}, {11, 12}};
        Matrix m1 = new Matrix(arr1);
        Matrix m2 = new Matrix(arr2);
        Matrix mult = Matrix.multiply(m1,2);
        System.out.println(mult);
    }

    public static void printArray(double[] a) {
        for (double num: a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
