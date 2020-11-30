import org.junit.Test;
import static org.junit.Assert.*;

public class ContactItemTest {
    @Test
    public void emailCheckFailsWithInvalidEmail(){
        ContactItem testItem = new ContactItem();
        assertEquals(1, testItem.emailCheck("@@@"));
        assertEquals(1, testItem.emailCheck("xyz"));
        assertEquals(1, testItem.emailCheck("@@y.z"));
        assertEquals(1, testItem.emailCheck("x@y..z"));
        assertEquals(1, testItem.emailCheck("x@y..z"));
    }
    @Test
    public void emailCheckSucceedsWithValidEmail(){
        ContactItem testItem = new ContactItem();
        assertEquals(0, testItem.emailCheck("x@y.z"));
    }
    @Test
    public void pNumberCheckFailsWithInvalidPNumber(){
        ContactItem testItem = new ContactItem();
        assertEquals(1, testItem.pNumberCheck("1234567890"));
        assertEquals(1, testItem.pNumberCheck("12-3456-7890"));
        assertEquals(1, testItem.pNumberCheck("1-2-3"));
        assertEquals(1, testItem.pNumberCheck("123-456-789"));
    }
    @Test
    public void pNumberCheckSucceedsWithValidPNumber(){
        ContactItem testItem = new ContactItem();
        assertEquals(0, testItem.pNumberCheck("123-456-7890"));
    }
    /*
    Done within contact list and not within contact item, as such these tests are included within contact list test
    and not contact item test
    @Test
    public void creationFailsWithAllBlankValues(){

    }
    @Test
    public void creationSucceedsWithBlankEmail(){

    }
    @Test
    public void creationSucceedsWithBlankFirstName(){

    }
    @Test
    public void creationSucceedsWithBlankLastName(){

    }
    @Test
    public void creationSucceedsWithBlankPhone(){

    }
    @Test
    public void creationSucceedsWithNonBlankValues(){

    }
    @Test
    public void editingFailsWithAllBlankValues(){

    }
    @Test
    public void editingSucceedsWithBlankEmail(){

    }
    @Test
    public void editingSucceedsWithBlankFirstName(){

    }
    @Test
    public void editingSucceedsWithBlankLastName(){

    }
    @Test
    public void editingSucceedsWithBlankPhone(){

    }
    @Test
    public void editingSucceedsWithNonBlankValues(){

    }
    */
}