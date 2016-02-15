package nastassia.com.model;

public class Item {
    
    private static int lastId = 0;
    private int id;
    private String name;
    private boolean completed;

    public Item() {
        lastId++;
        this.id = lastId;
        this.name = "";
        this.completed = false;
    }
    
    public Item(String name){
        lastId++;
        this.id = lastId;
        setName(name);
        completed = false;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String isCompletedS() {
        String completedS = "0";
        if(completed)
            completedS = "1";
        return completedS;
    }

    public int getId() {
        return id;
    }
}
