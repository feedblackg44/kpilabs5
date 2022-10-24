public class Circle extends Shape {
    private int radius;
    public Circle(int radius, String color) {
        super(color);
        this.radius = radius;
    }
    @Override
    public String draw() {
        StringBuilder builder = new StringBuilder();
        builder.append(shapeColor);
        double rIn = radius - 0.4;
        double rOut = radius + 0.4;
        for (double j = radius; j >= -radius; --j) {
            for (double i = -radius; i < rOut; i += 0.5) {
                double value = i * i + j * j;
                if (value >= rIn * rIn && value <= rOut * rOut)
                    builder.append("+");
                else
                    builder.append(" ");
            }
            builder.append('\n');
        }
        builder.append("\u001B[0m");
        return builder.toString();
    }
    @Override
    public double calcArea() {
        return 2 * Math.PI * radius;
    }
    @Override
    public String toString() {
        return String.format("%sCircle with radius = %d\u001B[0m", shapeColor, radius);
    }
}
