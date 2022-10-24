public abstract class Shape implements Drawable {
    protected String shapeColor;
    public Shape(String color) {
        shapeColor = color;
    }
    public String getShapeColor () {
        return shapeColor;
    }
    public abstract double calcArea();
    @Override
    public String toString() {
        return String.format("The color of shape is: %s",  shapeColor);
    }
}
