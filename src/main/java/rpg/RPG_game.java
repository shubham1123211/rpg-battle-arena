package rpg;

import java.util.HashMap;
import java.util.Map;

public class RPG_game {
    static void main(String[] args) {

        /*private String name;
        private String characterClass;
        private int hp;
        private int attackPower;
        private int level;
        private int xp;
        Inventory inventory;*/

        Character shadow = new Character("shadow", "A", 100, 5, 1, 0,
                new Inventory(new HashMap<>(
                        Map.of(
                                "StoneA", 1,
                                "StoneB", 6,
                                "legendary weapon", 0,
                                "Epic weapons", 4,
                                "rare weapons", 10
                        )
                )));

        Character blizzFrost = new Character("BlizzFrost", "B", 100, 2, 1, 0,
                new Inventory(new HashMap<>(
                        Map.of(
                                "StoneA", 1,
                                "StoneB", 2,
                                "legendary weapon", 0,
                                "Epic weapons", 2,
                                "rare weapons", 5
                        )
                )));

        blizzFrost.gainXp(20, 200);
        blizzFrost.displayCharacter();
    }
}
