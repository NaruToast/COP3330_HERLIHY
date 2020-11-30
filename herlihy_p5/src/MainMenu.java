import java.util.Scanner;

// There is an issue with saving items under the same name.
// Since it is a permanent saving system, whichever item was created first has priority and will
// always be the only item to show up. I don't know how to rewrite files that specifically and as
// such I didn't succeed in fixing that issue.
public class MainMenu {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        int mainMenuCode = 0;
        String convert;

        while(mainMenuCode != 3){
            System.out.print("Select Your Application\n-----------------------\n1) task list \n2) contact list \n3) quit\n\n");
            convert = input.nextLine();
            mainMenuCode = Integer.parseInt(convert);
            if(mainMenuCode == 1){
                new TaskApp();
            }if(mainMenuCode == 2){
                new ContactApp();
            }
        }
    }
}
