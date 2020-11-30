import java.util.Scanner;

public class ContactApp {
    public Scanner input = new Scanner(System.in);
    public ContactApp(){
        int mainMenuCode = 0;
        String convert;

        while(mainMenuCode != 3){
            System.out.print("\nMain Menu\n---------\n\n1) create a new list\n2) load an existing list\n3) quit\n\n");
            convert = input.nextLine();
            mainMenuCode = Integer.parseInt(convert);
            if(mainMenuCode == 1){
                createContactList();
            }if(mainMenuCode == 2){
                loadContactList();
            }
        }
    }
    public void createContactList(){
        ContactList myList = new ContactList();
        System.out.print("A new contact list has been created\n");
        contactListMenu(myList);
    }
    public void loadContactList(){
        String myFileName;
        int isFile;
        System.out.print("Enter the list name to load: ");
        myFileName = input.nextLine();
        ContactList loadMyList = new ContactList();
        isFile = loadMyList.loadList(myFileName);
        if(isFile == 1){
            contactListMenu(loadMyList);
        }else{
            System.out.println("Could not find that list :(");
        }
    }
    public void contactListMenu(ContactList myList){
        String fName = "", lName = "", pNumber = "", email = "", convert;
        ContactItem currentItem, newItem;
        Scanner input = new Scanner(System.in);
        int menuCode = 0, selectItem, inputsValid = 0, myCheck, notFirstLoop = 0, emailCheck = 0, pNumberCheck = 0;
        int[] myCheckArray;
        while (menuCode != 6){
            System.out.print("\nList Operation Menu\n---------\n\n1) view the list\n2) add an item\n3) edit an item\n" +
                    "4) remove an item\n" + "5) save the current list\n6) quit to the main menu\n\n");
            convert = input.nextLine();
            menuCode = Integer.parseInt(convert);
            if(menuCode == 1){
                myList.printList();
            }else if(menuCode == 2){
                newItem = new ContactItem();
                while(inputsValid == 0) {
                    if(notFirstLoop == 1){
                        System.out.println("There were errors with some of your inputs, please enter valid information.");
                    }
                    System.out.print("First Name: ");
                    fName = input.nextLine();
                    System.out.print("Last Name: ");
                    lName = input.nextLine();
                    System.out.print("Phone Number (xxx-xxx-xxxx): ");
                    pNumber = input.nextLine();
                    System.out.print("Email Address (x@y.z): ");
                    email = input.nextLine();
                    if(myList.inputCheck(fName, lName, pNumber, email) == 0){
                        if(email.equals("") || newItem.emailCheck(email) == 0){
                            emailCheck = 1;
                        }
                        if(pNumber.equals("") || newItem.pNumberCheck(pNumber) == 0){
                            pNumberCheck = 1;
                        }
                        if(emailCheck == 1 && pNumberCheck == 1){
                            inputsValid = 1;
                        }
                    }
                    notFirstLoop = 1;
                    emailCheck = 0;
                    pNumberCheck = 0;
                }
                inputsValid = 0;
                notFirstLoop = 0;
                myList.addItem(fName, lName, pNumber, email);
            }else if(menuCode == 3){
                myList.printList();
                myCheckArray = new int[myList.getSizeOfList()];
                System.out.print("Which contact will you edit? ");
                convert = input.nextLine();
                selectItem = Integer.parseInt(convert);
                for(int i = 0; i < myList.getSizeOfList(); i++){
                    myCheckArray[i] = i;
                }
                myCheck = myList.checkIndex(myCheckArray, selectItem);
                while(myCheck == 1){
                    System.out.print("Please enter a valid index.\n");
                    convert = input.nextLine();
                    selectItem = Integer.parseInt(convert);
                    myCheck = myList.checkIndex(myCheckArray, selectItem);
                }
                currentItem = myList.getItem(selectItem);
                while(inputsValid == 0) {
                    if(notFirstLoop == 1){
                        System.out.println("There were errors with some of your inputs, please enter valid information.");
                    }
                    System.out.print("First Name: ");
                    fName = input.nextLine();
                    System.out.print("Last Name: ");
                    lName = input.nextLine();
                    System.out.print("Phone Number (xxx-xxx-xxxx): ");
                    pNumber = input.nextLine();
                    System.out.print("Email Address (x@y.z): ");
                    email = input.nextLine();
                    if(myList.inputCheck(fName, lName, pNumber, email) == 0){
                        if(email.equals("") || currentItem.emailCheck(email) == 0){
                            emailCheck = 1;
                        }
                        if(pNumber.equals("") || currentItem.pNumberCheck(pNumber) == 0){
                            pNumberCheck = 1;
                        }
                        if(emailCheck == 1 && pNumberCheck == 1){
                            inputsValid = 1;
                        }
                    }
                    notFirstLoop = 1;
                    emailCheck = 0;
                    pNumberCheck = 0;
                }
                inputsValid = 0;
                notFirstLoop = 0;
                myList.editItem(fName, lName, pNumber, email, selectItem);
            }else if(menuCode == 4){
                myList.printList();
                myCheckArray = new int[myList.getSizeOfList()];
                System.out.print("Which contact will you remove? ");
                convert = input.nextLine();
                selectItem = Integer.parseInt(convert);
                for(int i = 0; i < myList.getSizeOfList(); i++){
                    myCheckArray[i] = i;
                }
                myCheck = myList.checkIndex(myCheckArray, selectItem);
                while(myCheck == 1){
                    System.out.print("Please enter a valid index.\n");
                    convert = input.nextLine();
                    selectItem = Integer.parseInt(convert);
                    myCheck = myList.checkIndex(myCheckArray, selectItem);
                }
                myList.deleteItem(selectItem);
            }else if(menuCode == 5){
                String fileName;
                System.out.print("Enter a name to save this list as: ");
                fileName = input.nextLine();
                if(myList.listIsEmpty() != 0){
                    myList.saveList(fileName);
                }else{
                    System.out.println("This list is empty.");
                }
            }
        }
    }
}
