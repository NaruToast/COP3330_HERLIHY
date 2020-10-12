public class Pyramid extends Shape3D{
    private double base;
    private double width;
    private double height;
    public Pyramid(double baseI, double widthI, double heightI){
        base = baseI;
        width = widthI;
        height = heightI;
    }

    @Override
    double getArea() {
        return base * width + base * java.lang.Math.sqrt((width / 2) * (width / 2) + height * height) + width * java.lang.Math.sqrt((base / 2) * (base / 2) + height * height);
    }

    @Override
    String getName() {
        return "pyramid";
    }

    @Override
    double getVolume() {
        return base * width * height / 3;
    }
}