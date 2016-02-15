import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import nastassia.com.model.ListOfLists;
import nastassia.com.model.Item;
import nastassia.com.model.TodoList;

import static org.junit.Assert.*;

public class TestSet {
    
    private TodoList testToDoList = new TodoList("One");
    public TestSet() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void deletedOneOfThreeComplex(){
        TodoList todoList = new TodoList();
        Item itemList = new Item("One");
        Item itemList1 = new Item("Two");
        Item itemList2 = new Item("Three");
        todoList.addItem(itemList);
        todoList.addItem(itemList1);
        todoList.addItem(itemList2);
        todoList.removeItemByName("Two");
        assertEquals(null, todoList.getItemByName("Two"));
    }
    
    @Test
    public void setNameOfList(){
        ListOfLists groupTodoLists = new ListOfLists();
        TodoList todoList = new TodoList();
        todoList.setName("One");
        groupTodoLists.add(todoList);
        assertEquals(groupTodoLists.getTodoByName("One"), todoList);
    }
    
    @Test
    public void changeStatusToComplete() {
        Item itemList = new Item();
        itemList.setCompleted(true);
        assertEquals(true, itemList.isCompleted());
    }
    
    @Test
    public void addItemToToDoList(){
        TodoList todoList = new TodoList();
        Item item = new Item("six");
        todoList.addItem(item);
        assertEquals(todoList.getItemByName("six"), item);
    }
    
    @Test
    public void findByNameToDo(){
        TodoList todoList = new TodoList();
        Item item = new Item("seven");
        todoList.addItem(item);
        assertEquals(todoList.getItemByName("seven"), item);
    }    
    
    @Test
    public void nameAndIncomplete(){
        TodoList todoList = new TodoList("test");
        Item item = new Item("eight");
        todoList.addItem(item);
        assertEquals(todoList.getNameWithNumber(), "test (1)");
    }   
    
    @Test
    public void nameAndIncompletedComplex(){
        TodoList todoList = new TodoList("test");
        Item item = new Item("nine");
        todoList.addItem(item);
        Item item1 = new Item("nine2");
        todoList.addItem(item1);
        assertEquals(todoList.getNameWithNumber(), "test (2)");
    }
    
    @Test
    public void nameAndIncompletedSuperComplex(){
        TodoList todoList = new TodoList("test");
        Item item = new Item("ten");
        item.setCompleted(true);
        todoList.addItem(item);
        Item item1 = new Item("ten2");
        todoList.addItem(item1);
        assertEquals(todoList.getNameWithNumber(), "test (1)");
    }
    
    @Test
    public void countInToDoList(){
        TodoList todoList = new TodoList();
        todoList.addItem(new Item("one"));
        todoList.addItem(new Item("two"));
        todoList.addItem(new Item("three"));
        todoList.addItem(new Item("four"));
        assertEquals(4, todoList.getCount());
    }
    
    @Test
    public void countInToDoListMore(){
        TodoList todoList = new TodoList();
        todoList.addItem(new Item("one"));
        todoList.addItem(new Item("two"));
        todoList.addItem(new Item("three"));
        todoList.addItem(new Item("four"));
        todoList.addItem(new Item("five"));
        assertEquals(5, todoList.getCount());
    }
    
    @Test
    public void changeItemName() {
        Item itemList = new Item();
        itemList.setName("Five");
        assertEquals("Five", itemList.getName());
    }
    
    @Test
    public void removeSpacesBeforeItemName() {
        Item itemList = new Item();
        itemList.setName("       Four");
        assertEquals("Four", itemList.getName());
    }
    
    @Test
    public void changeName() {
        TodoList todoList = new TodoList();
        todoList.setName("Two");
        assertEquals("Two", todoList.getName());
    }
    
    @Test
    public void removeSpacesBeforeName() {
        TodoList todoList = new TodoList();
        todoList.setName("       Three");
        assertEquals("Three", todoList.getName());
    }
    
    @Test
    public void changeStatusToIncomplete() {
        Item itemList = new Item();
        itemList.setCompleted(false);
        assertEquals(false, itemList.isCompleted());
    }    
    
    @Test
    public void getIncompleted(){
        TodoList todoList = new TodoList();
        Item item = new Item("eleven");
        todoList.addItem(item);
        assertEquals(1, todoList.getIncompletedItems());
    }
    
    @Test
    public void getIncompletedCompltex(){
        TodoList todoList = new TodoList();
        todoList.addItem(new Item("twelve"));
        todoList.addItem(new Item("thirteen"));
        assertEquals(2, todoList.getIncompletedItems());
    }
    
    @Test
    public void getIncompletedSuperComplex(){
        TodoList todoList = new TodoList();
        todoList.addItem(new Item("one"));
        todoList.addItem(new Item("two"));
        Item item = new Item("three");
        item.setCompleted(true);
        todoList.addItem(item);
        assertEquals(2, todoList.getIncompletedItems());
    }
    
