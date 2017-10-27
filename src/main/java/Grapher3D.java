// Abid Ahmed
// 10-10-17
// Class that graphs a function f(x,y);

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

public class Grapher3D {

    // Graphs the plane with default settings
    public static void graph(Mapper mapper) {
        // Define the range of the graph and the interval of points
        Range range = new Range(-200, 200);
        int steps = 50;

        // Create a surface for the function
        Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, steps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), range));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);

        // Create a chart for the surface and add the surface to it
        Chart chart = new AWTChart(Quality.Advanced);
        chart.add(surface);
        chart.open("Graph Window", 750, 750);
    }

    // Graphs the plane with a specified range and interval of points
    public static void graph(Mapper mapper, int xMin, int xMax, int xSteps, int yMin, int yMax, int ySteps) {
        // Define the range of the graph
        Range xRange = new Range(xMin, xMax);
        Range yRange = new Range(yMin, yMax);

        // Create a surface for the function
        Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(xRange, xSteps, yRange, ySteps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), xRange));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);

        // Create a chart for the surface and add the surface to it
        Chart chart = new AWTChart(Quality.Advanced);
        chart.add(surface);
        chart.open("Default title", 750, 750);
    }

    /* Create a graph with a default range and interval but customize the appearance of the graph and window.
    String title is the title of the window.
    Color color is the color of the surface. To get a rainbow surface, set input null for color
    Color is the Color class in the jzy3d library
    int width and int height are the dimensions of the window.
     */
    public static void graph(Mapper mapper, String title, Color color, int width, int height) {
        // Define a function in terms of f(x,y);
        Range range = new Range(-200, 200);
        int steps = 50;

        // Create a surface for the function
        Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, steps), mapper);
        if (color == null) {
            surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), range));
        } else {
            surface.setColor(color);
        }
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);

        // Create a chart for the surface and add the surface to it
        Chart chart = new AWTChart(Quality.Advanced);
        chart.add(surface);
        chart.open(title, width, height);
    }

    /*Create a graph that is fully customizable
    boolean showWireframe is to display the wireframe on the surface
    */
    public static void graph(Mapper mapper, String title, Color color, int width, int height,
                             int xMin, int xMax, int xSteps, int yMin, int yMax, int ySteps,
                             boolean showWireframe) {
        // Define the range of the graph
        Range xRange = new Range(xMin, xMax);
        Range yRange = new Range(yMin, yMax);

        // Create a surface
        Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(xRange, xSteps, yRange, ySteps), mapper);
        if (color == null) {
            surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), xRange));
        } else {
            surface.setColor(color);
        }
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(showWireframe);
        surface.setWireframeColor(Color.BLACK);

        // Create a chart for the surface and the surface to it
        Chart chart = new AWTChart(Quality.Advanced);
        chart.add(surface);
        chart.open(title, width, height);
    }
}
