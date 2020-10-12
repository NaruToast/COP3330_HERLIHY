public class Cube extends Shape3D{
    private double edge;
    public Cube(double edgeI){
        edge = edgeI;
    }

    @Override
    double getArea() {
        return 6 * edge * edge;
    }

    @Override
    String getName() {
        return "cube";
    }

    @Override
    double getVolume() {
        return edge * edge * edge;
    }
}
