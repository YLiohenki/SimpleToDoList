package nastassia.com.controllers;

import java.util.HashMap;
import java.util.Map;

import nastassia.com.model.TodoList;
import spark.ModelAndView;

import static nastassia.com.main.App.listOfListsRepo;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import spark.template.freemarker.FreeMarkerEngine;

public class ListOfListsController {

    private FreeMarkerEngine freeMarkerEngine;

    public ListOfListsController(FreeMarkerEngine freeMarkerEngine) {
        this.freeMarkerEngine = freeMarkerEngine;
        setIndex();
        addList();
        delById();
    }

    private ModelAndView modelAndView() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("groupTodoLists", listOfListsRepo);
        return new ModelAndView(attributes, "lists.ftl");
    }

    private void setIndex() {
        get("/", (request, response) -> {
            return modelAndView();
        }, freeMarkerEngine);
    }

    private void addList() {
        post("/", (request, response) -> {
            String listName = request.queryParams("listName");
            listOfListsRepo.add(new TodoList(listName));
            return modelAndView();
        }, freeMarkerEngine);
    }

    private void delById() {
        delete("/", (request, response) -> {
            String listName = request.queryParams("listName");
            listOfListsRepo.removeTodoListByName(listName);
            return modelAndView();
        }, freeMarkerEngine);
    }
}
