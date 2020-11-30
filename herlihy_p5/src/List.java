import java.util.ArrayList;

public interface List {
    public int checkIndex(int[] myCheckArray, int selectItem);
    public void printList();
    public int loadList(String myFileName);
    public int getSizeOfList();
    public void saveList(String fileNameI);
    public void deleteItem(int selectItem);
    public String getFileName();
}
