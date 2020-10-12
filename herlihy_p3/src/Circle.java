public class Circle extends Shape2D{
    private double radius;
    public Circle(double radiusI){
        radius = radiusI;
    }

    @Override
    double getArea() {
        return 3.141592 * radius * radius;
    }

    @Override
    String getName() {
        return "circle";
    }
}