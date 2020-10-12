public class Sphere extends Shape3D{
    private double radius;
    public Sphere(double radiusI){
        radius = radiusI;
    }

    @Override
    double getArea() {
        return 4 * 3.141592 * radius * radius;
    }

    @Override
    String getName() {
        return "sphere";
    }

    @Override
    double getVolume() {
        return 3.141592 * radius * radius * radius * 4 / 3;
    }
}
