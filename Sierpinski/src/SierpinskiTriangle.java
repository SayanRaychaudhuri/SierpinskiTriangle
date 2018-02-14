import java.awt.*;
import java.util.Random;

public class SierpinskiTriangle {

	public static void main(String[] args) {
        int frameSize = 800;
        int iteration = 9;
        DrawingPanel drawing = new DrawingPanel(frameSize, frameSize);
        Graphics display = drawing.getGraphics();

        int height = (int)(frameSize * Math.sqrt(3.0) / 2);
        Point p1 = new Point(0, height);
        Point p2 = new Point(frameSize / 2, 0);
        Point p3 = new Point(frameSize, height);
        draw(iteration, display, p1, p2, p3);
    }

    public static void draw(int iteration, Graphics display, Point p1, Point p2, Point p3) {
        if (iteration == 1) {
            Polygon p = new Polygon();
            p.addPoint(p1.x, p1.y);
            p.addPoint(p2.x, p2.y);
            p.addPoint(p3.x, p3.y);
            display.fillPolygon(p);
        } else {
            Point p4 = midpoint(p1, p2);
            Point p5 = midpoint(p2, p3);
            Point p6 = midpoint(p1, p3);
            draw(iteration - 1, display, p1, p4, p6);
            draw(iteration - 1, display, p4, p2, p5);
            draw(iteration - 1, display, p6, p5, p3);
            Random rand = new Random();
            int  x = rand.nextInt(255) + 1;
            int  y = rand.nextInt(255) + 1;
            int  z = rand.nextInt(255) + 1;
            Color color = new Color(x,y,z);
            display.setColor(color);
            System.out.println(display.getColor());
        }
    }

    public static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
}