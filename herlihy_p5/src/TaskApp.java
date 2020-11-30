import java.util.Scanner;

public class TaskApp {
    public Scanner input = new Scanner(System.in);
    public TaskApp(){
        int mainMenuCode = 0;
        String convert;

        while(mainMenuCode != 3){
            System.out.print("\nMain Menu\n---------\n\n1) create a new list\n2) load an existing list\n3) quit\n\n");
            convert = input.nextLine();
            mainMenuCode = Integer.parseInt(convert);
            if(mainMenuCode == 1){
                createTaskList();
            }if(mainMenuCode == 2){
                loadTaskList();
            }
        }
    }
    public void createTaskList(){
        TaskList myList = new TaskList();
        System.out.print("A new task list has been created\n");
        taskListMenu(myList);
    }
    public void loadTaskList(){
        String myFileName;
        int isFile;
        System.out.print("Enter the list name to load: ");
        myFileName = input.nextLine();
        TaskList loadMyList = new TaskList();
        isFile = loadMyList.loadList(myFileName);
        if(isFile == 1){
            taskListMenu(loadMyList);
        }else{
            System.out.println("Could not find that list :(");
        }
    }
    public void taskListMenu(TaskList myList){
        String title, date, desc, convert;
        TaskItem myItem = new TaskItem(), currentItem, newItem;
        Scanner input = new Scanner(System.in);
        int menuCode = 0, selectItem, count, myCheck;
        int[] myCheckArray;
        while (menuCode != 8){
            System.out.print("List Operation Menu\n---------\n\n1) view the list\n2) add an item\n3) edit an item\n" +
                    "4) remove an item\n5) mark an item as completed\n6) unmark an item as completed\n" +
                    "7) save the current list\n8) quit to the main menu\n\n");
            convert = input.nextLine();
            menuCode = Integer.parseInt(convert);
            if(menuCode == 1){
                myList.printList();
            }else if(menuCode == 2){
                newItem = new TaskItem();
                System.out.print("Enter a title: ");
                title = input.nextLine();
                while (newItem.titleCheck(title) != 0) {
                    System.out.print("Please enter a valid title: ");
                    title = input.nextLine();
                }
                System.out.print("Enter a description: ");
                desc = input.nextLine();
                System.out.print("Enter a task due date (YYYY-MM-DD): ");
                date = input.nextLine();
                while (newItem.dateCheck(date) != 0) {
                    System.out.print("Please enter a valid date: ");
                    date = input.nextLine();
                }
                myList.addItem(title, desc, date, 0);
            }else if(menuCode == 3){
                myList.printList();
                myCheckArray = new int[myList.getSizeOfList()];
                System.out.print("Which task will you edit? ");
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
                System.out.print("Enter a new title for task " + selectItem + ": ");
                title = input.nextLine();
                while (myItem.titleCheck(title) != 0) {
                    System.out.print("Please enter a valid title: ");
                    title = input.nextLine();
                }
                System.out.print("Enter a new description for task " + selectItem + ": ");
                desc = input.nextLine();
                System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + selectItem + ": ");
                date = input.nextLine();
                while (myItem.dateCheck(date) != 0) {
                    System.out.print("Please enter a valid date: ");
                    date = input.nextLine();
                }
                myList.editItem(title, desc, date, selectItem);
            }else if(menuCode == 4){
                myList.printList();
                myCheckArray = new int[myList.getSizeOfList()];
                System.out.print("Which task will you remove? ");
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
                count = 0;
                myCheckArray = new int[myList.getSizeOfList()];
                System.out.print("Uncompleted Tasks\n-------------\n\n");
                for(int i = 0; i < myList.getSizeOfList(); i++){
                    currentItem = myList.getItem(i);
                    if(currentItem.getIsComplete() == 0) {
                        System.out.print(i + ") ");
                        currentItem.printItem();
                        myCheckArray[count] = i;
                        count++;
                    }
                }
                System.out.print("\nWhich task will you mark as completed? ");
                convert = input.nextLine();
                selectItem = Integer.parseInt(convert);
                myCheck = myList.checkIndex(myCheckArray, selectItem);
                while(myCheck == 1){
                    System.out.print("Please enter a valid index.\n");
                    convert = input.nextLine();
                    selectItem = Integer.parseInt(convert);
                    myCheck = myList.checkIndex(myCheckArray, selectItem);
                }
                myList.completeItem(selectItem);
            }else if(menuCode == 6){
                count = 0;
                myCheckArray = new int[myList.getSizeOfList()];
                System.out.print("Completed Tasks\n-------------\n\n");
                for(int i = 0; i < myList.getSizeOfList(); i++){
                    currentItem = myList.getItem(i);
                    if(currentItem.getIsComplete() == 1) {
                        System.out.print(i + ") ");
                        currentItem.printItem();
                        myCheckArray[count] = i;
                        count++;
                    }
                }
                System.out.print("\nWhich task will you unmark as completed? ");
                convert = input.nextLine();
                selectItem = Integer.parseInt(convert);
                myCheck = myList.checkIndex(myCheckArray, selectItem);
                while(myCheck == 1){
                    System.out.print("Please enter a valid index.\n");
                    convert = input.nextLine();
                    selectItem = Integer.parseInt(convert);
                    myCheck = myList.checkIndex(myCheckArray, selectItem);
                }
                myList.decompleteItem(selectItem);
            }else if(menuCode == 7){
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
