import org.junit.Test;
import static org.junit.Assert.*;

public class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList testList = new TaskList();
        assertEquals(0, testList.getSizeOfList());
        testList.addItem("a", "a", "2020-01-01", 0);
        assertEquals(1, testList.getSizeOfList());
    }
    @Test
    public void completingTaskItemChangesStatus(){
        TaskList testList = new TaskList();
        TaskItem testItem = new TaskItem();
        testList.addItem("a", "a", "2020-01-01", 0);
        testItem = testList.getItem(0);
        assertEquals(0, testItem.getIsComplete());
        testItem.setIsComplete(1);
        assertEquals(1, testItem.getIsComplete());
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList testList = new TaskList();
        int[] myCheckArray = {0, 1};
        testList.addItem("a", "a", "2020-01-01", 0);
        testList.addItem("b", "b", "2020-01-01", 0);
        assertEquals(1, testList.checkIndex(myCheckArray, 2));
    }
    @Test
    public void editingTaskItemChangesValues(){
        TaskList testList = new TaskList();
        TaskItem testItem = new TaskItem();
        testItem.setTitle("a");
        testItem.setDesc("a");
        testItem.setDate("2020-01-01");
        testItem.setIsComplete(0);
        testList.addItem("a", "a", "2020-01-01", 0);
        testList.editItem("b", "b", "2021-02-02", 0);
        assertNotEquals(testItem, testList.getItem(0));
    }
    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList testList = new TaskList();
        TaskItem testItem = new TaskItem();
        testItem.setTitle("a");
        testItem.setDesc("a");
        testItem.setDate("2020-01-01");
        testItem.setIsComplete(0);
        testList.addItem("a", "a", "2020-01-01", 0);
        testList.editItem("a", "b", "2020-01-01", 0);
        assertNotEquals(testItem, testList.getItem(0));
    }
    @Test
    public void editingTaskFailsWithInvalidIndex(){
        TaskList testList = new TaskList();
        int[] myCheckArray = {0};
        testList.addItem("a", "a", "2020-01-01", 0);
        assertEquals(1, testList.checkIndex(myCheckArray, 2));
    }
    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList testList = new TaskList();
        TaskItem testItem = new TaskItem();
        testItem.setTitle("a");
        testItem.setDesc("a");
        testItem.setDate("2020-01-01");
        testItem.setIsComplete(0);
        testList.addItem("a", "a", "2020-01-01", 0);
        testList.editItem("a", "a", "2021-02-02", 0);
        assertNotEquals(testItem, testList.getItem(0));
    }
    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList testList = new TaskList();
        TaskItem testItem = new TaskItem();
        testItem.setTitle("a");
        testItem.setDesc("a");
        testItem.setDate("2020-01-01");
        testItem.setIsComplete(0);
        testList.addItem("a", "a", "2020-01-01", 0);
        testList.editItem("b", "a", "2020-01-01", 0);
        assertNotEquals(testItem, testList.getItem(0));
    }
    /*
    The following tests are for functions that are not present in my program as they have no use.
    I have a getItem function, however it is only called under circumstances where it is parallel with getSizeOfList
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){

    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){

    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){

    }
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){

    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){

    }
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){

    }
     */
    @Test
    public void newTaskListIsEmpty(){
        TaskList testList = new TaskList();
        assertEquals(0, testList.getSizeOfList());
    }
    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList testList = new TaskList();
        testList.addItem("a", "a", "2020-01-01", 0);
        testList.addItem("b", "b", "2020-01-01", 0);
        assertEquals(2, testList.getSizeOfList());
        testList.deleteItem(1);
        assertEquals(1, testList.getSizeOfList());
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList testList = new TaskList();
        int[] myCheckArray = {0};
        testList.addItem("a", "a", "2020-01-01", 0);
        assertEquals(1, testList.checkIndex(myCheckArray, 2));
    }
    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList testList = new TaskList(), testList2 = new TaskList();
        TaskItem testItem = new TaskItem(), testItem2 = new TaskItem();
        testList.addItem("a", "a", "2020-01-01", 0);
        testList.saveList("A");
        testList2.loadList("A");
        assertEquals(testItem.getTitle(), testItem2.getTitle());
        assertEquals(testItem.getDesc(), testItem2.getDesc());
        assertEquals(testItem.getDate(), testItem2.getDate());
    }
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList testList = new TaskList();
        TaskItem testItem = new TaskItem(), testItem2 = new TaskItem();
        testList.addItem("a", "a", "2020-01-01", 1);
        testItem.setIsComplete(1);
        testItem2 = testList.getItem(0);
        assertEquals(testItem.getIsComplete(), testItem2.getIsComplete());
        testList.decompleteItem(0);
        assertNotEquals(testItem.getIsComplete(), testItem2.getIsComplete());
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList testList = new TaskList();
        int[] myCheckArray = {0};
        testList.addItem("a", "a", "2020-01-01", 0);
        assertEquals(1, testList.checkIndex(myCheckArray, 2));
    }
}