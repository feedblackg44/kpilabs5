import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        ArrayList<Shape> list = new ArrayList<Shape>();
        list.add(new Triangle(3, 4, ANSI_GREEN));
        list.add(new Triangle(5, 12, ANSI_YELLOW));
        list.add(new Triangle(6, 8, ANSI_BLUE));
        list.add(new Triangle(4, 7, ANSI_GREEN));
        list.add(new Rectangle(1, 2, ANSI_CYAN));
        list.add(new Rectangle(2, 3, ANSI_PURPLE));
        list.add(new Rectangle(3, 4, ANSI_WHITE));
        list.add(new Rectangle(4, 5, ANSI_BLUE));
        list.add(new Circle(5, ANSI_RED));
        list.add(new Circle(6, ANSI_BLACK));
        list.add(new Circle(7, ANSI_PURPLE));
        list.add(new Circle(8, ANSI_YELLOW));

        System.out.format("List of shapes:\n%s\n", showAll(list));
        System.out.format("Sum of all shapes' areas: %s\n", sumOfAreasOfFigure(list, null));
        System.out.format("Sum of all Triangles' areas: %s\n\n", sumOfAreasOfFigure(list, Triangle.class));
        Comparator<Shape> comparatorByArea = Comparator.comparing(Shape::calcArea);
        list.sort(comparatorByArea);
        System.out.format("Sorted by Area list of shapes:\n%s\n", showAll(list));
        Comparator<Shape> comparatorByColor = Comparator.comparing(Shape::getShapeColor);
        list.sort(comparatorByColor);
        System.out.format("Sorted by Color list of shapes:\n%s\n", showAll(list));
    }
    public static String showAll(ArrayList<Shape> shapes) {
        StringBuilder builder = new StringBuilder();
        for (Shape shape : shapes)
            builder.append(shape.toString()).append("\n");
        return builder.toString();
    }
    public static double sumOfAreasOfFigure(ArrayList<Shape> shapes, Object instance) {
        int sum = 0;
        for (Shape shape : shapes)
            if (instance == null)
                sum += shape.calcArea();
            else if (shape.getClass() == instance)
                sum += shape.calcArea();
        return sum;
    }
}