    @Test
    public void duplicates(){
        TodoList todoList = new TodoList();
        Item item = new Item("one");
        todoList.addItem(item);
        Item item1 = new Item("one");
        todoList.addItem(item1);
        assertEquals(1, todoList.getCount());
    }
    
    @Test
    public void clearCompleted(){
        TodoList todoList = new TodoList();
        Item itemList = new Item("one");
        Item itemList1 = new Item("two");
        itemList.setCompleted(true);
        todoList.addItem(itemList);
        todoList.addItem(itemList1);
        todoList.removeCompletedItems();
        assertEquals(1, todoList.getCount());
    }
    
    @Test
    public void deleteSome(){
        TodoList todoList = new TodoList();
        Item itemList = new Item("One");
        todoList.addItem(itemList);
        todoList.removeItemByName("One");
        assertEquals(0, todoList.getCount());
    }
    
    @Test
    public void deleteOneOfThree(){
        TodoList todoList = new TodoList();
        Item itemList = new Item("One");
        Item itemList1 = new Item("Two");
        Item itemList2 = new Item("Three");
        todoList.addItem(itemList);
        todoList.addItem(itemList1);
        todoList.addItem(itemList2);
        todoList.removeItemByName("Two");
        assertEquals(2, todoList.getCount());
    }
    
    
    
    @Test
    public void NumberInToDoList(){
        ListOfLists groupTodoLists = new ListOfLists();
        groupTodoLists.add(new TodoList("One"));
        groupTodoLists.add(new TodoList("Two"));
        groupTodoLists.add(new TodoList("Three"));
        groupTodoLists.add(new TodoList("Four"));
        assertEquals(4, groupTodoLists.getCount());
    }
    
    @Test
    public void orderTaskByCompletedComplex(){
        TodoList todoList = new TodoList();
        Item task = new Item("One");
        task.setCompleted(true);
        todoList.addItem(new Item("Two"));
        todoList.addItem(task);
        assertEquals(1, todoList.getItemPosition("One"));
    }
    
    @Test
    public void orderTaskByCompletedSuperComplex(){
        TodoList todoList = new TodoList();
        Item task = new Item("One");
        task.setCompleted(true);
        Item task1 = new Item("Two");
        task1.setCompleted(true);
        todoList.addItem(task);
        todoList.addItem(new Item("Three"));
        todoList.addItem(new Item("Four"));
        todoList.addItem(task1);
        assertEquals(0, todoList.getItemPosition("One"));
    }
    
    @Test
    public void numberInToDoListOfFive(){
        ListOfLists groupTodoLists = new ListOfLists();
        groupTodoLists.add(new TodoList("One"));
        groupTodoLists.add(new TodoList("Two"));
        groupTodoLists.add(new TodoList("Three"));
        groupTodoLists.add(new TodoList("Four"));
        groupTodoLists.add(new TodoList("Five"));
        assertEquals(5, groupTodoLists.getCount());
    }
    
    @Test
    public void notInsertDuplicateInList(){
        ListOfLists groupTodoLists = new ListOfLists();
        groupTodoLists.add(new TodoList("One"));
        groupTodoLists.add(new TodoList("One"));
        assertEquals(1, groupTodoLists.getCount());
    }
    
    @Test
    public void NoteInsertCaseSensitiveDuplicate(){
        ListOfLists groupTodoLists = new ListOfLists();
        groupTodoLists.add(new TodoList("one"));
        groupTodoLists.add(new TodoList("ONE"));
        assertEquals(1, groupTodoLists.getCount());
    }
    
    @Test
    public void removeCaseInsensitive(){
        ListOfLists groupTodoLists = new ListOfLists();
        groupTodoLists.add(new TodoList("one"));
        groupTodoLists.removeTodoListByName("ONE");
        assertEquals(0, groupTodoLists.getCount());
    }
    
    @Test
    public void removeonOfTwoInCase(){
        ListOfLists groupTodoLists = new ListOfLists();
        groupTodoLists.add(new TodoList("One"));
        groupTodoLists.add(new TodoList("Two"));
        groupTodoLists.removeTodoListByName("one");
        assertEquals(1, groupTodoLists.getCount());
    }
    
    @Test
    public void removeUnexisting(){
        ListOfLists groupTodoLists = new ListOfLists();
        groupTodoLists.add(new TodoList("One"));
        groupTodoLists.add(new TodoList("Two"));
        groupTodoLists.removeTodoListByName("Three");
        assertEquals(2, groupTodoLists.getCount());
    }
    
    @Test
    public void orderTaskByCompleted(){
        TodoList todoList = new TodoList();
        Item item = new Item("One");
        item.setCompleted(true);
        todoList.addItem(item);
        todoList.addItem(new Item("Two"));
        assertEquals(0, todoList.getItemPosition("one"));
    }
    

}
