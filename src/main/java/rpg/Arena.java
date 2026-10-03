package rpg;

import java.util.*;
import java.util.stream.Collectors;

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

    public Optional<Character> searchByName(String name){
        for(Character ch : characterLobby) {
            if(ch.getName().equals(name)) {
                return Optional.of(ch);
            }
        }
        return Optional.empty();
    }

    public Set<Character> searchByLevel(int level) {
        Set<Character> sameLevelCharacter = new HashSet<>();
        for(Character ch : characterLobby) {
            if(ch.getLevel() == level) {
                sameLevelCharacter.add(ch);
            }
        }
        if(sameLevelCharacter.isEmpty()) {
            System.out.println("currently no Character available of your level");
        }
        return sameLevelCharacter;
    }

    public Set<Character> isAliveorDead(String status) {
        Set<Character> alive = new HashSet<>();
        Set<Character> dead = new HashSet<>();
        for(Character ch : characterLobby) {
                if(ch.getHp() == 0) dead.add(ch);
                else alive.add(ch);
        }
        if(Objects.equals(status, "Dead")) return dead;
        else if(Objects.equals(status, "Alive")) return alive;
        return Set.of();
    }

    public Optional<Character> strongestCharacter() {
        return characterLobby.stream()
                .max(Comparator.comparing(Character::getAttackPower));
    }

    public List<Character> sorting(String behaviour, boolean ascending) {

        Comparator<Character> comparator;

        if (Objects.equals(behaviour, "Level")) {
            comparator = Comparator.comparing(Character::getLevel);
        }
        else if (Objects.equals(behaviour, "HP")) {
            comparator = Comparator.comparing(Character::getHp);
        }
        else if (Objects.equals(behaviour, "AttackPower")) {
            comparator = Comparator.comparing(Character::getAttackPower);
        }
        else {
            return List.of();
        }

        if (!ascending) {
            comparator = comparator.reversed();
        }

        return characterLobby.stream()
                .sorted(comparator)
                .toList();
    }

//    //ascend 1 -> sorted in increasing order, 0 -> decreasing order
//    public List<Character> sorting(String behaviour, int ascend) {
//        if(ascend == 1) {
//            if(Objects.equals(behaviour, "Level")) {
//                return characterLobby.stream()
//                        .sorted(Comparator.comparing(Character::getLevel))
//                        .collect(Collectors.toList());
//            }
//
//            if(Objects.equals(behaviour, "HP")) {
//                return characterLobby.stream()
//                        .sorted(Comparator.comparing(Character::getHp))
//                        .collect(Collectors.toList());
//            }
//
//            if(Objects.equals(behaviour, "AttackPower")) {
//                return characterLobby.stream()
//                        .sorted(Comparator.comparing(Character::getAttackPower))
//                        .collect(Collectors.toList());
//            }
//        }else{
//            if(Objects.equals(behaviour, "Level")) {
//                return characterLobby.stream()
//                        .sorted(Comparator.comparing(Character::getLevel).reversed())
//                        .collect(Collectors.toList());
//            }
//
//            if(Objects.equals(behaviour, "HP")) {
//                return characterLobby.stream()
//                        .sorted(Comparator.comparing(Character::getHp).reversed())
//                        .collect(Collectors.toList());
//            }
//
//            if(Objects.equals(behaviour, "AttackPower")) {
//                return characterLobby.stream()
//                        .sorted(Comparator.comparing(Character::getAttackPower).reversed())
//                        .collect(Collectors.toList());
//            }
//        }
//        return new ArrayList<>();
    }
}
