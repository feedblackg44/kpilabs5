import java.util.ArrayList;
import java.util.Comparator;

public class ShapeController {
    private ArrayList<Shape> shapes;
    private ShapeView view;
    public ShapeController (ShapeView view) {
        shapes = new ArrayList<Shape>();
        this.view = view;
    }
    public ShapeController (ArrayList<Shape> shapes, ShapeView view) {
        this.shapes = shapes;
        this.view = view;
    }
    public void Add(Shape shape) {
        shapes.add(shape);
    }
    public void showAll() {
        view.printResult("List of shapes", all());
    }
    public void calculateAreas() {
        view.printResult("Sum of all shapes' areas", sumOfAreasOfFigure(null));
    }
    public void calculateSpecificAreas(Object instance) {
        view.printResult("Sum of all shapes' areas", sumOfAreasOfFigure(instance));
    }
    public void sortByAreas() {
        Comparator<Shape> comparatorByArea = Comparator.comparing(Shape::calcArea);
        shapes.sort(comparatorByArea);
        view.printResult("Sorted by Area list of shapes", all());
    }
    public void sortByColor() {
        Comparator<Shape> comparatorByColor = Comparator.comparing(Shape::getShapeColor);
        shapes.sort(comparatorByColor);
        view.printResult("Sorted by Color list of shapes", all());
    }
    public String all() {
        StringBuilder builder = new StringBuilder();
        for (Shape shape : shapes)
            builder.append(shape.toString()).append("\n");
        return builder.toString();
    }
    public double sumOfAreasOfFigure(Object instance) {
        int sum = 0;
        for (Shape shape : shapes)
            if (instance == null)
                sum += shape.calcArea();
            else if (shape.getClass() == instance)
                sum += shape.calcArea();
        return sum;
    }
}
