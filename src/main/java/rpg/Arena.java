package rpg;

import java.util.HashSet;
import java.util.Set;

public class Arena {
    private Set<Character> characterLobby = new HashSet<>();
    public void addCharacter(Character character) {
        if(characterLobby.contains(character)) {
            System.out.println("Character already in lobby");
            return;
        }
        characterLobby.add(character);
    }

    public Set<Character> getAllCharacter(){
        return new HashSet<>(characterLobby);
    }
}
