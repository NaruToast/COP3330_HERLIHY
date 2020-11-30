import org.junit.Test;
import static org.junit.Assert.*;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        ContactList testList = new ContactList();
        assertEquals(0, testList.getSizeOfList());
        testList.addItem("a", "b", "123-456-7890", "x@y.z");
        assertEquals(1, testList.getSizeOfList());
    }
    @Test
    public void removingItemsDecreasesSize(){
        ContactList testList = new ContactList();
        testList.addItem("a", "b", "123-456-7890", "x@y.z");
        assertEquals(1, testList.getSizeOfList());
        testList.deleteItem(0);
        assertEquals(0, testList.getSizeOfList());
    }
    // The two following tests cover all tests below (since a single function is used for verification):
    // editingItemsFailsWithAllBlankValues(), editingSucceedsWithBlankFirstName(), editingSucceedsWithBlankLastName()
    // editingSucceedsWithBlankPhone(), editingSucceedsWithNonBlankValues()
    @Test
    public void inputCheckFailsWithAllBlankValues(){
        ContactList testList = new ContactList();
        assertEquals(1, testList.inputCheck("", "", "", ""));
    }
    @Test
    public void inputCheckSucceedsWithNotAllBlankValues(){
        ContactList testList = new ContactList();
        assertEquals(0, testList.inputCheck("1", "", "", ""));
        assertEquals(0, testList.inputCheck("", "2", "", ""));
        assertEquals(0, testList.inputCheck("", "", "3", ""));
        assertEquals(0, testList.inputCheck("", "", "", "4"));
    }
    // The two following tests cover all tests below (since a single function is used for verification):
    // editingItemFailsWithInvalidIndex(), editingItemSucceedsWithValidIndex(),  deletingItemFailsWithInvalidIndex(),
    // deletingItemSucceedsWithValidIndex()
    @Test
    public void indexCheckFailsWithInvalidIndex(){
        ContactList testList = new ContactList();
        int[] myCheckArray = {0, 1};
        testList.addItem("a", "b", "123-456-7890", "x@y.z");
        testList.addItem("a", "b", "123-456-7890", "x@y.z");
        assertEquals(1, testList.checkIndex(myCheckArray, 2));
    }
    @Test
    public void indexCheckSucceedsWithValidIndex(){
        ContactList testList = new ContactList();
        int[] myCheckArray = {0, 1};
        testList.addItem("a", "b", "123-456-7890", "x@y.z");
        testList.addItem("a", "b", "123-456-7890", "x@y.z");
        assertEquals(0, testList.checkIndex(myCheckArray, 1));
    }
    @Test
    public void newTaskListIsEmpty(){
        ContactList testList = new ContactList();
        assertEquals(0, testList.listIsEmpty());
    }
    @Test
    public void savedListCanBeLoaded(){
        ContactList testList = new ContactList(), testList2 = new ContactList();
        ContactItem testItem = new ContactItem(), testItem2 = new ContactItem();
        testList.addItem("a", "b", "123-456-7890", "x@y.z");
        testList.saveList("A");
        testList2.loadList("A");
        assertEquals(testItem.getFName(), testItem2.getFName());
        assertEquals(testItem.getLName(), testItem2.getLName());
        assertEquals(testItem.getPNumber(), testItem2.getPNumber());
        assertEquals(testItem.getEmail(), testItem2.getEmail());
    }
    // covers all values so that multiple tests arent required
    @Test
    public void editingTaskItemChangesValues(){
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem();
        testItem.setFName("b");
        testItem.setLName("b");
        testItem.setPNumber("098-765-4321");
        testItem.setEmail("z@y.x");
        testList.addItem("b", "b", "098-765-4321", "z@y.x");
        testList.editItem("a", "b", "123-456-7890", "x@y.z", 0);
        assertNotEquals(testItem, testList.getItem(0));
    }
}
