public class Triangle extends Shape2D{
    private double base;
    private double height;
    public Triangle(double baseI, double heightI) {
        base = baseI;
        height = heightI;
    }

    @Override
    double getArea() {
        return 0.5 * base * height;
    }

    @Override
    String getName() {
        return "triangle";
    }
}