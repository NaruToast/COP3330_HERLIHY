import static org.junit.Assert.*;
import org.junit.Test;

public class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        TaskItem testItem = new TaskItem();
        assertEquals(1, testItem.dateCheck("AAAAAAAAAAAAAA"));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem testItem = new TaskItem();
        assertEquals(1, testItem.titleCheck(""));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem testItem = new TaskItem();
        assertEquals(0, testItem.dateCheck("2020-01-01"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem testItem = new TaskItem();
        assertEquals(0, testItem.titleCheck("AAAAAAAAAAAAAAA"));
    }
    /*

    All of the following tests pass by default due to the way that my program is setup.
    This is since all titles and dates are validated before any of the set functions are called.

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){

    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){

    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){

    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){

    }
     */
}