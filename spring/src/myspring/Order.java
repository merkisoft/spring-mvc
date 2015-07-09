package myspring;

import java.util.List;

/**
 * Created by fabian on 09.07.15.
 */
public class Order {
    private String id;
    private List<Item> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
