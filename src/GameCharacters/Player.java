package GameCharacters;

public class Player extends Character {
    private int potions;
    private int gold;
    private int maxHealth;

    public Player(String name){
        super(name, 1, 100); // (Name, Health, AttackDamage)
        this.potions = 1;
        this.gold = 0;
        this.maxHealth = 100;
    }

    public void addGold(int amount){
        gold += amount;
    }

    public void heal(int amount) {
        Health = Math.min(Health + amount, maxHealth);
        System.out.println("Health: " + Health);
    }

    public void usePotion(){
        if(potions > 0){
            heal(30);
            potions--;
            System.out.println("Just drank a nasty potion");
        }
        else{
            System.out.println("No more potions!");
        }
    }

    @Override
    public String toString(){
        return super.toString() + "| Potions: " + potions + "| Gold:" + gold;
    }

    //------Getters-----//
    public int getGold(){
        return gold;
    }

    public int getPotions(){
        return potions;
    }

}
