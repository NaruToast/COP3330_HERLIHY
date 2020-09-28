import org.junit.Assert;
import org.junit.Test;

public class BodyMassIndexTest {
    @Test
    public void TestBMIScore(){
        BodyMassIndex bmi = new BodyMassIndex(72, 115);
        String actual = "", expected = "";
        double temp = bmi.score()*1000;
        long temp2 = Math.round(temp);
        actual += (double)temp2/1000;
        expected += 15.595;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestBMICategoryUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(72, 115);
        String actual = "", expected = "";
        actual += bmi.findCat(15.595);
        expected += "Underweight";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestBMICategoryNormalWeight(){
        BodyMassIndex bmi = new BodyMassIndex(66, 150);
        String actual = "", expected = "";
        actual += bmi.findCat(24.208);
        expected += "Normal weight";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestBMICategoryOverweight(){
        BodyMassIndex bmi = new BodyMassIndex(68, 180);
        String actual = "", expected = "";
        actual += bmi.findCat(27.366);
        expected += "Overweight";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestBMICategoryObese() {
        BodyMassIndex bmi = new BodyMassIndex(70, 300);
        String actual = "", expected = "";
        actual += bmi.findCat(43.041);
        expected += "Obese";
        Assert.assertEquals(expected, actual);
    }
}
