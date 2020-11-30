import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;

public class ContactList implements List{
    private String fileName;
    private ArrayList<ContactItem> listOfItems = new ArrayList<ContactItem>();
    public ContactList(){

    }
    @Override
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
    @Override
    public void printList() {
        System.out.print("Current Contacts\n-------------\n\n");
        ContactItem currentItem;
        for(int i = 0; i < listOfItems.size(); i++){
            currentItem = listOfItems.get(i);
            System.out.print(i + ") ");
            currentItem.printItem();
        }
        System.out.print("\n");
    }
    void addItem(String fName, String lName, String pNumber, String email) {
        ContactItem newItem = new ContactItem();
        newItem.setFName(fName);
        newItem.setLName(lName);
        newItem.setPNumber(pNumber);
        newItem.setEmail(email);
        listOfItems.add(newItem);
    }
    public void editItem(String fName, String lName, String pNumber, String email, int selectItem) {
        ContactItem currentItem = listOfItems.get(selectItem);
        currentItem.setFName(fName);
        currentItem.setLName(lName);
        currentItem.setPNumber(pNumber);
        currentItem.setEmail(email);
        listOfItems.set(selectItem, currentItem);
    }
    @Override
    public int loadList(String myFileName) {
        String line, exit = "~";
        int isFile = 2;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("contactData.txt"))){
            while((line = bufferedReader.readLine()) != null){
                if(isFile == 0){
                    isFile = 1;
                }
                if(line.split("~").length != 0 && myFileName.equals(line.split("~")[0])){
                    isFile = 0;
                }
                if(line.split("~").length != 0 && isFile == 1 && !exit.equals(line.split("~")[0])){
                    addItem(line.split(";")[0], line.split(";")[1], line.split(";")[2], line.split(";")[3]);
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
    @Override
    public void deleteItem(int selectItem) {
        listOfItems.remove(selectItem);
    }
    @Override
    public String getFileName() {
        return fileName;
    }
    @Override
    public int getSizeOfList(){
        return listOfItems.size();
    }
    public ContactItem getItem(int selectItem) {
        return listOfItems.get(selectItem);
    }
    @Override
    public void saveList(String fileNameI) {
        fileName = fileNameI;
        ContactItem currentItem = new ContactItem();
        try(FileWriter fileWriter = new FileWriter("contactData.txt", true)){
            Formatter f = new Formatter(fileWriter);
            f.format("%s~~%n", fileName);
            for(int i = 0; i < listOfItems.size(); i++){
                currentItem = listOfItems.get(i);
                f.format("%s;%s;%s;%s;~~%n", currentItem.getFName(), currentItem.getLName(), currentItem.getPNumber(), currentItem.getEmail());
            }
            f.format("~~%n");
        } catch(FileNotFoundException ex){
            System.out.println("Unable to find file");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public int inputCheck(String fName, String lName, String pNumber, String email){
        if(fName.equals("") && lName.equals("") && pNumber.equals("") && email.equals("")){
            return 1;
        }
        return 0;
    }
    public int listIsEmpty(){
        if(getSizeOfList() == 0){
            return 0;
        }else{
            return 1;
        }
    }
}
