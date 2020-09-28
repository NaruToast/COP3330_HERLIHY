import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double average = 0.0;
        BodyMassIndex bmi;
        int i;
        for(i = 0; i < bmiData.size(); i++) {
            bmi = bmiData.get(i);
            average = average + bmi.score();
        }
        average = average/i * 1000;
        long temp2 = Math.round(average);
        double actual = (double)temp2/1000;
        System.out.println("The average bmi score is: " + actual);
    }

    private static void displayBmiInfo(BodyMassIndex bmi){
        double bmiScore;
        bmiScore = bmi.score();
        System.out.println("Your bmi is: " + bmiScore);
        System.out.println("This score means you are: " + bmi.findCat(bmiScore));
    }

    private static boolean moreInput(){
        boolean validInput = false;
        String boolCode;
        while(!validInput) {
            System.out.print("Would you like to enter more info? (Enter Y or N): ");
            boolCode = input.nextLine();
            input.nextLine();
            if(boolCode.equals("Y")){
                return true;
            }else if(boolCode.equals("N")){
                return false;
            }else{
                System.out.print("Invalid Input.\n");
            }
        }
        return true;
    }

    private static double getUserHeight(){
        boolean validInput = false;
        String heightCode;
        while(!validInput) {
            System.out.print("Enter your height in inches: ");
            heightCode = input.nextLine();
            input.nextLine();
            if (Double.valueOf(heightCode) > 0) {
                return Double.valueOf(heightCode);
            } else {
                System.out.print("Invalid Input.\n");
            }
        }
        return 1.0;
    }

    private static double getUserWeight(){
        boolean validInput = false;
        String weightCode;
        while(!validInput) {
            System.out.print("Enter your weight in pounds: ");
            weightCode = input.nextLine();
            input.nextLine();
            if (Double.valueOf(weightCode) > 0) {
                return Double.valueOf(weightCode);
            } else {
                System.out.print("Invalid Input.\n");
            }
        }
        return 1.0;
    }

}
