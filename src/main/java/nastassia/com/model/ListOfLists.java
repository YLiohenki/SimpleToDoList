package nastassia.com.model;

import java.util.ArrayList;

public class ListOfLists {

    private ArrayList<TodoList> todoLists;

    public ListOfLists() {
        todoLists = new ArrayList<>();
    }

    public void add(TodoList todoList) {
        if(getTodoByName(todoList.getName()) == null){
            todoLists.add(todoList);
        }
    }

    public int getCount() {
        return todoLists.size();
    }

    public TodoList getTodoByName(String name) {
        name = name.toLowerCase();
        for (TodoList todo : todoLists) {
            if (todo.getName().toLowerCase().equals(name)) {
                return todo;
            }
        }
        return null;
    }

    public void removeTodoListByName(String name) {
        name = name.toLowerCase();
        for (TodoList todo : todoLists) {
            if (todo.getName().toLowerCase().equals(name)) {
                todoLists.remove(todo);
                break;
            }
        }
    }

    public int getTodoPosition(String name) {
        name = name.toLowerCase();
        for(int i = 0; i < todoLists.size(); i++){
            if(todoLists.get(i).getName().toLowerCase().equals(name))
                return i;
        }
        return -1;
    }

    public ArrayList<TodoList> getTodoLists(){
        return todoLists;
    }
    
    public TodoList getTodoListById(int id){
        for (TodoList todo : todoLists) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
