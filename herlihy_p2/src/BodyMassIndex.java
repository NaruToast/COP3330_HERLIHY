public class BodyMassIndex {
    private double weight;
    private double height;
    public BodyMassIndex(double myHeight, double myWeight) {
        weight = myWeight;
        height = myHeight;
    }

    public double score(){
        double temp = 703.0 * (weight / (height * height)) * 1000;
        long temp2 = Math.round(temp);
        double actual = (double)temp2/1000;
        return actual;
    }

    public String findCat(double myScore){
        if(myScore<18.5){
            return "Underweight";
        }else if(myScore<24.9){
            return "Normal weight";
        }else if(myScore<29.9){
            return "Overweight";
        }else{
            return "Obese";
        }
    }
}
