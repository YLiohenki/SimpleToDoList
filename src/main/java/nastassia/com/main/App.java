package nastassia.com.main;

import freemarker.template.Configuration;
import nastassia.com.controllers.ListOfListsController;
import nastassia.com.controllers.ToDoListController;
import nastassia.com.model.ListOfLists;
import nastassia.com.model.Item;
import nastassia.com.model.TodoList;

import static spark.Spark.staticFileLocation;
import spark.template.freemarker.FreeMarkerEngine;

public class App {

    public static ListOfLists listOfListsRepo;

    private static void setInitialContents() {
        listOfListsRepo = new ListOfLists();
        Item item1 = new Item("Some complete item 1");
        item1.setCompleted(true);
        Item item2 = new Item("Some incomplete item 2");
        TodoList todoList = new TodoList("1st List");
        todoList.addItem(item1);
        todoList.addItem(item2);
        Item item3 = new Item("Some complete item 3");
        item3.setCompleted(true);
        Item item4 = new Item("Some incompete item 4");
        TodoList todoList1 = new TodoList("2nd List");
        todoList1.addItem(item3);
        todoList1.addItem(item4);
        Item task5 = new Item("Some incompete item 5");
        Item task6 = new Item("Some incompete item 6");
        TodoList todoList2 = new TodoList("3rd List");
        todoList2.addItem(task5);
        todoList2.addItem(task6);
        listOfListsRepo.add(todoList);
        listOfListsRepo.add(todoList1);
        listOfListsRepo.add(todoList2);
    }

    public static void main(String[] args) {
        setInitialContents();
        staticFileLocation("/views");
        FreeMarkerEngine freeMarkerEngine = createTemplateEngine("/views");
        ListOfListsController groupTodoListsController = new ListOfListsController(freeMarkerEngine);
        ToDoListController todoListController = new ToDoListController(freeMarkerEngine);
    }

    private static FreeMarkerEngine createTemplateEngine(String templatePath) {
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, templatePath);
        freeMarkerEngine.setConfiguration(configuration);
        return freeMarkerEngine;
    }
}
