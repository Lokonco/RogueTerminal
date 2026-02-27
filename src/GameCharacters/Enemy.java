package GameCharacters;

public class Enemy extends Character{
    private int goldReward;

    public Enemy(String name, int health, int AttackDamage, int goldReward){
        super(name, health, AttackDamage);
        this.goldReward = goldReward;
    }

    @Override
    public String toString(){
        return super.toString() + "| Gold: " + goldReward;
    }

    public int getGoldReward(){
        return goldReward;
    }
}
