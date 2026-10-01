package rpg;

import java.util.HashSet;
import java.util.Set;

public class RPG_game {
    static void main(String[] args) {

        /*private String name;
        private String characterClass;
        private int hp;
        private int attackPower;
        private int level;
        private int xp;
        Inventory inventory;*/

        Character shadow = new Character("shadow", "A", 100, 5, 1, 0);

        Character blizzFrost = new Character("BlizzFrost", "B", 100, 2, 1, 0);

        blizzFrost.gainXp(20, 200);
        blizzFrost.displayCharacter();

        Set<Character> newSet = new HashSet<>();
        newSet.
    }
}
