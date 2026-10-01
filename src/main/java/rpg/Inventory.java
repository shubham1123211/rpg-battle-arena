package rpg;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items = new HashMap<>();


    public Map<String, Integer> getItems() {
        return Map.copyOf(items);
    }

    public void addItem(String earnedItem) {
        items.put(earnedItem, items.getOrDefault(earnedItem, 0)+1);
    }

    public void removeItem(String itemToRemove) throws ItemNotFoundException{
        if(items.containsKey(itemToRemove)) {
            items.put(itemToRemove, items.get(itemToRemove)-1);
            if(items.get(itemToRemove) == 0) {
                items.remove(itemToRemove);
            }
        }else{
            throw new ItemNotFoundException("Item Not Found : "+itemToRemove);
        }
    }
}
