package rpg;

import java.util.Map;

public class Inventory {
    private Map<String, Integer> items;

    public Inventory(Map<String, Integer> items) {
        this.items = items;
    }

    public Map<String, Integer> getItems() {
        return Map.copyOf(items);
    }
}
