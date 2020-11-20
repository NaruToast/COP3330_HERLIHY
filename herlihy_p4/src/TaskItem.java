import java.util.Scanner;

public class TaskItem {
    private String title, desc, date;
    private int isComplete = 0;

    public TaskItem() {

    }
    public void printItem() {
        if (isComplete == 0) {
            System.out.print("[" + date + "] " + title + ": " + desc + "\n");
        } else {
            System.out.print(" *** [" + date + "] " + title + ": " + desc + "\n");
        }
    }
    public void setIsComplete(int myIsComplete) {
        isComplete = myIsComplete;
    }
    public void setTitle(String myTitle) {
        title = myTitle;
    }
    public void setDesc(String myDesc) {
        desc = myDesc;
    }
    public void setDate(String myDate) {
        date = myDate;
    }
    public String getTitle(){
        return title;
    }
    public String getDate() {
        return date;
    }
    public String getDesc() {
        return desc;
    }
    public int getIsComplete(){
        return isComplete;
    }
    public int titleCheck(String title) {
        if (title.equals("")) {
            return 1;
        } else {
            return 0;
        }
    }
    public int dateCheck(String myDate){
        char buffer;
        if(myDate.length() != 10){
            System.out.println("String length invalid");
            return 1;
        }
        for(int i = 0; i < myDate.length(); i++){
            if(i <= 3){
                if(isInt(myDate.charAt(i)) != 1){
                    System.out.println("Char at position " + i + " is not an int");
                    return 1;
                }
            }if(i == 4){
                buffer = myDate.charAt(i);
                if(buffer != '-'){
                    System.out.println("Char at position " + i + " is not a -");
                    return 1;
                }
            }if(4 < i && i <= 6){
                if(isInt(myDate.charAt(i)) != 1){
                    System.out.println("Char at position " + i + " is not an int");
                    return 1;
                }
            }if(i == 7){
                buffer = myDate.charAt(i);
                if(buffer != '-'){
                    System.out.println("Char at position " + i + " is not a -");
                    return 1;
                }
            }if(7 < i){
                if(isInt(myDate.charAt(i)) != 1){
                    System.out.println("Char at position " + i + " is not an int");
                    return 1;
                }
            }
        }
        return 0;
    }
    private int isInt(char a){
        if(a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8' || a =='9'){
            return 1;
        }else{
            return 0;
        }
    }
}