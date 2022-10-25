public class ShapeView {
    public void printToConsole(String msg) {
        System.out.println(msg + '\n');
    }
    public void printResult(String msg, String result) {
        System.out.format("%s:\n%s\n\n", msg, result);
    }
    public void printResult(String msg, double result) {
        System.out.format("%s:\n%f\n\n", msg, result);
    }
}
