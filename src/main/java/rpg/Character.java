package rpg;

import java.util.Map;
import java.util.Scanner;

public class Character {
    private String name;
    private String characterClass;
    private int hp;
    private int attackPower;
    private int level;
    private int xp;
    private Inventory inventory;

    public Character(String name, String characterClass, int hp, int attackPower, int level, int xp) {
        this.name = name;
        this.characterClass = characterClass;
        this.hp = hp;
        this.attackPower = attackPower;
        this.level = level;
        this.xp = xp;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public Map<String, Integer> getInventory() {
        return inventory.getItems();
    }

    public void displayCharacter(){
        System.out.println("Name : "+name + "\n" + "Character Class : "+characterClass + "\n"
        + "HP : "+hp +"\nAttack Power : "+attackPower+"\nLevel : "+level+ "\nxp : "+xp);
        // This eventory.getItems will be provided later
        System.out.println(inventory.getItems());
    }


    public void takeDamage(int damage) {
        if(hp == 0) {
            System.out.println("Already Dead");
            return;
        }
        if(damage >= hp) {
            System.out.println(name + " : Got Killed");
            hp = 0;
            return;
        }
        hp -= damage;
    }
    public void attackEnemy(Character defender) {
        if (this.hp == 0) {
            System.out.println("Dead characters cannot attack");
            return;
        }

        if(defender.equals(this)) {
            System.out.println("Can't attack yourself");
            return;
        }
        if(defender.hp == 0) {
            System.out.println("Already Dead");
            return;
        }
        defender.takeDamage(this.attackPower);
    }

    public void gainXp(int xpBooster, int acquiredXP) {
        xp += acquiredXP + (acquiredXP*xpBooster)/100;
        int tempLevel = (xp / 100) + 1;
        if(tempLevel > level) {
            hp += (tempLevel-level) * 20;
            attackPower += (tempLevel-level)*5;
        }
        level = tempLevel;
    }

    public void addItem(String item) {
        inventory.addItem(item);
    }

    private Scanner sc = new Scanner(System.in);
    public void useItem(String item) {
        Map<String, Integer> Items = getInventory();
        if(Items.containsKey(item)) {
            if(item.equals("Health Potion")) {
                if(hp > 75) {
                    System.out.println("Can't use healing potion, If have 75% hp");
                    return;
                }
                hp += 25;
            }
            else if(item.equals("Attack Booster")) {
                attackPower += (attackPower*5)/100;
            }else if(item.equals("Rename Card")) {
                System.out.print("Enter Name for character : ");
                name = sc.nextLine();
            }
            inventory.removeItem(item);
        }else{
            System.out.println("Item Not Available");
        }
    }
}
