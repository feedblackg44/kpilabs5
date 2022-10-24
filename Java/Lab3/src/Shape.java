public abstract class Shape implements Drawable {
    protected String shapeColor;
    public Shape(String color) {
        shapeColor = color;
    }
    public abstract double calcArea();
    @Override
    public String toString() {
        return String.format("The color of shape is: %s",  shapeColor);
    }
}
