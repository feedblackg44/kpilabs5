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
                boolean toPrint = i == (int)Math.floor(coeff*(j + 1));
                if (coeff > 1) {
                    double temp = 1 / coeff;
                    toPrint = j + 1 == (int)Math.floor(temp*(i + 1));
                }
                if (j == b - 1)
                    builder.append("+");
                else if (i == 0 || toPrint )
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
    @Override
    public String toString() {
        return String.format("%sTriangle with sides: %d, %d, %f\u001B[0m", shapeColor, a, b, c);
    }
}
