import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;

public class TaskList {
    private String fileName;
    private ArrayList<TaskItem> listOfItems = new ArrayList<TaskItem>();

    public TaskList(){

    }
    public String getFileName(){
        return fileName;
    }
    public int checkIndex(int[] myCheckArray, int selectItem){
        int check = 0;
        for(int i = 0; i < myCheckArray.length; i++){
            if (selectItem == myCheckArray[i]) {
                check = 1;
                break;
            }
        }
        if(0 <= selectItem && selectItem <= getSizeOfList() - 1 && check == 1){
            return 0;
        }else {
            return 1;
        }
    }
    public void printList(){
        System.out.print("Current Tasks\n-------------\n\n");
        TaskItem currentItem;
        for(int i = 0; i < listOfItems.size(); i++){
            currentItem = listOfItems.get(i);
            System.out.print(i + ") ");
            currentItem.printItem();
        }
        System.out.print("\n");
    }
    public void addItem(String title, String desc, String date, int isComplete){
        TaskItem newItem = new TaskItem();
        newItem.setTitle(title);
        newItem.setDesc(desc);
        newItem.setDate(date);
        newItem.setIsComplete(isComplete);
        listOfItems.add(newItem);
    }
    public void editItem(String title, String desc, String date, int selectItem){
        TaskItem currentItem = listOfItems.get(selectItem);
        currentItem.setTitle(title);
        currentItem.setDesc(desc);
        currentItem.setDate(date);
        listOfItems.set(selectItem, currentItem);
    }
    public int loadList(String myFileName){
        String line, exit = "~";
        int isFile = 2;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("listData.txt"))){
            while((line = bufferedReader.readLine()) != null){
                if(isFile == 0){
                    isFile = 1;
                }
                if(line.split("~").length != 0 && myFileName.equals(line.split("~")[0])){
                    isFile = 0;
                }
                if(line.split("~").length != 0 && isFile == 1 && !exit.equals(line.split("~")[0])){
                    addItem(line.split(";")[0], line.split(";")[1], line.split(";")[2], Integer.parseInt(line.split(";")[3]));
                }else if(line.split("~").length != 0 && isFile == 1 && exit.equals(line.split("~")[0])){
                    break;
                }
            }
        } catch(FileNotFoundException ex){
            System.out.println("Unable to find data file");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return isFile;
    }
    public void deleteItem(int selectItem){
        listOfItems.remove(selectItem);
    }
    public int getSizeOfList(){
        return listOfItems.size();
    }
    public TaskItem getItem(int selectItem){
        return listOfItems.get(selectItem);
    }
    public void completeItem(int selectItem){
        TaskItem currentItem = new TaskItem();
        currentItem = listOfItems.get(selectItem);
        currentItem.setIsComplete(1);
        listOfItems.set(selectItem, currentItem);
    }
    public void decompleteItem(int selectItem){
        TaskItem currentItem = new TaskItem();
        currentItem = listOfItems.get(selectItem);
        currentItem.setIsComplete(0);
        listOfItems.set(selectItem, currentItem);
    }
    // it isn't required in the project rubric, and I didn't want to abuse the no late penalty that was
    // granted to me any further so i didn't add replacement of old lists.
    // (i.e. if list "g" already exists it will not be replaced if a new list "g" is created)
    // this means that since new lists of the same name will always be lower, older lists of the same name always take priority
    public void saveList(String fileNameI){
        fileName = fileNameI;
        TaskItem currentItem = new TaskItem();
        try(FileWriter fileWriter = new FileWriter("listData.txt", true)){
            Formatter f = new Formatter(fileWriter);
            f.format("%s~~%n", fileName);
            for(int i = 0; i < listOfItems.size(); i++){
                currentItem = listOfItems.get(i);
                f.format("%s;%s;%s;%d;~~%n", currentItem.getTitle(), currentItem.getDesc(), currentItem.getDate(), currentItem.getIsComplete());
            }
            f.format("~~%n");
        } catch(FileNotFoundException ex){
            System.out.println("Unable to find file");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}