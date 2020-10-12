public class Square extends Shape2D{
    private double side;
    public Square(double sideI){
        side = sideI;
    }

    @Override
    double getArea() {
        return side * side;
    }

    @Override
    String getName() {
        return "square";
    }
}
