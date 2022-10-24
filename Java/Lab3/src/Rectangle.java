public class Rectangle extends Shape {
    private int a;
    private int b;
    public Rectangle(int a, int b, String color) {
        super(color);
        this.a = a;
        this.b = b;
    }
    @Override
    public String draw() {
        StringBuilder builder = new StringBuilder();
        builder.append(shapeColor);
        for (int j = 0; j < b; j++) {
            for (int i = 0; i < a; i++) {
                if (j == 0 || j == b - 1)
                    builder.append("+");
                else if (i == 0 || i == a - 1)
                    builder.append("+");
                else
                    builder.append(" ");
                if (i != a - 1)
                    builder.append(" ");
            }
            builder.append('\n');
        }
        builder.append("\u001B[0m");
        return builder.toString();
    }
    @Override
    public double calcArea() {
        return a * b;
    }
}
