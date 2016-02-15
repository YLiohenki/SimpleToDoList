package nastassia.com.model;

import java.util.Comparator;

import nastassia.com.model.Item;

public class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return Boolean.compare(o1.isCompleted(), o2.isCompleted());
    }

    
}
