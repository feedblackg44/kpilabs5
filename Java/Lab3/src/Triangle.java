public class Triangle extends Shape {
    private int a;
    private int b;
    private double c;
    public Triangle(int a, int b, String color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    @Override
    public String draw() {
        StringBuilder builder = new StringBuilder();
        builder.append(shapeColor);
        double coeff = (double) a / b;
        for (int j = 0; j < b; j++) {
            for (int i = 0; i < a; i++) {
                if (j == b - 1)
                    builder.append("+");
                else if (i == 0 || i == (int)Math.floor(coeff*(j + 1)))
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
        return a * b * 0.5;
    }
}
