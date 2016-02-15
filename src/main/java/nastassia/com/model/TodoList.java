package nastassia.com.model;

import java.util.ArrayList;
import java.util.Collections;

public class TodoList {

    private static int lastId = 0;
    private int id;
    private String name;
    private ArrayList<Item> items;

    public TodoList() {
        lastId++;
        this.id = lastId;
        this.name = "";
        this.items = new ArrayList<>();
    }

    public TodoList(String name) {
        lastId++;
        this.id = lastId;
        this.items = new ArrayList<>();
        setName(name);
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public String getNameWithNumber() {
        return name + " (" + getIncompletedItems() + ")";
    }

    public void addItem(Item newItem) {
        if (getItemByName(newItem.getName()) == null) {
            items.add(newItem);
        }
    }

    public Item getItemByName(String name) {
        name = name.toLowerCase();
        for (Item item : items) {
            if (item.getName().toLowerCase().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public int getCount() {
        return items.size();
    }

    public void removeItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                items.remove(item);
                break;
            }
        }
    }

    public void removeCompletedItems() {
        for (int i = items.size() -1; i >= 0; i--){
            if(items.get(i).isCompleted()){
                items.remove(i);
            }
        }
    }

    public int getIncompletedItems() {
        int count = 0;
        for (Item item : items) {
            if (!item.isCompleted()) {
                count++;
            }
        }
        return count;
    }

    public int getItemPosition(String name) {
        name = name.toLowerCase();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().toLowerCase().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Item getItemById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        Collections.sort(items, new ItemComparator());
        return this.items;
    }

    public int getId() {
        return this.id;
    }
}
