package nastassia.com.controllers;

import java.util.HashMap;
import java.util.Map;

import nastassia.com.model.Item;
import nastassia.com.model.TodoList;
import spark.ModelAndView;

import static nastassia.com.main.App.listOfListsRepo;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import spark.template.freemarker.FreeMarkerEngine;

public class ToDoListController {

    private FreeMarkerEngine freeMarkerEngine;

    public ToDoListController(FreeMarkerEngine freeMarkerEngine) {
        this.freeMarkerEngine = freeMarkerEngine;
        getById();
        delById();
        markById();
        addItem();
        clearCompleted();
    }

    private ModelAndView modelAndView(TodoList todoList) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("todo", todoList);
        return new ModelAndView(attributes, "items.ftl");
    }

    private void getById() {
        get("/items/:id", (request, response) -> {
            int id = -1;
            try {
                id = Integer.parseInt(request.params(":id"));
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                return new ModelAndView(null, "error.ftl");
            }
            TodoList todoList = listOfListsRepo.getTodoListById(id);
            if (todoList == null) {
                return new ModelAndView(null, "error.ftl");
            }
            return modelAndView(todoList);
        }, freeMarkerEngine);
    }
    
    private void addItem() {
        post("/items/:idList", (request, response) -> {
            int idList = -1;
            String itemName;
            try {
                idList = Integer.parseInt(request.params(":idList"));
                itemName = request.queryParams("itemName");
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                return new ModelAndView(null, "error.ftl");
            }
            TodoList todoList = listOfListsRepo.getTodoListById(idList);
            todoList.addItem(new Item(itemName));
            return modelAndView(todoList);
        }, freeMarkerEngine);
    }

    private void delById() {
        delete("/items/:idList/:idItem", (request, response) -> {
            int idList = -1;
            int idItem = -1;
            try {
                idList = Integer.parseInt(request.params(":idList"));
                idItem = Integer.parseInt(request.params(":idItem"));
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                return new ModelAndView(null, "error.ftl");
            }
            TodoList todoList = listOfListsRepo.getTodoListById(idList);
            todoList.removeItemByName(todoList.getItemById(idItem).getName());
            return modelAndView(todoList);
        }, freeMarkerEngine);
    }

    private void markById() {
        put("/items/:idList", (request, response) -> {
            int idList = -1;
            int idItem = -1;
            boolean isCompleted;
            try {
                idList = Integer.parseInt(request.params(":idList"));
                idItem = Integer.parseInt(request.queryParams("idItem"));
                isCompleted = Boolean.valueOf(request.queryParams("isCompleted"));
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                return new ModelAndView(null, "error.ftl");
            }
            TodoList todoList = listOfListsRepo.getTodoListById(idList);
            todoList.getItemById(idItem).setCompleted(isCompleted);
            return modelAndView(todoList);
        }, freeMarkerEngine);
    }

    private void clearCompleted() {
        post("/items/:idList/clear", (request, response) -> {
            int idList = -1;
            try {
                idList = Integer.parseInt(request.params(":idList"));
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                return new ModelAndView(null, "error.ftl");
            }
            TodoList todoList = listOfListsRepo.getTodoListById(idList);
            todoList.removeCompletedItems();
            return modelAndView(todoList);
        }, freeMarkerEngine);
    }
}
